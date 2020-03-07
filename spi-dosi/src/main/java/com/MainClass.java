package com;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.dosi.models.Qualificatif;
import com.dosi.repository.*; 

@SpringBootApplication
public class MainClass{
	

	
	 
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
    }
    
	
	/*
	 * @Bean public CommandLineRunner userDemo(QualificatifRepository qRepository) {
	 * return (args) -> { //qRepository.save(new Qualificatif(25L,"aaa","dddd"));
	 * 
	 * }; }
	 */
	 
}
