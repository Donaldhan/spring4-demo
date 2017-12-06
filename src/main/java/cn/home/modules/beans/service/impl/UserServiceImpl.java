package cn.home.modules.beans.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.home.modules.beans.entity.UserPreferences;
import cn.home.modules.beans.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
	private UserPreferences userPreferences;
	@Transactional
	@Override
	public void saveUser() {
		log.info("save user ...");
		
	}

	@Override
	public void setUserPreferences(UserPreferences userPreferences) {
		this.userPreferences = userPreferences;
	}

}
