package com.kshrd._2_chhim_pojim_pp_spring_homework003.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource(
                "jdbc:postgresql://localhost:5432/homework003_db",
                System.getenv("DB_USERNAME"),
                System.getenv("DB_PASSWORD")
        );
        return dataSource;
    }
}
