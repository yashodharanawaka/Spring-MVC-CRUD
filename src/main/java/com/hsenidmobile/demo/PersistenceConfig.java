/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/5/20, 12:08 PM.
 *//*


package com.hsenidmobile.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class PersistenceConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("root");
        dataSource.setPassword("1105");
        dataSource.setUrl(
                "jdbc:mysql://localhost:3306/demoDB?createDatabaseIfNotExist=true");

        return dataSource;
    }
}
*/
