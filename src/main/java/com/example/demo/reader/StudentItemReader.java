package com.example.demo.reader;

import com.example.demo.db.Student;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

public class StudentItemReader extends FlatFileItemReader<Student> {


    public StudentItemReader() {

        this.setResource(new ClassPathResource("data.csv"));
        this.setLineMapper(getLineMapper());
        this.setLinesToSkip(1);
    }

    private LineMapper<Student> getLineMapper() {
        DefaultLineMapper<Student> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();

        String[] columnsToBeInserted = new String[]{"nom", "prenom", "age", "email"};
        int[] fields = new int[]{0, 1, 2, 3};
        tokenizer.setNames(columnsToBeInserted);
        tokenizer.setIncludedFields(fields);
        BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Student.class);
        lineMapper.setLineTokenizer(tokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }


}
