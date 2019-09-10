package com.hpSpring.configuration;

import java.sql.DriverManager;
import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.hpSpring.model.Employee;
import com.mchange.v2.c3p0.DriverManagerDataSource;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.hpSpring")
public class WebConfig {

	@Bean
	public DriverManagerDataSource dbSourse()
	{
		DriverManagerDataSource db = new DriverManagerDataSource();
		db.setDriverClass("com.mysql.jdbc.Driver");
		db.setJdbcUrl("jdbc:mysql://localhost/mydb");
		db.setUser("sagar");
		db.setPassword("Sagar@1996");
		
		return db;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory()
	{
		LocalSessionFactoryBean sf =new LocalSessionFactoryBean();
		sf.setDataSource(dbSourse());
		Properties hpProperties =new Properties();
		
		hpProperties.put("hibernate.show_sql", true);
		hpProperties.put("hibernate.hbm2ddl.auto", "update");
		hpProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		
		
		sf.setHibernateProperties(hpProperties);
		sf.setAnnotatedClasses(Employee.class);
	
		
		return sf;
		
	}
	
	@Bean
	HibernateTransactionManager hbTransactionManager()
	{
		HibernateTransactionManager hbt =new HibernateTransactionManager();
		hbt.setSessionFactory(getSessionFactory().getObject());
		return hbt;
	}
	
}
