package cn.home.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import cn.home.modules.beans.entity.Foo;

@Configuration
@ComponentScan(basePackages = "cn.home")
@EnableTransactionManagement
@DependsOn("txManager")
@ImportResource("classpath:properties-config.xml")
@Profile("production")
public class AppConfigDemo2 {
	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;
	/*
	 @Bean
    public DataSource dataSource() {
        return new DriverManagerDataSource(url, username, password);
    }*/
	@Bean(name = "myFoo")
	public Foo foox() {
		return new Foo();
	}
}
