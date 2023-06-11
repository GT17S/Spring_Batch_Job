package com.example.demo.writer;

import com.example.demo.dto.StudentDto;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.core.io.FileSystemResource;


public class StudentItemWriter extends FlatFileItemWriter<StudentDto> {


    public StudentItemWriter() {


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
