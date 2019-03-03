package com.prasad.registration;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.prasad.registration.dao.UserDao;
import com.prasad.registration.dao.UserDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;

//@Configuration

@Service
public class DataSourceConfiguration {
 
	 
    public DataSource dataSource() {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }
    
   
	 
//	 @Bean
//	    public JdbcTemplate jdbcTemplate() {
//	        JdbcTemplate jdbcTemplate = new JdbcTemplate();
//	        jdbcTemplate.setDataSource(dataSource());
//	        return jdbcTemplate;
//	    }
//	 
//	    @Bean
//	    public UserDao userDAO(){
//	        UserDaoImpl userDao = new UserDaoImpl();
//	        userDao.setJdbcTemplate(jdbcTemplate());
//	        return userDao;
//	    }
    
	
//	public StudentDAOImpl getContactDAO() {
//		return new StudentDAOImpl(getDataSource());
//	}
}

/*
 * 
 
 
@Configuration
@ComponentScan(basePackages="net.codejava.spring")
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
		dataSource.setUsername("root");
		dataSource.setPassword("P@ssw0rd");
		
		return dataSource;
	}
	
	@Bean
	public ContactDAO getContactDAO() {
		return new ContactDAOImpl(getDataSource());
	}
}

 
 
 * */
