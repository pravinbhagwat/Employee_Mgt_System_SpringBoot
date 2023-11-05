//package com.digitox.Employee_Management_System.config;
//
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Primary;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableTransactionManagement
//@EnableJpaRepositories(
//        basePackages = "com.digitox.Employee_Management_System.repositories.postgres",
//        entityManagerFactoryRef = "postgresEntityManagerFactory",
//        transactionManagerRef = "postgresTransactionManager"
//)
//public class PostgresDbConfig {
//
//    @Primary
//    @Bean(name = "postgresDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource-postgres")
//    public DataSource dataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    // Define other beans for EntityManagerFactory and TransactionManager
//}