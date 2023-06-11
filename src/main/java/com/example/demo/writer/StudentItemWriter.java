package com.example.demo.writer;

import com.example.demo.dto.StudentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;


public class StudentItemWriter extends FlatFileItemWriter<StudentDto> {

    public static final Logger LOGGER = LoggerFactory.getLogger(StudentItemWriter.class);

    public StudentItemWriter() {

        LOGGER.info("Writing in the output file: ");
        this.setResource(new FileSystemResource("output.csv"));
        this.setAppendAllowed(true);
        this.setLineAggregator(new DelimitedLineAggregator<StudentDto>() {
            {
                setDelimiter(",");
                setFieldExtractor(new BeanWrapperFieldExtractor<StudentDto>() {
                    {
                        setNames(new String[]{"nom", "prenom", "age", "email"});
                    }
                });
            }
        });
    }

}
