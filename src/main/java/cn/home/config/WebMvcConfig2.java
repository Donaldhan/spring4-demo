package cn.home.config;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;

import cn.home.config.freemarker.FreemarkerStaticModels;
import cn.home.modules.webmvc.Interceptor.CostTimeInterceptor;
import cn.home.modules.webmvc.Interceptor.SystemLogInterceptor;
import cn.home.modules.webmvc.exceptionhandler.GlobalHandlerExceptionResolver;

@Configuration
@ComponentScan(basePackages = "cn.home.modules")
@EnableWebMvc
public class WebMvcConfig2 extends WebMvcConfigurerAdapter {
	@Autowired
	private CostTimeInterceptor costTimeInterceptor;
	@Autowired
	SystemLogInterceptor systemLogInterceptor;
	@Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .dateFormat(new SimpleDateFormat("yyyy-MM-dd"))
                .modulesToInstall(new ParameterNamesModule());
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(systemLogInterceptor).addPathPatterns("/**").excludePathPatterns("/admin/**");
		registry.addInterceptor(costTimeInterceptor).addPathPatterns("/**");
	}
	/**
	 * to serve resource requests with a URL pattern of /resources/** from a
	 * public-resources directory within the web application root
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
	}
	@Autowired
	private FreemarkerStaticModels freemarkerStaticModels;

	@Bean
	public FreeMarkerConfigurer freemarkerConfig() {
		FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
		freeMarkerConfigurer.setTemplateLoaderPath("/freemarker/");
		freeMarkerConfigurer.setDefaultEncoding("UTF-8");
		Properties prop = new Properties();
		prop.setProperty("number_format","#");
		freeMarkerConfigurer.setFreemarkerSettings(prop);
		return freeMarkerConfigurer;
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		FreeMarkerViewResolver resolver = new FreeMarkerViewResolver();
		resolver.setSuffix(".ftl");
		resolver.setCache(true);
		resolver.setRequestContextAttribute("request");
		resolver.setContentType("text/html;charset=UTF-8");
		resolver.getAttributesMap().putAll(freemarkerStaticModels);
		registry.viewResolver(resolver);
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setMaxUploadSize(104857600);
		return resolver;
	}
	@Bean 
	public GlobalHandlerExceptionResolver globalHandlerExceptionResolver(){
		return new GlobalHandlerExceptionResolver();
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void extendHandlerExceptionResolvers( List list){
		list.add(globalHandlerExceptionResolver());
		
	}
}
