package com.store.medicine.config;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@EnableWebMvc
@ComponentScans(value= {
		@ComponentScan("com.store.medicine.dao"),
		@ComponentScan("com.store.medicine.services")
})
public class AppConfig {
	@Autowired
	private Environment env;

	@Bean
	public LocalSessionFactoryBean getLocalBean() {
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		Properties prop=new Properties();
		System.out.println("cHECK IT OUT");
		System.out.println(env.getProperty("mysql.driver"));
		prop.put(DRIVER,"com.mysql.jdbc.Driver");
		prop.put(URL,env.getProperty("mysql.url"));
		prop.put(USER,env.getProperty("mysql.username"));
		prop.put(PASS,env.getProperty("mysql.password"));
	
		prop.put(SHOW_SQL,env.getProperty("hibernate.show_sql"));
		prop.put(DIALECT, env.getProperty("hibernate.dialect"));
		prop.put(HBM2DDL_AUTO,env.getProperty("hibernate.hbm2ddl.auto"));
		prop.put(C3P0_MAX_SIZE,env.getProperty("hibernate.c3p0.min_size"));
		prop.put(C3P0_MIN_SIZE,env.getProperty("hibernate.c3p0.max_size"));
		prop.put(C3P0_ACQUIRE_INCREMENT,env.getProperty("hibernate.c3p0.acquire_increament"));
		
		prop.put(C3P0_TIMEOUT,env.getProperty("hibernate.c3p0.timeout"));
		prop.put(C3P0_MAX_STATEMENTS,env.getProperty("hibernate.c3p0..max_statements"));

		localSessionFactoryBean.setHibernateProperties(prop);
		localSessionFactoryBean.setPackagesToScan("com.store.medicine.bean");
		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(getLocalBean().getObject());
		return hibernateTransactionManager;
	}
}
