package com.example.demo.processor;

import com.example.demo.db.Student;
import com.example.demo.dto.StudentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class StudentItemProcessor implements ItemProcessor<Student, StudentDto> {

    public static final Logger LOGGER = LoggerFactory.getLogger(StudentItemProcessor.class);

    @Override
    public StudentDto process(Student item) throws Exception {

        LOGGER.info("Processing Students to DTOs: ");
        StudentDto studentDto = new StudentDto();
        studentDto.setNom(item.getNom());
        studentDto.setAge(item.getAge());
        studentDto.setEmail(item.getEmail());
        studentDto.setPrenom(item.getPrenom());

        int preferredNumber = Integer.parseInt(item.getEmail().replaceAll("\\D", ""));

        studentDto.setPreferredNumber(preferredNumber);

        return studentDto;
    }
}
