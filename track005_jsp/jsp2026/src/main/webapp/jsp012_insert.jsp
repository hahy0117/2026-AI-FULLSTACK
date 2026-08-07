<%@page import="java.net.InetAddress"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   

    <%
    //jsp012_insert.jsp
    
    //1. utf-8 설정
    request.setCharacterEncoding("UTF-8");
    //2.request.getParameter() 이용해서 데이터받기
    String oname= request.getParameter("oname");
    int onum=Integer.parseInt(request.getParameter("onum"));
    
    // out.println(oname+"/"+onum);
    //3.insert 구문처리
    try{
    	Connection conn=null; PreparedStatement pstmt=null;
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	String url="jdbc:mysql://localhost:3306/mbasic";
    	String sql="insert into milk_order (oname,onum,oip) values(?,?,?)";
    	conn=DriverManager.getConnection(url,"root","1234");
    	pstmt= conn.prepareStatement(sql);
    	pstmt.setString(1,oname);
    	pstmt.setInt(2,onum);
    	pstmt.setString(3, InetAddress.getLocalHost().getHostAddress()); // Ip 주소 가져오기
    	
    	int result= pstmt.executeUpdate();
    	if(result>0){
    		out.println("<script> alert('우유주문 성공했습니다'); location.href='milks.jsp';</script>");
    	}else{
    		out.println("<script> alert('관리자에게 문의해주세요'); location.href='milks.jsp';</script>");
    	}
    	
    	if(pstmt != null){ pstmt.close();}
    	if(conn != null){ conn.close();}
    	
    }catch(Exception e){ e.printStackTrace();}
    
    
    //4.jsp012_milks.jsp 로 돌아기기
    
    
    
    %>
    