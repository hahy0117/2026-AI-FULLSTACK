<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String email = request.getParameter("email");
String bpass = request.getParameter("bpass");
String url="jdbc:mysql://localhost:3306/mbasic";


//2.sql 구문처리 - select*from users where email=? and bpass=?
		//로그인 성공했다면 
		session.setAttribute("email",email);
//3.로그인 성공시 session 설정 (session.setAttribute)
out.println("<script> location.href=jsp016_login.jsp</script>");
try{
	Connection conn=null; PreparedStatement pstmt=null; 
	Class.forName("com.mysql.cj.jdbc.Driver");
	conn=DriverManager.getConnection(url,"root","1234");
	String sql="select*from users where email=? and bpass=?";
	pstmt= conn.prepareStatement(sql);
	
	pstmt.setString(1,email);
	pstmt.setString(2,bpass);
	
	ResultSet conn1=pstmt.executeQuery();
	if(conn1.next()){
		response.sendRedirect("jsp016_login .jsp");
	}
	
	
	
	
	if (pstmt != null) {
		pstmt.close();
	}
	if (conn != null) {
		conn.close();
	}
}catch(Exception e){
	e.printStackTrace();
}
%>
<p>
	email:<%=email%></p>
<p>
	pass :<%=bpass%></p>