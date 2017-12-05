package cn.home.config.bootstrap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.home.modules.beans.entity.DbInfo;
import cn.home.util.JacksonUtil;

/**
 * @author donald 2017年12月5日 下午1:18:26
 */
public class AnnotationConfigApplicationContextProfileDemo {
	private static final Logger log = LoggerFactory.getLogger(AnnotationConfigApplicationContextProfileDemo.class);
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.getEnvironment().setActiveProfiles("development");
//		ctx.getEnvironment().setActiveProfiles("test");
		ctx.scan("cn.home");
	    ctx.refresh();
	    DbInfo dbInfo = ctx.getBean(DbInfo.class);
	    log.info("dbInfo:{}",JacksonUtil.getInstance().toJson(dbInfo));
	}
}
