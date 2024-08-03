package com.mowitnow.batch.reader;

import com.mowitnow.Exception.ApplicationException;
import com.mowitnow.Exception.ExceptionTondeuse;
import com.mowitnow.batch.dto.Data;
import org.springframework.batch.core.scope.context.StepSynchronizationManager;
import org.springframework.batch.item.*;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import java.util.Objects;

/**
 * This class ensures the sequential reading of data from a file.
 * @author Fakher Saafi
 */
@Component
public class BatchItemReader implements ItemReader<FlatFileItemReader<Data>> {

    @Value( "${inputFile}" )
    private Resource inputFile;

    public FlatFileItemReader<Data> read() throws ExceptionTondeuse {
        FlatFileItemReader<Data> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setName("TXT-READER");

        flatFileItemReader.setSkippedLinesCallback(line -> {
            ExecutionContext jobContext = Objects.requireNonNull(StepSynchronizationManager.getContext()).getStepExecution().getJobExecution().getExecutionContext();
            jobContext.put("pelouse", line);
        });
        if (!inputFile.exists()) throw new ExceptionTondeuse(ApplicationException.ERROR_FILE_INEXISTENT);
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
