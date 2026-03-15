package com.coforge.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = "com.coforge")
public class Appconfig {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dSource = new DriverManagerDataSource();
		dSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dSource.setUrl("jdbc:mysql://localhost:3306/bank");
		dSource.setUsername("root");
		dSource.setPassword("root");
		return dSource;
		
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dSource)
	{
		return new JdbcTemplate(dSource);
	}
}
