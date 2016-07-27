<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Insert title here</title>
</head>
<body>
Spring Login Index Success

<br/>type=<s:property value="type"/>
<br/>word=<s:property value="word"/>
<s:iterator value="userMap">
<br/>mapUser key=<s:property value="key"/>
<br/>mapUser value=<s:property value="value"/>
</s:iterator>

<br/>userModel.id=<s:property value="userModel.id"/>
<br/>userModel.name=<s:property value="userModel.name"/>

<s:iterator value="userModelList">
<br/>userModelList id=<s:property value="id"/>
<br/>userModelList name=<s:property value="name"/>
</s:iterator>

</body>
</html>