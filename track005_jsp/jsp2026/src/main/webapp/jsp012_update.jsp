<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

    <%
    request.setCharacterEncoding("UTF-8");
    //2.데이터 넘겨 받기
    int ono= Integer.parseInt(request.getParameter("ono1"));
    String oname=request.getParameter("oname1");
    int onum=Integer.parseInt(request.getParameter("onum1"));
    
    try{
    	Connection conn=null; PreparedStatement pstmt=null;
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/mbasic";
    	String sql="update milk_order set oname=?, onum=? where ono=?";
    	conn=DriverManager.getConnection(url,"root","1234");
    	pstmt= conn.prepareStatement(sql);
    	pstmt.setString(1,oname);
    	pstmt.setInt(2,onum);
    	pstmt.setInt(3,ono);
    	int  result=pstmt.executeUpdate();
    	
    	if(result >0){
    		out.println("<script> alert('수정성공'); location.href='milk.jsp'; </script>");
    		
    	}else{
    		out.println("<script> alert('수정실패'); location.href='milk.jsp'; </script>");
    	}
    	if(pstmt != null){
    		pstmt.close();
    	}
    	if(conn != null){
    		conn.close();
    	}
    	
    }catch(Exception e){ e.printStackTrace();}
    %>