<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
request.setCharacterEncoding("UTF-8");


String bname=request.getParameter("bname");
String bpass=request.getParameter("bpass");
String btitle=request.getParameter("btitle");
String bcontent=request.getParameter("bcontent");

try{
	Class.forName("com.mysql.cj.jdbc.Driver");
	String url="jdbc:mysql://localhost:3306/mbasic";
	
	
	
}catch(Exception e){
	e.printStackTrace();
}
%>