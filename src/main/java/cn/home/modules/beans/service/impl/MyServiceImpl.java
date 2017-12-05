package cn.home.modules.beans.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.home.modules.beans.service.MyService;

public class MyServiceImpl implements MyService {
	private static final Logger log = LoggerFactory.getLogger(MyServiceImpl.class);

	@Override
	public void doStuff() {
		log.info("do stub ...");
	}

}
