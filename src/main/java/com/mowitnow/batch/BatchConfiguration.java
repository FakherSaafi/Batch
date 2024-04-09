package com.mowitnow.batch;

import com.mowitnow.batch.reader.BatchItemReader;
import com.mowitnow.batch.writer.BatchItemWriter;
import com.mowitnow.batch.dto.Data;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired private JobBuilderFactory jobBuilderFactory;
    @Autowired private StepBuilderFactory stepBuilderFactory;
    @Autowired private BatchItemReader batchItemReader;
    @Autowired private BatchItemWriter batchItemWriter;

    @Bean
    public Job batchJob() throws Exception {
        Step step = stepBuilderFactory.get("step_load_data")
                        .<Data, Data>chunk(2)
                        .reader(Objects.requireNonNull(batchItemReader.read()))
                        .writer(batchItemWriter)
                        .build();

        return jobBuilderFactory.get("tondeuse_data_loader_job")
                .start(step)
                .build();
    }

}
