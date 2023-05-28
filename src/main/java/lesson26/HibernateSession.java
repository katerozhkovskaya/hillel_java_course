package lesson26;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EntityScan("lesson26")
public class HibernateSession {

        @Bean
        public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
            var sessionFactory = new LocalSessionFactoryBean();
            sessionFactory.setDataSource(dataSource);
            sessionFactory.setPackagesToScan("lesson26");
            return sessionFactory;
        }

        @Bean
        public DataSource dataSource() {
            var dataSource = new PGSimpleDataSource();
            dataSource.setDatabaseName("postgres");
            dataSource.setUser("postgres");
            dataSource.setPassword("test");
            return dataSource;
        }
}
