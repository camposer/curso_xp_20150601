package com.rodolfoxp.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.rodolfoxp.repository")
@ComponentScan(basePackages = "com.rodolfoxp.service")
@EnableTransactionManagement
public class JpaConfig {

  @Bean
  public EntityManagerFactory entityManagerFactory() {
    return Persistence.createEntityManagerFactory("rodolfoxp");
  }

  @Bean(name = "entityManager")
  public EntityManager getEntityManager() {
    return entityManagerFactory().createEntityManager();
  }

  @Bean
  public PlatformTransactionManager transactionManager() {
    return new JpaTransactionManager(entityManagerFactory());
  }
}
