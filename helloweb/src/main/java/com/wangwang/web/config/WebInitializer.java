package com.wangwang.web.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
/**
 * 是spring 提供用来配置Servlet 3.0+的配置接口,从而实现替代web.xml
 * 实现此接口将会自动被SpringServletContainerInitializer(用来启用Servlet 3.0容器) 获取到
 * @author Administrator
 *
 */
public class WebInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//注册配置类,并将它和当前的ServletContext关联 1
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebMvcConfig.class);
		//2
		ctx.setServletContext(servletContext);

		// 加载spring mvc的DispatcherServlet 3
		Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
  /**
   * 1、WebApplicationInitializer 是spring提供用来配置Servlet3.0+配置的接口,从而实现
   * 了替代web.xml文件。实现此接口将会自动被SpringServletContainerInitializer（用来
   * 启动Servlet3.0容器）获取到
   * 
   * 2、新建WebApplicationContext 注册配置类，并将其与当前servletContext关联
   * 
   * 3、注册Spring MVC的DispatcherServlet
   */
}
