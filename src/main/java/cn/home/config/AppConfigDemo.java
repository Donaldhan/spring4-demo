package cn.home.config;

import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.annotation.SessionScope;

import cn.home.modules.beans.entity.Bar;
import cn.home.modules.beans.entity.Foo;
import cn.home.modules.beans.entity.UserPreferences;
import cn.home.modules.beans.service.UserService;
import cn.home.modules.beans.service.impl.UserServiceImpl;

@Configuration
/*
 * @ComponentScan(basePackages = "org.example", includeFilters = @Filter(type =
 * FilterType.REGEX, pattern = ".*Stub.*Repository"), excludeFilters
 * = @Filter(Repository.class))
 */
@ComponentScan(basePackages = "org.example", nameGenerator = BeanNameGenerator.class)
// @ComponentScan(basePackages = "org.example", scopeResolver = MyScopeResolver.class)
@Import(AppConfigDemo2.class)
@Profile("development")
public class AppConfigDemo {
	@Bean(initMethod = "init")
	@Scope("prototype")
	public Foo foo() {
		return new Foo();
	}
	@Bean(destroyMethod = "cleanup")
	public Bar bar() {
		return new Bar();
	}
	// an HTTP Session-scoped bean exposed as a proxy
	@Bean
	@SessionScope
	public UserPreferences userPreferences() {
	    return new UserPreferences();
	}
	@Bean
	public UserService userService() {
	    UserService service = new UserServiceImpl();
	    // a reference to the proxied userPreferences bean
	    service.setUserPreferences(userPreferences());
	    return service;
	}
}
