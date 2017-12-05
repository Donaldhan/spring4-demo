package cn.home.modules.beans.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.home.modules.beans.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public void saveUser() {
		log.info("save user ...");
		
	}

}
