<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭제</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
   <div class="container card my-5">
      <h3 class="card-header">글 삭제</h3>
       <form action="" method="post" onsubmit="return check3()">
     
      
       <div class="my-3">
       <label for="bpass">비밀번호</label>
      <input type="text" class="form-control" id="bpass" name="bpass" />
      </div>
      
      
      
      <div class="my-3 text-end">
      <button type="reset" class="btn btn-dark" title="글 취소">취소</button>
     <a href=""   class="btn btn-dark" title="목록보러가기">목록</a>
      <button type="submit" class="btn btn-dark" title="글 삭제">글 삭제</button>
      </div>
     
      </form>
   </div>
   
   <script>
   function check3(){
	   
	   let bpass=document.getElementById("bpass");
	   
	  
	   
	   
	   if(bpass.value.trim() == ""){
		   alert("비밀번호 입력")
		   bpass.focus();
			return false;
	   }
	   
	   return true;
   }
   </script>
</body>
</html>