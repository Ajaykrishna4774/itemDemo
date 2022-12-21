package com.capgemini.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
@Configuration
public class DatabaseInitializer {
	 @Autowired JdbcTemplate jdbcTemplate;

	    @Bean
	    CommandLineRunner loadDatabase() {
	        return new CommandLineRunner() {
	             
	            @Override
	            public void run(String... args) throws Exception {
	                 
	                jdbcTemplate.execute("create table item (id int primary key, name varchar(50), category varchar(50) )");
	                 
	                jdbcTemplate.execute("INSERT INTO `item` (`id`, `name`, `category`) VALUES (1, 'IPhone 6S', 'Mobile');");
	                 
	                jdbcTemplate.execute("INSERT INTO `item` (`id`, `name`, `category`) VALUES (2, 'Samsung Galaxy', 'Mobile');");
	                 
	                jdbcTemplate.execute("INSERT INTO `item` (`id`, `name`, `category`) VALUES (3, 'Lenovo', 'Laptop');");
	                
	                jdbcTemplate.execute("INSERT INTO `item` (`id`, `name`, `category`) VALUES (4, 'LG', 'Telivision');");
	            }
	        };
	    }
}
