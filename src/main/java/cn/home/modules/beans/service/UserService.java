package cn.home.modules.beans.service;

import cn.home.modules.beans.entity.UserPreferences;

public interface UserService {
	void saveUser();

	void setUserPreferences(UserPreferences userPreferences);
}
