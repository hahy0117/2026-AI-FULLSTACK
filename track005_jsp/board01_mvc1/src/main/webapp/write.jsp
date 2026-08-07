<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QNA 등록</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">Q N A 등 록</h3>
      <form action="write_action.jsp" method="post" onsubmit="return check()">
      <div class="my-3">
       <label for="bname">이름</label>
      <input type="text" class="form-control" id="bname" name="bname" />
      </div>
      
       <div class="my-3">
       <label for="bpass">비밀번호</label>
      <input type="text" class="form-control" id="bpass" name="bpass" />
      </div>
      
       <div class="my-3">
       <label for="btitle">제목</label>
      <input type="text" class="form-control" id="btitle" name="btitle" />
      </div>
      
       <div class="my-3">
       <label for="bcontent">내용</label>
       <textarea class="form-control" id="bcontent" name="bcontent"></textarea>
      </div>
      
      <div class="my-3 text-end">
      <button type="submit" class="btn btn-dark" title="글등록">입력</button>
      <button type="submit" class="btn btn-dark" title="글등록">취소</button>
      <button type="submit" class="btn btn-dark" title="글등록">목록보기</button>
      </div>
     
      </form>
       
   </div>
   
   <script>
   function check(){
	   let bname=document.getElementById("bname");
	   let bpass=document.getElementById("bpass");
	   let btitle=document.getElementById("btitle");
	   let bcontent=document.getElementById("bcontent");
	   
	   if(bname.value.trim() == ""){
		   alert("이름 입력")
		   bname.focus();
			return false;
	   }
	   if(bpass.value.trim() == ""){
		   alert("비밀번호 입력")
		   bpass.focus();
			return false;
	   }
	   if(btitle.value.trim() == ""){
		   alert("제목 입력")
		   btitle.focus();
			return false;
	   }
	   if(bcontent.value.trim() == ""){
		   alert("내용 입력")
		   bcontent.focus();
			return false;
	   }
	   return true;
   }
   </script>
</body>
</html>