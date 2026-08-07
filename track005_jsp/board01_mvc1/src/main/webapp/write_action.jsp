<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

request.setCharacterEncoding("UTF-8");
String bname = request.getParameter("bname");
String bpass=request.getParameter("bpass");
String btitle = request.getParameter("btitle");
String bcontent = request.getParameter("bcontent");
String bip=InetAddress.getLocalHost().getHostAddress();


try{
	Connection conn=null; PreparedStatement pstmt=null; 
	Class.forName("com.mysql.cj.jdbc.Driver");	
	String url="jdbc:mysql://localhost:3306/mbasic";	
	String sql="insert into mvcboard1(bname,bpass,btitle,bcontent,bip) values (?,?,?,?,?)";
	conn=DriverManager.getConnection(url,"root","1234");	
	pstmt= conn.prepareStatement(sql);
	
	pstmt.setString(1,bname);
	pstmt.setString(2,bpass);
	pstmt.setString(3,btitle);
	pstmt.setString(4,bcontent);
	pstmt.setString(5, bip);
	
	
	
	int result = pstmt.executeUpdate(); //insert,update,delete,실행한 줄수
	
	if(result>0){
		out.println("<script> alert('성공했습니다'); location.href='list.jsp';</script>");
	}else{
		out.println("<script> alert('다시 입력'); location.href='list.jsp';</script>");
	}
	//////////////////////////////////
	//3. JDBD 끊기 필요한 코드? conn.close()
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