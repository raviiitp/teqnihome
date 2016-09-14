package com.teqnihome2.configuration;

import java.net.URI;
import java.net.URISyntaxException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.teqnihome2.entity.TeamStructure;

@Configuration
public class Congifuration extends WebMvcConfigurerAdapter {

/*	@Bean
	public DataSource getDataSource() {
		String databaseUrl = System.getenv("DATABASE_URL");

		URI dbUri;
		try {
			dbUri = new URI(databaseUrl);
		} catch (URISyntaxException e) {
			return null;
		}

		String username = dbUri.getUserInfo().split(":")[0];
		String password = dbUri.getUserInfo().split(":")[1];
		String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnReturn(true);
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}*/
	
	@Bean
	public DataSource getDataSource() {
		
		org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://localhost:5432/teqnihome?useSSL=false");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnReturn(true);
		dataSource.setValidationQuery("SELECT 1");
		return dataSource;
	}

	@Bean
	public LocalSessionFactoryBean SessioFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(getDataSource());
		sessionFactoryBean.setAnnotatedClasses(TeamStructure.class);
		return sessionFactoryBean;
	}

	/*
	 * @Bean public SessionFactory buildSessionFactory() { try { // Create the
	 * SessionFactory from hibernate.cfg.xml return new
	 * Configuration().configure().buildSessionFactory(); } catch (Throwable ex)
	 * { // Make sure you log the exception, as it might be swallowed
	 * System.err.println("Initial SessionFactory creation failed." + ex); throw
	 * new ExceptionInInitializerError(ex); } }
	 */
}