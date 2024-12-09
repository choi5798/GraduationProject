package com.example.springjvm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SpringJvmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJvmApplication.class, args);
    }

}

@RestController
class HelloController {

    @GetMapping("/")
    public String hello() {
        return "Hello Spring Jvm!!";
    }
}
