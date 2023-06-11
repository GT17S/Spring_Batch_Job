package com.example.demo.job;

import com.example.demo.db.Student;
import com.example.demo.dto.StudentDto;
import com.example.demo.processor.StudentItemProcessor;
import com.example.demo.reader.StudentItemReader;
import com.example.demo.writer.StudentItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class StudentJob {
    
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public StudentItemWriter writer() {
        return new StudentItemWriter();
    }

    @Bean
    public StudentItemReader reader() {
        return new StudentItemReader();
    }

    @Bean
    public StudentItemProcessor processor() {
        return new StudentItemProcessor();
    }

    @Bean("sampleJob")
    public Job sampleJob() {
        return new JobBuilder("sampleJob", jobRepository)
                .start(step1())
                .build();
    }

    @Bean("step1")
    public Step step1() {
        return new StepBuilder("step1", jobRepository)
                .<Student, StudentDto>chunk(10, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }


}
