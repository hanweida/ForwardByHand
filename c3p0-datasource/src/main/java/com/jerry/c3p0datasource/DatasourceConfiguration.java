package com.jerry.c3p0datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:c3p0.properties")
public class DatasourceConfiguration {
    @Value("${c3p0.jdbcUrl}")
    String jdbcUrl;
    @Value("${c3p0.driverClass}")
    String driverClass;
    @Value("${c3p0.user}")
    String user;
    @Value("${c3p0.password}")
    String password;


    @Bean
      public DataSource dataSource() throws PropertyVetoException {
          ComboPooledDataSource ds = new ComboPooledDataSource();

          ds.setDriverClass(driverClass);
          ds.setJdbcUrl(jdbcUrl);
          ds.setUser(user);
          ds.setPassword(password);

          return ds;           }
}
