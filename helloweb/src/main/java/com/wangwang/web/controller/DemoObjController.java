package com.wangwang.web.controller;

import static org.hamcrest.CoreMatchers.nullValue;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wangwang.model.DemoObj;

@Controller
// 映射此类的访问路径为/demo
@RequestMapping("/demo")
public class DemoObjController {
	// 此方法未标注路径，因此使用类级别的路径/demo
	// produces 可以定制返回response的媒体类型和字符集
	// 例如返回json 可以设置为produces=application/json;charset=UTF-8
	@RequestMapping(produces = "text/plain;charset=UTF-8")
	public @ResponseBody String index(HttpServletRequest request) {
		return "url:" + request.getRequestURL() + "can access";
	}

	// value 会指定访问的路径 会继承类的路径之后 。
	// 使用@PathVariable 来解析URL传递的参数
	// 如http://localhost:8080/helloweb/demo/patchvar/我们/76
	@RequestMapping(value = "/patchvar/{str}/{id}", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String demoPathVar(HttpServletRequest request, @PathVariable String str,
			@PathVariable Integer id) {
		return "url:" + request.getRequestURL() + "can access，str:" + str + ",id:" + id;
	}

	// 解析传统的传参 /demo/requestParam?str=你好&id=2
	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8")
	public @ResponseBody String passRequestParam(HttpServletRequest request, String str, Integer id) {
		return "url:" + request.getRequestURL() + "can access，str:" + str + ",id:" + id;
	}
     //解析参数到对象
	@RequestMapping(value = "/obj", produces = "text/plain;charset=UTF-8")
	//可以运用在方法上,也可以用在方法的返回值前
	@ResponseBody 
	public  String passObj(HttpServletRequest request, DemoObj demoObj) {
		if (demoObj == null) {
          return "传入的对象为空";
		}
		return "url:" + request.getRequestURL() + "can access，id:" + demoObj.getId() + ",name:" + demoObj.getName();
	}
    
	// 使用不同的地址到相同的方法
	@RequestMapping(value={"/name1","/name2"},produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String remove(HttpServletRequest request){
		return "url:"+request.getRequestURL()+" can access";
	}
}
