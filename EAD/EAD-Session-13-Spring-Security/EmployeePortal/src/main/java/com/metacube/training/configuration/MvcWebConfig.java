package com.metacube.training.configuration;

import java.util.Properties;

import javax.sql.DataSource;


import org.hibernate.ejb.HibernatePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

//import com.metacube.training.model.Employee;
//import com.metacube.training.model.JobDetail;
//import com.metacube.training.model.JobTitle;
//import com.metacube.training.model.Project;
//import com.metacube.training.model.Skill;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.metacube.training")
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
@EnableJpaRepositories("com.metacube.training.repository")
public class MvcWebConfig implements WebMvcConfigurer{

	@Autowired
	Environment environment;

	private final String URL = "url";
	private final String USER = "dbuser";
	private final String DRIVER = "driver";
	private final String PASSWORD = "dbpassword";

	@Autowired
	private ApplicationContext applicationContext;

	/*
	 * Create SpringResourceTemplateResolver
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(applicationContext);
		templateResolver.setPrefix("/WEB-INF/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML");
		return templateResolver;
	}

	/*
	 * Create SpringTemplateEngine
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		return templateEngine;
	}

	/*
	 * Register ThymeleafViewResolver
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(templateEngine());
		registry.viewResolver(resolver);
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
		entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
		entityManagerFactoryBean.setPackagesToScan(environment.getProperty("entitymanager.packages.to.scan"));
		entityManagerFactoryBean.setJpaProperties(hibProperties());

		return entityManagerFactoryBean;
	}
	
	  
	 
	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",	environment.getProperty("hibernate.dialect"));
		properties.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));

		return properties;
	}
	
	@Bean
	public JpaTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

		return transactionManager;
	}
	
//	@Bean
//	public LocalSessionFactoryBean getSessionFactory() {
//	    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//	    factoryBean.setDataSource(dataSource());
//	    
//	    Properties props = new Properties();
//	    
//	    // Setting Hibernate properties
//	    props.put("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//	    props.put("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
//
//	    factoryBean.setHibernateProperties(props);
//	    factoryBean.setAnnotatedClasses(Project.class, Employee.class, JobTitle.class, Skill.class, JobDetail.class);
//	    
//	    return factoryBean;
//	  }
//
//	@Bean
//	public HibernateTransactionManager getTransactionManager() {
//	    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//	    transactionManager.setSessionFactory(getSessionFactory().getObject());
//	    return transactionManager;
//	  }

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		return driverManagerDataSource;
	}
}
