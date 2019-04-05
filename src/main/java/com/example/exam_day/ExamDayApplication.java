package com.example.exam_day;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ExamDayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamDayApplication.class, args);
    }

}
