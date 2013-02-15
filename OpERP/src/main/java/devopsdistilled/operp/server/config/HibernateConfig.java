package devopsdistilled.operp.server.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@PropertySource("server/jdbc.properties")
public class HibernateConfig {

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
    public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
	return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Properties hibernateProperties() {
	Properties properties = new Properties();
	properties.put("hibernate.dialect",
		"org.hibernate.dialect.MySQL5Dialect");
	properties.put("hibernate.show_sql", "true");
	properties.put("hibernate.hbm2ddl.auto", "create");

	// properties.put("hibernate.connection.driver_class", "org.h2.Driver");
	// properties.put("hibernate.connection.url",
	// "jdbc:h2:db/test;CIPHER=AES");
	// properties.put("hibernate.connection.username", "root");
	// properties.put("hibernate.connection.password", "root root");
	// properties.put("hibernate.connection.pool_size", "1");
	// properties.put("hibernate.format_sql", "true");
	// properties.put("hibernate.use_sql_comments", "true");
	// properties.put("hibernate.c3p0.min_size", "5");
	// properties.put("hibernate.c3p0.max_size", "20");
	// properties.put("hibernate.c3p0.timeout", "300");
	// properties.put("hibernate.c3p0.max_statements", "50");
	// properties.put("hibernate.c3p0.idle_test_period", "3000");
	// properties.put("hibernate.cache.use_second_level_cache", "true");
	// properties.put("hibernate.cache.region.factory_class",
	// "org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory");
	// properties.put("hibernate.cache.use_query_cache", "true");
	// properties.put("hibernate.cache.use_minimal_puts", "true");
	// properties.put("hibernate.max_fetch_depth", "10");

	return properties;
    }

    @SuppressWarnings("deprecation")
    @Bean
    public SessionFactory sessionFactory() {

	/*
	 * ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
	 * .applySettings(hibernateProperties()).buildServiceRegistry();
	 */
	return new LocalSessionFactoryBuilder(dataSource())
		.scanPackages(packagesToScan)
		.addProperties(hibernateProperties()).buildSessionFactory();

    }

    @Bean
    public PlatformTransactionManager transactionManager() {
	return new HibernateTransactionManager(sessionFactory());
    }
}