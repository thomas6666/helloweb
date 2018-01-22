<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome to spring mvc</title>
<script type="text/javascript" src="<%=request.getContextPath() %>/assets/lib/jquery.js"></script>
</head>
<body>
  <pre>
        欢迎使用 spring mvc 框架技术开发web应用!!!
  </pre>
  <pre style="color:red">
     注意: 此页面不放在Maven标准的src/main/webapp/WEB-INF 下？
     此处这样建的主要目的是熟悉Spring boot的页面习惯的放置方式，Spring boot的
    页面就放置在src/main/resources下
  </pre>
  <input type="button" value="获取对象" id="getObj"/>
  <script type="text/javascript">
   $(function(){
	  $("#getObj").click(function(){
		  $.getJSON("/helloweb/rest/getjson",{id:456,name:"异步请求"},function(data){
			  if(data){
				  alert("name:"+data.name+",id:"+data.id);
			  }
			  else{
				  alert("数据为空");
			  }
			 
		  });
	  }) ;
	   
   });
  </script>
</body>
</html>