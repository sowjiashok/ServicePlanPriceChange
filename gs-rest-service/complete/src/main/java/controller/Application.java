package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"validator", "com.dao","com.dao.impl","com.service", "com.service.impl", "controller"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
    	

        SpringApplication.run(Application.class, args);

    }
}
