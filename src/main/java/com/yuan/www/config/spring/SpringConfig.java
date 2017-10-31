package com.yuan.www.config.spring;

import java.io.IOException;
import java.util.Properties;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.yuan.www"})
@EnableTransactionManagement//等价于  <tx:annotation-driven transaction-manager="transactionManager"/>
public class SpringConfig {
  
	@Bean(name="dataSource")
	public DataSource getDataSource() throws IOException{
		Properties properties =new Properties();
		properties.load(this.getClass().getResourceAsStream("/spring-jdbc.properties")); 
		
		DataSource dataSource =new DataSource();
		
		dataSource.setDriverClassName(properties.getProperty("jdbc.driver"));
		dataSource.setUrl(properties.getProperty("jdbc.url"));
		dataSource.setUsername(properties.getProperty("jdbc.username"));
		dataSource.setPassword(properties.getProperty("jdbc.password"));
		
		return dataSource;
	}
	
	
	@Bean(name="sessionFactory")
	public LocalSessionFactoryBean getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBean localSessionFactoryBean = new LocalSessionFactoryBean();
		localSessionFactoryBean.setDataSource(dataSource);
		/*这里需要注意，开启Hibernate扫描model类*/
		localSessionFactoryBean.setPackagesToScan("com.yuan.www.main.model");
		Properties properties =new Properties();
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.format_sql", "true");
		
		localSessionFactoryBean.setHibernateProperties(properties);
		
		return localSessionFactoryBean;
	}
	@Bean(name="transationManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
		
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory);
		 
		return hibernateTransactionManager;
	}
	

}
