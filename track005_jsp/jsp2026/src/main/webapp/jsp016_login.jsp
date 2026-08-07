<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="container card  my-5">
		<h3 class="card-header"> LOGIN 유지하기 </h3>
		<pre class="my-3">
		■ 1. model 확인
      mysql> desc users;
      +----------+--------------+------+-----+-------------------+-------------------+
      | Field    | Type         | Null | Key | Default           | Extra             |
      +----------+--------------+------+-----+-------------------+-------------------+
      | uno      | int          | NO   | PRI | NULL              | auto_increment    |
      | nickname | varchar(20)  | NO   |     | NULL              |                   |
      | bpass    | varchar(50)  | NO   |     | NULL              |                   |
      | email    | varchar(100) | NO   |     | NULL              |                   |
      | mobile   | varchar(50)  | NO   |     | NULL              |                   |
      | udate    | timestamp    | NO   |     | CURRENT_TIMESTAMP | DEFAULT_GENERATED |
      | bip      | varchar(50)  | NO   |     | NULL              |                   |
      +----------+--------------+------+-----+-------------------+-------------------+
      7 rows in set (0.00 sec)
		 1.cmd 창에서 회원가입정보 입력
		 2.처리부분: action="jsp016_result.jsp" / 주소표시창줄 노출X / 데이터 보관이름:email,bpass
		 3.로그아웃 버튼클릭시 로그아웃 처리 (로그인시에만 보이기)
		</pre>
		<%
		if(session.getAttribute("email") !=null){ %>
			<div class="alert alert-warning"> 반갑습니다	<%=session.getAttribute("email") %>	님
					</div>
					<a href="jsp016_result.jsp">로그아웃</a>
					
		<% }%>
		
		
		
		<form action="jsp016_result.jsp"  method="post" onsubmit="return checkLogin()">
			<div class="my-3">
				<label for="email"   class="form-label">Email : </label>
				<input type="email"  class="form-control"  id="email"  name="email" />      
			</div>
			<div class="my-3">
				<label for="pass"       class="form-label">Password : </label>
				<input type="password"  class="form-control"  id="pass"  name="pass" />      
			</div>		
			<div class="my-3">
				<label for="check"       class="form-label">Remember : </label>
				<input type="checkbox"   id="check"  name="remember" />      
			</div>	
			<div class="my-3"> 
				<button type="submit"    title="login 하러가기"
				       class="btn btn-danger"  id="check"  name="remember"  > 로그인 </button> 
			</div>								
		</form>
	</div>
	
	<script>
	function checkLogin(){
		let email=document.getElementById("email");
		let pass=doucument.getElementById("pass");
		if(email.value.trim()==""){
			alret("이메일을 입력해주세요")
			email.foucs();
			return false;
			
		}if(pass.value.trim()==""){
			alret("암호를 입력해주세요")
			pass.foucs();
			return false;
		}
		return true;
	}
	</script>
</body>
</html> 
 

