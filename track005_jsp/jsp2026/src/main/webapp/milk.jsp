<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Milk.jsp</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<div class="p-5 bg-success text-white">
		<h1>MIlK ORDER Project</h1>
		<p>preparedStatement Ex</p>
	</div>

	<div class="container card my-5 bg-success text-white">
		<h2 class="card-header">Milk Menu</h2>
		<table class="table table-bordered table-striped table-hover">
			<caption>우유메뉴</caption>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">NAME</th>
					<th scope="col">PRICE</th>
				</tr>
			</thead>
			<tbody>
				<%@page import="java.sql.*"%>
				<%
				try {
					//1.드라이버연동  
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rset = null;
					//2.JDBC연동
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mbasic", "root", "1234");
					//3.PreparedStatement pstmt 이용해서 milk 테이블의 데이터가져오기- 가격이 낮은순으로
					pstmt = conn.prepareStatement("select*from milk order by mprice asc");
					rset = pstmt.executeQuery();

					while (rset.next()) {
						out.println("<tr><td>" + rset.getInt("mno") + "</td><td>" + rset.getString("mname") + "</td><td>"
						+ rset.getInt("mprice") + "</td></tr>");
					}
					//4.JDBC 끊기
					if (rset != null) {
						rset.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				%>
			</tbody>

		</table>
	</div>

	<div class="container card my-5 bg-success text-white ">
		<h2 class="card-header">MILK ORDER</h2>
		<table class="table table-bordered table-striped table-hover">
			<caption></caption>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">NAME</th>
					<th scope="col">NUM</th>
					<th scope="col">주문날짜</th>
				</tr>
			</thead>
			<tbody>
				<%
				try {
					//드라이버 연동 Class.forName
					Class.forName("com.mysql.cj.jdbc.Driver");
					ResultSet rset = null;
					PreparedStatement pstmt = null;
					Connection conn = null;

					String url = "jdbc:mysql://localhost:3306/mbasic";
					String sql = "select*from milk_order order by ono desc";
					//jdbc 연동 DriverManager.getconnection
					conn = DriverManager.getConnection(url, "root", "1234");
					//3.pstmt 사용 sql 처리 pstmt-executeQuery()
					pstmt = conn.prepareStatement(sql);
					rset = pstmt.executeQuery();
					while (rset.next()) {
						out.println("<tr><td>" + rset.getInt("ono") + "</td><td>" + rset.getString("oname") + "</td><td>"
						+ rset.getInt("onum") + "</td><td>" + rset.getString("odate") + "</td></tr>");
					}
					if (rset != null) {
						rset.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
					if (conn != null) {
						conn.close();
					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				%>
			</tbody>
		</table>







	</div>

	<div class="container card my-5 bg-success text-white">
		<h2 class="card-header">MILK 주문하러가기</h2>
		<div id="accordion">

			<div class="card my-3">

				<div class="card-header bg-warning">
					<a class="btn" data-bs-toggle="collapse" href="#collapseOne">
						주문하기</a>
				</div>

				<div id="collapseOne" class="collapse show"
					data-bs-parent="#accordion">
					<div class="card-body">
						<form action="jsp012_insert.jsp" method="post"
							onsubmit="return order()">
							<div class="my-3">
								<label for="oname" class="form-Label">주문할 우유이름</label> <input
									type="text" class="form-control" id="oname" name="oname" />
							</div>

							<div class="my-3">
								<label for="onum" class="form-Label">주문할 우유갯수</label> <input
									type="text" class="form-control" id="onum" name="onum" />
							</div>

							<div class="my-3">
								<button type="submit" class="btn btn-warning">주문하기</button>
							</div>
						</form>
					</div>
				</div>

			</div>

		</div>

		<div class="card my-3">

			<div class="card-header bg-warning">
				<a class="btn" data-bs-toggle="collapse" href="#collapseTwo">
					수정하기</a>
			</div>
			<div id="collapseTwo" class="collapse" data-bs-parent="#accordion">
				<div class="card-body">
					<form action="jsp012_update.jsp" method="post"
						onsubmit="return order1()">
						<div class="my-3">
							<label for="ono1" class="form-Label">수정할 우유번호</label> <input
								type="text" class="form-control" id="ono1" name="ono1" />
						</div>

						<div class="my-3">
							<label for="oname1" class="form-Label">수정할 우유이름</label> <input
								type="text" class="form-control" id="oname1" name="oname1" />
						</div>

						<div class="my-3">
							<label for="onum1" class="form-Label">수정할 우유갯수</label> <input
								type="text" class="form-control" id="onum1" name="onum1" />
						</div>

						<div class="my-3">
							<button type="submit" class="btn btn-warning">수정하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>



		<div class="card my-5">

			<div class="card-header bg-warning">
				<a class="btn" data-bs-toggle="collapse" href="#collapseThree">
					삭제하기</a>
			</div>
			<div id="collapseThree" class="collapse" data-bs-parent="#accordion">
				<div class="card-body">
					<form action="jsp012_delete.jsp" method="post"
						onsubmit="return order2()">
						<div class="my-3">
							<label for="ono2" class="form-Label">삭제할 우유번호</label> <input
								type="text" class="form-control" id="ono2" name="ono2" />
						</div>

						<div class="my-3">
							<button type="submit" class="btn btn-warning">삭제하기</button>
						</div>
					</form>
				</div>
			</div>
		</div>




	</div>


	<script>
		function order() {
			let oname = document.getElementById("oname");
			let onum = document.getElementById("onum");
			if (oname.value.trim() == "") {
				alert("주문할 우유이름 입력")
				oname.focus();
				return false;
			}
			if (onum.value.trim() == "") {
				alert("주문할 우유갯수 입력")
				onum.focus();
				return false;
			}
			return true;
		}

		function order1() {
			let ono1 = document.getElementById("ono1");
			let oname1 = document.getElementById("oname1");
			let onum1 = document.getElementById("onum1");
			if (ono1.value.trim() == "") {
				alert("수정할 우유번호")
				ono1.focus();
				return false;
			}
			if (oname1.value.trim() == "") {
				alert("수정할 우유이름")
				oname1.focus();
				return false;
			}
			if (onum1.value.trim() == "") {
				alert("수정할 우유갯수")
				onum1.focus();
				return false;
			}
			return true;
		}

		function order2() {
			let ono2 = document.getElementById("ono2");
			if (ono2.value.trim() == "") {
				alert("삭제할 우유번호")
				ono2.focus();
				return false;
			}
			return true;
		}
	</script>




</body>
</html>