package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import javax.sql.DataSource;

@ComponentScan({"com.dao","com.dao.impl","com.service", "com.service.impl", "controller"})
@SpringBootApplication
public class Application {
	
	@Autowired
    static DataSource dataSource;

    public static void main(String[] args) {
    	

        SpringApplication.run(Application.class, args);
        System.out.println("DATASOURCE = " + dataSource);

    }
}
