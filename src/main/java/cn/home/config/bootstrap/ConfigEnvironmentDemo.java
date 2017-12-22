package cn.home.config.bootstrap;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;


/**
 * 测试系统环境变量及属性
 * @author donald
 * 2017年12月5日
 * 下午1:18:26
 */
public class ConfigEnvironmentDemo {
	private static final Logger log = LoggerFactory.getLogger(ConfigEnvironmentDemo.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext();
		ConfigurableEnvironment  configEnv = (ConfigurableEnvironment) ctx.getEnvironment();
		Map<String,Object> envMap = configEnv.getSystemEnvironment();
		log.info("==========系统环境变量=======");
		Set<Entry<String, Object>> envEntrys = envMap.entrySet();
		for(Entry<String,Object> envEntry:envEntrys){
			log.info("环境变量{}：{}",envEntry.getKey(),envEntry.getValue());
		}
		Map<String,Object> propertiesMap = configEnv.getSystemProperties();
		log.info("===========系统属性=========");
		Set<Entry<String, Object>> propertiesEntrys = propertiesMap.entrySet();
		for(Entry<String,Object> propertiesEntry:propertiesEntrys){
			log.info("系统属性{}：{}",propertiesEntry.getKey(),propertiesEntry.getValue());
		}
	}
}
