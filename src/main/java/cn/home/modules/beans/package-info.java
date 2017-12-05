/**
 * BeanFactory ApplicationContext WebApplicationContext
 * ClassPathXmlApplicationContext FileSystemXmlApplicationContext BeanDefinition
 * DefaultListableBeanFactory
 * =====================================================================
 * InitializingBean DisposableBean
 * 
 * @PostConstruc @PreDestroy Methods annotated with @PostConstruct
 *               afterPropertiesSet() as defined by the InitializingBean
 *               callback interface A custom configured init() method
 * 
 *               Destroy methods are called in the same order:
 * 
 *               Methods annotated with @PreDestroy destroy() as defined by the
 *               DisposableBean callback interface A custom configured destroy()
 *               method SmartLifecycle LifecycleProcessor
 *               ApplicationContextAware BeanFactoryAware ServletContextAware
 *               BeanFactoryPostProcessor PropertyPlaceholderConfigurer
 *               FactoryBean
 *               ===============================================================
 *               <context:annotation-config/>
 * 
 *               (The implicitly registered post-processors include
 *               AutowiredAnnotationBeanPostProcessor,
 *               CommonAnnotationBeanPostProcessor,
 *               PersistenceAnnotationBeanPostProcessor, as well as the
 *               aforementioned RequiredAnnotationBeanPostProcessor.) [Note]
 * 
 *               <context:annotation-config/> only looks for annotations on
 *               beans in the same application context in which it is defined.
 *               This means that, if you put <context:annotation-config/> in a
 *               WebApplicationContext for a DispatcherServlet, it only checks
 *               for @Autowired beans in your controllers, and not your
 *               services.
 * 
 *               Spring can automatically detect stereotyped classes and
 *               register corresponding BeanDefinitions with the
 *               ApplicationContext.
 *               上下文注解配置可以解决控制层的业务逻辑服务实现依赖注入，服务层的Dao组件注入依赖于ApplicationContext、
 *               WebApplicationContext
 *               ===============================================================
 * @Service
 * 			====================================================================
 * @author donald 2017年12月4日 下午10:19:14
 */
package cn.home.modules.beans;