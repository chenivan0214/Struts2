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

loginlogin
<br/>
${sessionScope.type}
<br/>
<%
//import com.opensymphony.xwork2.util.*
ValueStack valueStack = (ValueStack)request.getAttribute("struts.valueStack");
String type = (String)valueStack.findValue("type");
%>
<%=type %>
<br/>
<s:property value="%{type}" />
or
<s:property value="type" />

</body>
</html>