/*
@author: agohar
since : 6/22/2019
*/
package com.amr.web;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Value("${database.url}")
    private String url;
    @Value("${database.user}")
    private String user;
    @Value("${database.password}")
    private String password;
    @Value("${database.driver-class-name}")
    private String driver;



    @Bean(name = "dataSource")
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setTestOnBorrow(true);
        dataSource.setTestOnReturn(true);
        dataSource.setTestWhileIdle(true);
        dataSource.setMaxWait(-1);
        dataSource.setMaxActive(50);
        dataSource.setMaxIdle(8);
        dataSource.setMinIdle(4);
        dataSource.setTestOnBorrow(true);
        dataSource.setTimeBetweenEvictionRunsMillis(1800000);
        dataSource.setNumTestsPerEvictionRun(3);
        dataSource.setMinEvictableIdleTimeMillis(1800000);
        return dataSource;
    }

    @Bean(name = "jdbcTemplate")
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(){
        return new  JdbcTemplate(dataSource());
    }

}
