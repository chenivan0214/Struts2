<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<LINK rel=stylesheet type=text/css href="<s:url value="/"/>resources/css/global.css" />
<style>
</style>
</head>
<body>

<div id="container">
    <s:bean name="com.bean.other.TagBean" id="tagBean">
        <s:param name="name" value="'me'" />
    </s:bean>
    1.
    <s:property value="#tagBean.name" />
    <br/>
    2.
    <s:include value="/WEB-INF/views/other/_nonui_include.jsp" />
    <br/>
    3.
    <s:set name="sss" value="#session.tagBean" />
    <s:property value="#sss.name" />
    <br/>
    4.
    <s:push value="#session.tagBean">
        <s:property value="name" />
    </s:push>
    <br/>
    5.
    <s:url value="./other/nonui">
        <s:param name="p">1</s:param>
        <s:param name="c">2</s:param>
    </s:url>
    <br/>
    6.
    <s:if test="#sss.name == null">
    11
    </s:if>
    <s:elseif test="#sss.name == 'abc'">
    22
    </s:elseif>
    <s:else>
    33
    </s:else>
    <br>
    7.
    <s:iterator value="{1, 2, 3, 4, 5}">
        <s:property />
    </s:iterator>
    <br/>
    8.
    <s:set name="n" value="{'2', '4', '6'}" />
    <s:iterator value="#n">
        <s:property />
    </s:iterator>
    <br/>
    9.
    <s:iterator value="%{listTagBean}" status="status">
        <s:property value="name" /> - <s:property value="#status.count" /><br/>
    </s:iterator>
</div>

</body>
</html>