<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp"%>

<div class="container card my-5">
	<h3 class="card-header"></h3>

	<form action="JoinAction" method="post" onsubmit="return checkLogin()">
		<div class="my-3">
			<label for="nickname" class="form-label">닉네임</label> <input
				type="text" class="form-control" id="nickname" name="nickname" />
		</div>

		<div class="my-3">
			<label for="bpass" class="form-label">비밀번호</label> <input
				type="password" class="form-control" id="bpass" name="bpass" />
		</div>

		<div class="my-3">
			<label for="email" class="form-label">이메일</label> <input type="email"
				class="form-control" id="email" name="email" />
		</div>

		<div class="my-3">
			<label for="mobile" class="form-label">휴대폰</label> <input type="text"
				class="form-control" id="mobile" name="mobile" />
		</div>

		<div class="my-3">
			<button type="submit" title="login 하러가기" class="btn btn-danger"
				id="check" name="remember">회원가입</button>
		</div>
	</form>

</div>

<script>
	function checkLogin() {
		let nickname = document.getElementById("nickname");
		let bpass = document.getElementById("bpass");
		let email = document.getElementById("email");
		let mobile = document.getElementById("mobile");

		if (nickname.value.trim() == "") {
			alret("닉네임을 입력해주세요.")
			nickname.foucs();
			return false;
		}
		if (bpass.value.trim() == "") {
			alret("비밀번호를 입력해주세요.")
			nickname.foucs();
			return false;
		}
		if (email.value.trim() == "") {
			alret("이메일을 입력해주세요.")
			nickname.foucs();
			return false;
		}
		if (mobile.value.trim() == "") {
			alret("mobile 입력해주세요.")
			nickname.foucs();
			return false;
		}
		return true;
	}
</script>

<%@include file="inc/footer.jsp"%>
</body>
</html>