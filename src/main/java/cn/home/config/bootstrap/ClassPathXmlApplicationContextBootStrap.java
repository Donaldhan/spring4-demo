package cn.home.config.bootstrap;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author donald 2017年12月4日 下午10:25:33
 */
public class ClassPathXmlApplicationContextBootStrap {
	private static Logger log = LoggerFactory.getLogger(ClassPathXmlApplicationContextBootStrap.class);
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		// retrieve configured instance
//		PetStoreService service = context.getBean("petStore", PetStoreService.class);
		// use configured instance
//		List<String> userList = service.getUsernameList();
	}
}
