package cn.home.config;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.alibaba.druid.pool.DruidDataSource;

import cn.home.modules.beans.entity.DbInfo;
import cn.home.modules.beans.service.MyService;
import cn.home.modules.beans.service.impl.MyServiceImpl;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "cn.home.modules")
@PropertySource("classpath:jdbc.properties")
public class AppConfig implements TransactionManagementConfigurer {
	private static final Logger log = LoggerFactory.getLogger(Logger.class);
	private static final String JDBC_URL = "jdbc.url";
	private static final String JDBC_USERNAME = "jdbc.username";
	private static final String JDBC_PASSWORD = "jdbc.password";
	private static final String JDBC_DRIVE_CLASS_NAME = "jdbc.driverClassName";
	// 初始化时数据库连接数
	private static final int INITIAL_THREAD = 5;
	// 空闲时保存数据库连接数
	private static final int MINIDLE_THREAD = 2;
	// 数据库连接池最大连接数
	private static final int MAX_ACTIVE_THREAD = 100;
	// 数据库连接等待的最长时间
	private static final int MAX_WAIT = 1000;
	// 检查连接是否正常的查询
	private static final String CHECK_CONNECTION_QUERY = "Select 'X'";
	// 连接池状态监控过滤器名
	private static final String STAT_FILETER = "mergeStat";

	// MyBait sql文件
	private static final String MY_BAITS_MAPPER_PATH = "classpath*:mappers/**/**.xml";
	@Autowired
	Environment env;

	/**
	 * durid数据源
	 * 
	 * @return
	 * @throws SQLException
	 */
	@Bean(destroyMethod = "close")
	public DataSource dataSource() throws SQLException {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setInitialSize(INITIAL_THREAD);
		dataSource.setMinIdle(MINIDLE_THREAD);
		dataSource.setMaxActive(MAX_ACTIVE_THREAD);
		dataSource.setMaxWait(MAX_WAIT);
		dataSource.setTimeBetweenEvictionRunsMillis(60000);
		dataSource.setValidationQuery(CHECK_CONNECTION_QUERY);
		dataSource.setTestWhileIdle(true);
		dataSource.setTestOnBorrow(false);
		dataSource.setTestOnReturn(false);
		dataSource.setPoolPreparedStatements(false);
		dataSource.setFilters(STAT_FILETER);
		dataSource.setUrl(env.getProperty(JDBC_URL));
		dataSource.setDriverClassName(env.getProperty(JDBC_DRIVE_CLASS_NAME));
		dataSource.setUsername(env.getProperty(JDBC_USERNAME));
		dataSource.setPassword(env.getProperty(JDBC_PASSWORD));
		return dataSource;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		PathMatchingResourcePatternResolver loader = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(loader.getResources(MY_BAITS_MAPPER_PATH));
		return sessionFactory.getObject();
	}

	@Bean
	public SqlSession sqlSession() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}

	@Bean
	public PlatformTransactionManager txManager() throws SQLException {
		return new DataSourceTransactionManager(dataSource());
	}

	@Override
	public PlatformTransactionManager annotationDrivenTransactionManager() {
		PlatformTransactionManager transactionManager = null;
		try {
			transactionManager = txManager();
		} catch (SQLException e) {
			log.error("transactionManager config exception...",e);
			e.printStackTrace();
		}
		return transactionManager;
	}

	@Bean
	public MyService myService() {
		return new MyServiceImpl();
	}

	@Bean
	DbInfo dbInfo() {
		DbInfo dbInfo = new DbInfo();
		dbInfo.setUrl(env.getProperty(JDBC_URL));
		dbInfo.setDriverClassName(env.getProperty(JDBC_USERNAME));
		dbInfo.setUsername(env.getProperty(JDBC_PASSWORD));
		dbInfo.setPassword(env.getProperty(JDBC_DRIVE_CLASS_NAME));
		return dbInfo;
	}

}
