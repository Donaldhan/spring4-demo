package cn.home.modules.messagesource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author donald
 * 2017年11月26日
 * 下午9:42:30
 */
public class MessageSourceTest2 {
	private static final Logger log = LoggerFactory.getLogger(MessageSourceTest2.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("MessageSource2.xml");
		Example example = ctx.getBean(Example.class);
		example.execute();
	}
}
