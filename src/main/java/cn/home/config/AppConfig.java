package cn.home.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import cn.home.modules.beans.entity.DbInfo;
import cn.home.modules.beans.service.MyService;
import cn.home.modules.beans.service.impl.MyServiceImpl;

@Configuration
@ComponentScan(basePackages = "cn.home")
@PropertySource("classpath:jdbc.properties")
public class AppConfig {
	private static final String JDBC_URL = "jdbc.url";
	private static final String JDBC_USERNAME = "jdbc.username";
	private static final String JDBC_PASSWORD = "jdbc.password";
	private static final String JDBC_DRIVE_CLASS_NAME = "jdbc.driverClassName";
	@Autowired
    Environment env;
	@Bean
    public MyService myService() {
        return new MyServiceImpl();
    }
	@Bean DbInfo dbInfo(){
		DbInfo dbInfo = new DbInfo();
		dbInfo.setUrl(env.getProperty(JDBC_URL));
		dbInfo.setDriverClassName(env.getProperty(JDBC_USERNAME));
		dbInfo.setUsername(env.getProperty(JDBC_PASSWORD));
		dbInfo.setPassword(env.getProperty(JDBC_DRIVE_CLASS_NAME));
		return dbInfo;
	}

}
