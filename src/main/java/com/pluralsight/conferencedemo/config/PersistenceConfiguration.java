package com.pluralsight.conferencedemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
//
//    // TODO: fix maven package error related to this
////    @Value("${spring.datasource.url}")
//    private String url;
//
////    @Value("${spring.datasource.username}")
//    private String username;
//
////    @Value("${spring.datasource.password}")
//    private String password;
//
//    // Spring looks for a DataSource bean in the app context and overwrites it with the one returned by this method.
//    @Bean   // We need this @Bean annotation because it has to return a DataSource bean.
//    public DataSource dataSource() {
//        DataSourceBuilder builder = DataSourceBuilder.create();
//        builder.url("jdbc:postgresql://localhost:5432/conference_db");    // for running it locally
//        builder.username("postgres");
//        builder.password("Welcome");
//
//        System.out.println("Doing some crazy stuff like sending an email to the admin...");
//        System.out.println("Custom DataSource bean has been initialized and set");
//
//        return builder.build();
//    }

}
