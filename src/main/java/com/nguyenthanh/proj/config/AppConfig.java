//package com.nguyenthanh.proj.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.annotation.EnableTransactionManagement;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.PersistenceException;
//import java.sql.Driver;
//import java.util.Properties;
//
//@Configuration
//@ComponentScan("com.nguyenthanh")
//@EnableTransactionManagement
//public class AppConfig {
//    @Bean(name = "entityManager")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(){
//        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
//        entityManager.setDataSource(entityManager.getDataSource());
//        entityManager.setPackagesToScan(new String[]{ "com.nguyenthanh.model"});
//
//        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//        entityManager.setJpaVendorAdapter(vendorAdapter);
//        entityManager.setJpaProperties(additionProperties());
//
//        return entityManager;
//    }
//
//    @Bean
//    public DriverManagerDataSource dataSource(){
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//        dataSource.setUrl("jdbc:oracle:thin:@localhost:1522/orcl1");
//        dataSource.setUsername("system");
//        dataSource.setPassword("12345678aA@");
//        return dataSource;
//    }
//
//    @Bean
//    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(emf);
//        return transactionManager;
//    }
//
//    @Bean
//    public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor(){
//        return new PersistenceExceptionTranslationPostProcessor();
//    }
//
//    public Properties additionProperties(){
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle12cDialect");
//        return properties;
//    }
//}
