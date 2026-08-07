

<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">JDBC</h3>
      <pre class="alert alert-info">
      	1. jdbc -Java Database Connectivity
      	-java 와 db연결해 sql 실행해주는 표준 api
      	2. mysql,oracle,,, 다양한 dbms와 연결
      	3. 사용방법
      	https://dev.mysql.com/downloads/
      	
      	[src]-[main]-[webapp]-[WEB-INF]-[lib]- mysql-connector-j-8.4.0.jar
      	
      	4. JDBC 사용방법
      	1) Class.forName() 드라이버 로딩
      	2) DriverManger Connection 활성화
      	3) Connection DB연동
      	4) Statemenet,PreparedStatement sql 구문실행
      	5) jdbc 연동끊기
      </pre>
      
      <%
      try{
    	 Class.forName("com.mysql.cj.jdbc.Driver"); //1. 드라이버로딩     	
      Connection conn = DriverManager.getConnection(
    		  "jdbc:mysql://localhost:3306/mbasic",
    		  "root",
    		  "1234");//2. jdbc 연동
    	 if(conn != null){
    		 out.println("db 연결성공");
    		 conn.close();
    	 }
      
      
      }catch(Exception e){ e.printStackTrace();}
      %>
       
   </div>
</body>
</html>