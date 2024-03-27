package com.example.demo.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


@Configuration
public class DatabaseConfig {
	
	//데이타 베이스 연결정보 주입
	@Value("${spring.datasource.driver-class-name}")
	private String driver;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	
	@Bean
	DataSource dataSource() {
		System.out.println(user);
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName(driver);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(user);
		hikariConfig.setPassword(password);
		
		return new HikariDataSource(hikariConfig);
	}
	
	@Bean
	DataSourceTransactionManager transactionManager(HikariDataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}	
	@Bean
	TransactionTemplate transactionTemplate(DataSourceTransactionManager transactionManager) {
		TransactionTemplate transactionTemplate= new TransactionTemplate();
		transactionTemplate.setTransactionManager(transactionManager);
		return transactionTemplate;
	}
}
