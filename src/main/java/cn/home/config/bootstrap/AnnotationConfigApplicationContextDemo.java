package cn.home.config.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.home.config.AppConfig;
import cn.home.modules.beans.entity.DbInfo;
import cn.home.modules.beans.service.MyService;
import cn.home.modules.beans.service.UserService;
import cn.home.util.JacksonUtil;

/**
 * @author donald
 * 2017年12月5日
 * 下午1:18:26
 */
public class AnnotationConfigApplicationContextDemo {
	private static final Logger log = LoggerFactory.getLogger(AnnotationConfigApplicationContextDemo.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		MyService myService = ctx.getBean(MyService.class);
		myService.doStuff();
		UserService userService = ctx.getBean(UserService.class);
		userService.saveUser();
		DbInfo dbInfo = ctx.getBean(DbInfo.class);
		log.info("dbInfo:{}",JacksonUtil.getInstance().toJson(dbInfo));
	}
}
