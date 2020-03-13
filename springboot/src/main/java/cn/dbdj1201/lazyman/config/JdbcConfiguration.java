package cn.dbdj1201.lazyman.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.github.trang.druid.autoconfigure.datasource.DruidDataSource2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author tyz1201
 * @datetime 2020-03-13 17:14
 **/
@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfiguration {

    @Autowired
    private JdbcProperties properties;

    @Bean
    public DataSource dataSource() {
        DruidDataSource2 ds = new DruidDataSource2();
        ds.setDriverClassName(this.properties.getDriverClassName());
        ds.setUrl(this.properties.getUrl());
        ds.setUsername(this.properties.getUsername());
        ds.setPassword(this.properties.getPassword());
        return ds;
    }

}
