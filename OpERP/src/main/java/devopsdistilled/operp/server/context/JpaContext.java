package devopsdistilled.operp.server.context;

import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaDialect;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "devopsdistilled.operp.server.data.repo", repositoryImplementationPostfix = "CustomImpl")
@EnableTransactionManagement
@PropertySource(value = { "classpath:/server/jdbc.properties",
		"classpath:/server/hibernate.properties" })
@ComponentScan("devopsdistilled.operp.server.data")
public class JpaContext {

	@Inject
	private Environment env;

	@Value("devopsdistilled.operp.server.data.entity")
	private String packagesToScan;

	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public DataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(env.getProperty("jdbc.url"));
		dataSource.setUsername(env.getProperty("jdbc.username"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
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
		hibernateProps.setProperty("hibernate.hbm2ddl.auto",
				System.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProps.setProperty("hibernate.format_sql",
				env.getProperty("hibernate.format_sql"));
		hibernateProps.setProperty("hibernate.show_sql",
				env.getProperty("hibernate.show_sql"));
		hibernateProps.setProperty("hibernate.use_sql_comments",
				env.getProperty("hibernate.use_sql_comments"));
		hibernateProps.setProperty("hibernate.generate_statistics",
				env.getProperty("hibernate.generate_statistics"));
		return hibernateProps;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslationPostProcessor() {
		return new PersistenceExceptionTranslationPostProcessor();
	}
}
