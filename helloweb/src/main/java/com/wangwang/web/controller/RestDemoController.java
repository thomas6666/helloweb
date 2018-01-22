package com.wangwang.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wangwang.model.DemoObj;

@RestController
@RequestMapping("/rest")
public class RestDemoController {
	//对象直接转换为json
	@RequestMapping(value = "/getjson", produces = "application/json;charset=UTF-8")
	public DemoObj getJson(DemoObj demoObj) {
		return new DemoObj(demoObj.getId() + 223, demoObj.getName() + "运用");
	}
    
	//对象会直接转换为xml
	@RequestMapping(value = "/getxml", produces = "application/xml;charset=UTF-8")
	public DemoObj getXml(DemoObj demoObj) {
		return new DemoObj(demoObj.getId() + 223, demoObj.getName() + "运用");
	}

}
