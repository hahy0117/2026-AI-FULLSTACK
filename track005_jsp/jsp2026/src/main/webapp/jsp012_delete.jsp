
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<%
//1.데이터 넘겨받기
request.setCharacterEncoding("UTF-8");
int ono =Integer.parseInt(request.getParameter("ono2"));
//out.println(ono);

//2. sql-delete from milk_order where no=?
		try{
			PreparedStatement pstmt= null; Connection conn=null;
			String url="jdbc:mysql://localhost:3306/mbasic";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection(url,"root","1234");
			String sql="delete from milk_order where ono=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,ono);
			if(pstmt.executeUpdate()>0){
				out.println("<script> alert('삭제 성공'); location.href='milk.jsp'; </script>");
				
			}else{
				out.println("<script> alert('삭제 실패'); location.href='milk.jsp'; </script>");
			}
			if(pstmt != null){
	    		pstmt.close();
	    	}
	    	if(conn != null){
	    		conn.close();
	    	}
			
		}catch(Exception e){ e.printStackTrace();}

%>