<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.opensymphony.xwork2.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

Login page
<br/>
<br/>
*Session - EL - ${sessionScope.type}
<br/>
*Session - Tag + OGNL# - <s:property value="#session.type"/>
<br/>
*Request - EL - ${requestScope.type}
<br/>
*Request - Tag + OGNL - <s:property value="%{type}"/>
<br/>
*Request - Tag - <s:property value="type"/>
<br/>
*Request - Tag + OGNL - <s:property value="#request.type"/>
<br/>
*Request - Tag - <s:property value="name"/>
<br/>
<s:set name="array" value="#{'key1': 'value1', 'key2': 'value2'}"/>
<br/>
*OGNL - #取值用 - <s:property value="#array.key1"/>
<br/>
*OGNL - %計算用 - <s:property value="%{#array.key2 + '/' + #array.key2}"/>
<br/>
<br/>
<form action="/Struts2/login/index?type=1" method="post">
<input type="checkbox" name="hobby" value="1">hobby1<br/>
<input type="checkbox" name="hobby" value="2">hobby2<br/>
<input type="checkbox" name="hobby" value="3">hobby3<br/>
<input type="submit"/>
</form>
<br/>
<s:iterator value="hobbyMap" id="hobby" status="row">
<s:property value="key"/>-<s:property value="value"/>
<br/>
</s:iterator>
</body>
</html>