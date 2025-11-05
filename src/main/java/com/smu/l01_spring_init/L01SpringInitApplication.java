package com.smu.l01_spring_init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L01SpringInitApplication {

    public static void main(String[] args) { //구동되는 앱은 main이 있음. main을 실행~ main은 내장톰캣을 실행함!
        SpringApplication.run(L01SpringInitApplication.class, args);
    }

}
