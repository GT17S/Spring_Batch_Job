package com.example.demo.processor;

import com.example.demo.db.Student;
import com.example.demo.dto.StudentDto;
import org.springframework.batch.item.ItemProcessor;

public class StudentItemProcessor implements ItemProcessor<Student, StudentDto> {


    @Override
    public StudentDto process(Student item) throws Exception {

        StudentDto studentDto = new StudentDto();
        studentDto.setNom(item.getNom());
        studentDto.setAge(item.getAge());
        studentDto.setEmail(item.getEmail());
        studentDto.setPrenom(item.getPrenom());

        return studentDto;
    }
}
