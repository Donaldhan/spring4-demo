package cn.home.modules.annotation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.home.modules.annotation.dao.MovieFinderDao;
import cn.home.modules.annotation.service.MovieListerService;

/**
 * Spring can automatically detect stereotyped classes and register
 * corresponding BeanDefinitions with the ApplicationContext. For example, the
 * following two classes are eligible for such autodetection:
 * 
 * @author donald 2017年12月5日 下午12:58:16
 */
@Service
public class MovieListerServiceImpl implements MovieListerService {
	@Autowired
	private MovieFinderDao movieFinderDao;

}
