package cn.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import cn.home.modules.beans.service.MyService;
import cn.home.modules.beans.service.impl.MyServiceImpl;

@Configuration
@ComponentScan(basePackages = "cn.home")
public class AppConfig {
	@Bean
    public MyService myService() {
        return new MyServiceImpl();
    }

}
