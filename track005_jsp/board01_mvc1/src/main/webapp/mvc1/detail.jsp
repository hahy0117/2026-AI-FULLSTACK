<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
    
    <%
   request.setCharacterEncoding("UTF-8");
   int bno=Integer.parseInt(request.getParameter("bno"));
    		   String bname="", btitle="",bcontent=""; int bhit=0;
  // String bpass=request.getParameter("bpass");
  // int bhit=Integer.parseInt(request.getParameter("bhit"));
   
   try{
	   
	   Connection conn=null; PreparedStatement pstmt=null;  ResultSet rset=null;
	  
	   String url="jdbc:mysql://localhost:3306/mbasic";	
	   String sql1="update mvcboard1 set bhit=bhit+1 where bno=?";
	   String sql2="select * from mvcboard1 where bno=?";
	   String user="root",pass="1234";
	   
	   Class.forName("com.mysql.cj.jdbc.Driver");		   
	   conn=DriverManager.getConnection(url,user,pass);	
	   
	   pstmt=conn.prepareStatement(sql1); pstmt.setInt(1,bno);
	   if(pstmt.executeUpdate()>0){
		   pstmt.close();
	   }
	   pstmt=conn.prepareStatement(sql2); pstmt.setInt(1,bno);
	   rset=pstmt.executeQuery(); //표
	   
	   if(rset.next() ){// 줄
		   bname=rset.getString("bname"); btitle=rset.getString("btitle");
		   bcontent=rset.getString("bcontent"); bhit=rset.getInt("bhit");
	   }
	   
	 
	  
	   
	   
	   
	   
   }catch(Exception e){
	   e.printStackTrace();
   }
   %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세보기</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">글 상세보기</h3>
      <form action="#" method="post" onsubmit="return check4()">
      <div class="my-3">
       <label for="bname">조회수</label>
      <input type="text" class="form-control" value="<%=bhit%>" id="bhit" name="bhit" readonly />
      </div>
      
      <div class="my-3">
       <label for="bname">이름</label>
      <input type="text" class="form-control" value="<%=bname%>" id="bname" name="bname" readonly />
      </div>
      
      <div class="my-3">
       <label for="bpass">비밀번호</label>
      <input type="password" class="form-control"id="bpass" name="bpass"  readonly/>
      </div>
       
      
       <div class="my-3">
       <label for="btitle">제목</label>
      <input type="text" class="form-control" value="<%=btitle%>" id="btitle" name="btitle"  readonly/>
      </div>
      
       <div class="my-3">
       <label for="bcontent">내용</label>
      <textarea class="form-control"  id="bcontent" name="bcontent" readonly ><%=bcontent %></textarea>
      </div>
      
      <div class="my-3 text-end">
     <a href=""   class="btn btn-dark" title="글 수정">수정</a>
     <a href=""   class="btn btn-dark" title="글 삭제">삭제</a>
     <a href=""   class="btn btn-dark" title="목록보러가기">목록</a>
      </div>
     
      </form>
       
   </div>
   
   
</body>
</html>