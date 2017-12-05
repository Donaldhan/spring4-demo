package cn.home.config;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/*@ComponentScan(basePackages = "org.example",
        includeFilters = @Filter(type = FilterType.REGEX, pattern = ".*Stub.*Repository"),
        excludeFilters = @Filter(Repository.class))*/
@ComponentScan(basePackages = "org.example", nameGenerator = BeanNameGenerator.class)
//@ComponentScan(basePackages = "org.example", scopeResolver = MyScopeResolver.class)
public class AppConfigDemo {

}
