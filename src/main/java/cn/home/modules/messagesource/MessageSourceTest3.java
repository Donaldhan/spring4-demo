package cn.home.modules.messagesource;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author donald
 * 2017年11月26日
 * 下午9:42:30
 */
public class MessageSourceTest3 {
	private static final Logger log = LoggerFactory.getLogger(MessageSourceTest3.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		 MessageSource resources = new ClassPathXmlApplicationContext("MessageSource2.xml");
		  String message = resources.getMessage("argument.required",
		      new Object [] {"userDao"}, "Required", Locale.UK);
		  log.info("argument.required:{}",message);
	}
}
