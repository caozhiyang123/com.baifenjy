<%@ page import="org.apache.commons.lang3.StringUtils"%>
<%@ page language="java" contentType="application/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String callback = request.getParameter("callback");
	if(StringUtils.isNotBlank(callback)){
	    out.print(callback+"({\"num\":23});");
	}else{
	    out.print("{\"num\":23}");
	}
%>