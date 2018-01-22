package com.wangwang.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//声明一个控制器
@Controller
public class IndexController {
	//配置URL和方法的映射
	@RequestMapping("/index")
  public String index(){
		//通过在 WebMvcConfig中配置ViewResolver
		//这个视图的位置为:/WEB-INF/classes/views/index.jsp
	  return "index";
  }
}
