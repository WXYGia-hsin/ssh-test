<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/4 0004
  Time: 下午 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE htmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
    <title>添加学生信息</title>
</head>
<body>
<div align="center">
<h1>添加学生信息</h1>
<s:form action="student-add" method="post">
    <s:textfield name="entity.name" label="姓名"/>
<s:select name="entity.gender" list="#{'M':'男','F':'女'}" listKey="key" listValue="value" label="性别"/>
<s:textfield name="entity.age" label="年龄"></s:textfield>
<s:submit value="提交"/>
</s:form>
</div>
</body>
</html>
