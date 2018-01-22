package com.wangwang.model;

public class DemoObj {
	private Long id;
	private String name;
    //必须要这个无参构造函数
	//jackson对对象和json做转换时一定需要此空构造
	public DemoObj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemoObj(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
