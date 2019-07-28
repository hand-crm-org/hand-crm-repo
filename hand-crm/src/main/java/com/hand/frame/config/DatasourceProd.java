package com.hand.frame.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages="com.hand.demo.access")
@Profile({"prod"})
@PropertySource("classpath:datasource_dev.properties")
public class DatasourceProd implements EnvironmentAware{

	private Environment env;
	
	@Override
	public void setEnvironment(Environment arg0) {
		this.env = arg0;
	}

	@Bean
	public DataSource dataSource() {
		DruidDataSource dataSource = new DruidDataSource();
		// jdbc连接
		dataSource.setDriverClassName(env.getProperty("jdbc1.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc1.url"));
        dataSource.setUsername(env.getProperty("jdbc1.username"));
        dataSource.setPassword(env.getProperty("jdbc1.password"));
        
        // 连接池
        dataSource.setMaxActive(Integer.valueOf(env.getProperty("jdbc1.maxActive")));
        dataSource.setMinIdle(Integer.valueOf(env.getProperty("jdbc1.minIdle")));
        dataSource.setInitialSize(Integer.valueOf(env.getProperty("jdbc1.initialSize")));
        dataSource.setMaxWait(Integer.valueOf(env.getProperty("jdbc1.maxWait")));
        dataSource.setTimeBetweenEvictionRunsMillis(Integer.valueOf(env.getProperty("jdbc1.timeBetweenEvictionRunsMillis")));
        dataSource.setMinEvictableIdleTimeMillis(Long.valueOf(env.getProperty("jdbc1.minEvictableIdleTimeMillis")));
        dataSource.setTestWhileIdle(Boolean.valueOf(env.getProperty("jdbc1.testWhileIdle")));
        dataSource.setTestOnBorrow(Boolean.valueOf(env.getProperty("jdbc1.testOnBorrow")));
        dataSource.setTestOnReturn(Boolean.valueOf(env.getProperty("jdbc1.testOnReturn")));
        dataSource.setValidationQuery("SELECT 'x'");
        dataSource.setPoolPreparedStatements(true);
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        return dataSource;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
	}
	
	@Bean
	public SqlSessionFactory ds1SqlSessionFactory(
			@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.hand.demo.access.vo");
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:com/hand/**/dao/*.xml"));
        return sessionFactory.getObject();
    }
}
