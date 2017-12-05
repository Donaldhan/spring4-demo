package cn.home.config.bootstrap;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.home.config.AppConfig;
import cn.home.modules.beans.service.MyService;

/**
 * @author donald
 * 2017年12月5日
 * 下午1:18:26
 */
public class AnnotationConfigApplicationContextDemo {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MyService myService = ctx.getBean(MyService.class);
		myService.doStuff();
	}
}
