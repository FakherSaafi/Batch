package com.mowitnow.batch.reader;

import com.mowitnow.batch.dto.Data;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.scope.context.StepSynchronizationManager;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.Objects;

/**
 * Cette classe assure la lecture séquentielle des données à partir d'un fichier
 * @author Fakher Saafi
 */
@Component
public class BatchItemReader implements ItemReader<FlatFileItemReader<Data>> {

    @Value( "${inputFile}" )
    private Resource inputFile;

    public FlatFileItemReader<Data> read() {
        FlatFileItemReader<Data> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setName("TXT-READER");

        flatFileItemReader.setSkippedLinesCallback(line -> {
            ExecutionContext jobContext = Objects.requireNonNull(StepSynchronizationManager.getContext()).getStepExecution().getJobExecution().getExecutionContext();
            jobContext.put("pelouse", line);
        });
        flatFileItemReader.setResource(inputFile);

        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;
    }

    public LineMapper<Data> lineMapper() {
        DefaultLineMapper<Data> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setStrict(true);
        lineTokenizer.setNames("line");

        lineMapper.setLineTokenizer(lineTokenizer);

        BeanWrapperFieldSetMapper<Data> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Data.class);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        return lineMapper;
    }

}
