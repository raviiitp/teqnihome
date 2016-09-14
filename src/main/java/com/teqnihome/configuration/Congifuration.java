package com.teqnihome.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.teqnihome.entity.TeamStructure;

@Configuration
public class Congifuration extends WebMvcConfigurerAdapter {

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/teqnihome?autoReconnect=true&useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		
		
		return dataSource;
	}

	@Bean(name="SessionFactory")
	public LocalSessionFactoryBean SessioFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setAnnotatedClasses(TeamStructure.class);
		return sessionFactoryBean;
	}
}