package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = "service")
@EnableJpaRepositories(basePackages = "repository",entityManagerFactoryRef = "factory",transactionManagerRef ="txManager" )
@PropertySource(value = {"classpath:application.properties"})
public class SpringConfig {
	@Value("${referencia}")
	String referencia;
	@Value("${pu}")
	String pu;
	
	@Bean
    public DataSource dataSource2() {
        JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        return dsLookup.getDataSource(referencia);
    }
	//adaptador de Hibernate
		@Bean
		public HibernateJpaVendorAdapter adapter() {
			HibernateJpaVendorAdapter adp=new HibernateJpaVendorAdapter();
			adp.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
			return adp;
		}
		//factoria EntityManager: Objeto para acceder a capa de persistencia con JPA
		@Bean
		public LocalContainerEntityManagerFactoryBean factory(@Qualifier("dataSource2") DataSource dataSource, HibernateJpaVendorAdapter adapter) {
			LocalContainerEntityManagerFactoryBean factory=new LocalContainerEntityManagerFactoryBean();
			factory.setPersistenceUnitName(pu);
			factory.setDataSource(dataSource);
			factory.setPackagesToScan("model");
			factory.setJpaVendorAdapter(adapter);
			return factory;
		}
		
		//gestor de transacción
		@Bean
		public JpaTransactionManager txManager(LocalContainerEntityManagerFactoryBean factory) {
			JpaTransactionManager manager=new JpaTransactionManager();
			manager.setEntityManagerFactory(factory.getObject());
			return manager;
		}
}
