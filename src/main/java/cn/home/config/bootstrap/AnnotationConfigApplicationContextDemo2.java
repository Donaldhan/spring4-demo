package cn.home.config.bootstrap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.home.config.AppConfig;
import cn.home.modules.beans.service.MyService;
import cn.home.modules.beans.service.UserService;

/**
 * @author donald 2017年12月5日 下午1:18:26
 */
public class AnnotationConfigApplicationContextDemo2 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();
		MyService myService = ctx.getBean(MyService.class);
		myService.doStuff();
		UserService userService = ctx.getBean(UserService.class);
		userService.saveUser();
	}
}
