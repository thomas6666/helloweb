package com.wangwang.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.wangwang.web.interceptor.CaculationRequestTimeInterceptor;
//标志为配置文件
@Configuration
//启用mvc ,不然重写WebMvcConfigurerAdapter方法无效
@EnableWebMvc 
@ComponentScan("com.wangwang.web")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	//配置一 个JSP的ViewResolver 用来映射路径和实际页面的位置
  @Bean
  public InternalResourceViewResolver viewResolver(){
	  InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
	  viewResolver.setPrefix("/WEB-INF/classes/views/");
	  viewResolver.setSuffix(".jsp");
	  viewResolver.setViewClass(JstlView.class);
	  return viewResolver;
  }
  @Bean
  public HandlerInterceptorAdapter CaculationRequestTimeInterceptor(){
	  return new CaculationRequestTimeInterceptor();
  }

  //配置添加静态资源映射
@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {
	// TODO Auto-generated method stub
	registry.addResourceHandler("/assets/lib/**") //对外暴露的访问路径
	.addResourceLocations("classpath:/assets/lib/");//指定文件存放的路径
}
// 添加拦截器
@Override
public void addInterceptors(InterceptorRegistry registry) {
	registry.addInterceptor(CaculationRequestTimeInterceptor());
}
  
  
  
  
  /**
   * spring mvc 里有一个接口叫做ViewResolver，实现这个接口
   * 要重写方法resolveViewName()，这个方法的返回值是接口View
   * 而View的职责就是使用model,request,response对象，并渲染视图
   *（不一定是html、可能是json、xml、pdf）返回给浏览器
   *
   *WebMvcConfigurerAdapter 是spring mvc 的定制配置类
   *比如添加 静态资源映射 重写addResourceHandlers 方法实现
   */
}
