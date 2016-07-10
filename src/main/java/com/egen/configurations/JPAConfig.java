package com.egen.configurations;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan
public class JPAConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean getFactoryBean()
	{
		LocalContainerEntityManagerFactoryBean facBean = new LocalContainerEntityManagerFactoryBean();
		facBean.setDataSource(getDataSource());
		facBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		facBean.setJpaDialect(new HibernateJpaDialect());
		facBean.setJpaProperties(getProperties());
		facBean.setPackagesToScan("/*");
		return facBean;
	}
	
	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/movieflix");
		ds.setUsername("root");
		ds.setPassword("root");
		
		return ds;
	}
	
	@Bean
	public PlatformTransactionManager getManager()
	{
		return new JpaTransactionManager();
	}
	
	
	public Properties getProperties()
	{
		
			Properties prop = new Properties();
			prop.setProperty("hibernate.show_sql", "true");
			prop.setProperty("hibernate.format_sql", "true");
			prop.setProperty("hibernate.hbm2ddl.auto", "validate");
			prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
			
			return prop;
		
	}
	
}
