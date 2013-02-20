package devopsdistilled.operp.server.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("server/jdbc.properties")
public class JpaConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;
    @Value("devopsdistilled.operp.server.model")
    private String packagesToScan;

    @Bean
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public DataSource dataSource() {
	BasicDataSource dataSource = new BasicDataSource();
	dataSource.setDriverClassName(driverClassName);
	dataSource.setUrl(url);
	dataSource.setUsername(username);
	dataSource.setPassword(password);
	dataSource.setInitialSize(2);
	dataSource.setMaxActive(10);
	return dataSource;
    }

 
    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
	HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
	jpaVendorAdapter.setDatabase(Database.MYSQL);
	jpaVendorAdapter.setGenerateDdl(true);
	jpaVendorAdapter.setShowSql(true);
	jpaVendorAdapter
		.setDatabasePlatform("org.hibernate.dialect.MySQL5Dialect");
	return jpaVendorAdapter;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
	LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
	emf.setDataSource(this.dataSource());
	emf.setJpaVendorAdapter(this.jpaVendorAdapter());
	emf.setPackagesToScan(packagesToScan);
	emf.setJpaProperties(this.hibernateProperties());
	return emf;
    }

    @Bean
    public JpaDialect jpaDialect() {
	return new HibernateJpaDialect();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
	JpaTransactionManager transactionManager = new JpaTransactionManager();
	transactionManager.setEntityManagerFactory(entityManagerFactory()
		.getObject());
	transactionManager.setJpaDialect(jpaDialect());
	return transactionManager;
    }

    @Bean
    public Properties hibernateProperties() {
	Properties hibernateProps = new Properties();
	hibernateProps.setProperty("hibernate.hbm2ddl.auto", "true");
	return hibernateProps;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
	return new PersistenceExceptionTranslationPostProcessor();
    }

}