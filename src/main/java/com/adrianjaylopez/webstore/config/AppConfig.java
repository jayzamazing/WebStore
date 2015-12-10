package com.adrianjaylopez.webstore.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 * @author Adrian J Lopez
 * @version 1.2
 * @since <pre>11/30/15</pre>
 */
@Configuration
@EnableTransactionManagement
@ComponentScan("com.adrianjaylopez.webstore")
public class AppConfig {

    @Value("${database.url}")
    private String dtbUrl;
    @Value("${database.username}")
    private String dtbUsername;
    @Value("${database.password}")
    private String dtbPassword;


    /**
     * Method configures database
     * @return datasource(mysql)
     */
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setTestOnBorrow(true);
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setUrl(dtbUrl);
        dataSource.setUsername(dtbUsername);
        dataSource.setPassword(dtbPassword);
        return dataSource;
    }

    /**
     * Method to set up entity manager to communicate to datasource.
     * @param dataSource to communicate with
     * @return entitymanagerfactorybean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setPackagesToScan("com.adrianjaylopez.webstore.dao");
        entityManagerFactoryBean.setPersistenceProvider(new HibernatePersistenceProvider());
        Properties prop = new Properties();
        prop.setProperty("hibernate.hbm2ddl.auto", "update");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        entityManagerFactoryBean.setJpaProperties(prop);
        entityManagerFactoryBean.setDataSource(dataSource);
        return entityManagerFactoryBean;
    }

    /**
     * Method to create transation manager to store and retrieve data between the entity and database.
     * @param entityManagerFactory intermediary
     * @return transation manager
     */
    @Bean
    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory){

        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

}
