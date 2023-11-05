//package com.digitox.Employee_Management_System.config;
//
//import com.mongodb.client.MongoClient;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.core.MongoTemplate;
//
//@Configuration
//public class MongoDbConfig {
//
//    @Value("${spring.data.mongodb.database}")
//    private String databaseName;
//
//    // Spring Boot will create a MongoClient bean by default, so you can just inject it
//    @Bean
//    public MongoTemplate mongoTemplate(MongoClient mongoClient) {
//        return new MongoTemplate(mongoClient, databaseName);
//    }
//}