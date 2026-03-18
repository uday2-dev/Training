package com.coforge.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.coforge")
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class AppConfig {
	@Autowired
	private Environment env ;
	@Bean
	public InternalResourceViewResolver viewResolver()
	{
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfig()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dSource = new DriverManagerDataSource();
		dSource.setDriverClassName(env.getProperty("db.driver"));
		dSource.setUrl(env.getProperty("db.url"));
		dSource.setUsername(env.getProperty("db.username"));
		dSource.setPassword(env.getProperty("db.password"));
		return dSource;
		
	}
	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dSource)
	{
		return new JdbcTemplate(dSource);
	}

}