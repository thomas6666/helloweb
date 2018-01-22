package com.wangwang.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * spring mvc 拦截器(Interceptor) 实现对每一个请求处理前后进行相关的业务处理
 * ，类似于Servlet的Filter
 * 可以让普通的Bean实现HandlerInterceptor接口或者继承HandlerInterceptorAdapter
 * 类来自定义拦截器
 * 
 * 1、自定义拦截器
 * 2、在容器实例化
 * 3、重写WebApplicationConfiguraterAdapter的addInterceptors方法
 * @author Administrator
 *
 */
public class CaculationRequestTimeInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime=System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		long startTime=(Long)request.getAttribute("startTime");
		request.removeAttribute("startTime");
		long endTime=System.currentTimeMillis();
		long handingTime=endTime-startTime;
		System.out.println("本次请求处理的时间为:"+handingTime+"毫秒");
		request.setAttribute("handingTime", handingTime);
	}
   
}
