package cn.home.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "cn.home.modules")
@EnableWebMvc
public class WebMvcConfig {
	
}
