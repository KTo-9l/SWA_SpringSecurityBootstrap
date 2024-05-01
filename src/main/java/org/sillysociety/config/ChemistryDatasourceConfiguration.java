package org.sillysociety.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "chemistryEntityManagerFactory",
        transactionManagerRef = "chemistryTransactionManager",
        basePackages = {"org.sillysociety.repository.chemistry"})
public class ChemistryDatasourceConfiguration {

    @Bean(name="chemistryProperties")
    @ConfigurationProperties("spring.datasource.chemistry")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="chemistryDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.chemistry")
    public DataSource datasource(@Qualifier("chemistryProperties") DataSourceProperties properties){
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name="chemistryEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("chemistryDatasource") DataSource dataSource) {
        return builder.dataSource(dataSource)
                .packages("org.sillysociety.models.chemistry")
                .persistenceUnit("chemistry").build();
    }

    @Bean(name = "chemistryTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("chemistryEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
