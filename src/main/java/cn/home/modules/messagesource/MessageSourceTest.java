package cn.home.modules.messagesource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author donald
 * 2017年11月26日
 * 下午9:42:30
 */
public class MessageSourceTest {
	private static final Logger log = LoggerFactory.getLogger(MessageSourceTest.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		MessageSource resources = new ClassPathXmlApplicationContext("MessageSource.xml");
		String message = resources.getMessage("message", null, "Default", null);
		log.info("message default:{}",message);
	}
}
