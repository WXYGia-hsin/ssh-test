<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/4 0004
  Time: 下午 9:18
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPEhtmlPUBLIC"-//W3C//DTD HTML 4.01 Transitional//EN""http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type"content="text/html; charset=UTF-8">
    <title>学生列表</title>
</head>
<body>
<div align="center">
<h1>学生列表</h1>
<table>
    <tr>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>操作</th>
    </tr>
    <s:iterator var="a" value="%{#studentList}">
    <tr>
        <td><s:property value="%{#a.ID}"/></td>
        <td><s:property value="%{#a.name}"/></td>
        <td><s:property value="%{#a.gender}"/></td>
        <td><s:property value="%{#a.age}"/></td>
        <td><s:a href="student-delete?entity.ID=%{#a.ID}">删除</s:a></td>
    </tr>
    </s:iterator>
</table>
<s:a href="student-add.jsp">添加</s:a>
</div>
</body>
</html>