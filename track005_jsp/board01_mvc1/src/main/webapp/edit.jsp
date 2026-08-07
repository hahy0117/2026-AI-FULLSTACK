<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">글 수정</h3>
      <form action="" method="post" onsubmit="return check2()">
      <div class="my-3">
       <label for="bname">이름</label>
      <input type="text" class="form-control" id="bname" name="bname" readonly />
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
      <button type="reset" class="btn btn-dark" title="글 수정">취소</button>
     <a href=""   class="btn btn-dark" title="목록보러가기">목록</a>
      <button type="submit" class="btn btn-dark" title="글등록">글 쓰기</button>
      </div>
     
      </form>
       
   </div>
   <script>
   function check2(){
	   
	   let bpass=document.getElementById("bpass");
	   let btitle=document.getElementById("btitle");
	   let bcontent=document.getElementById("bcontent");
	   
	   
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