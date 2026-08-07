<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./inc/header.jsp"%>


<!--content-->
<section class="container my-5">
	<h3>MultiBoard</h3>
	<form action="write.jsp" method="post">

		<table
			class="table table-striped table-bordered table-hover table-warning">
			<caption>BOARD 목록</caption>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">TITLE</th>
					<th scope="col">WRITER</th>
					<th scope="col">DATE</th>
					<th scope="col">HIT</th>
				</tr>
			</thead>
			<tbody>
				<%
				
				try {
					Connection conn = null;
					PreparedStatement pstmt = null;
					ResultSet rset = null;
					String sql = "select * from mvcboard1 order by bno desc";
					String url = "jdbc:mysql://localhost:3306/mbasic";
					String user = "root", pass = "1234";
					Class.forName("com.mysql.cj.jdbc.Driver");

					conn = DriverManager.getConnection(url, user, pass);
					pstmt = conn.prepareStatement(sql);
					rset = pstmt.executeQuery();

					while (rset.next()) {
						out.println("<tr><td>" + rset.getInt("bno") + "</td><td><a href='detail.jsp?bno="+rset.getString("bno")+" ' >"+ rset.getString("btitle") + "</td><td>"
						+ rset.getString("bname") + "</td><td>" + rset.getDate("bdate") + "</td><td>" + rset.getInt("bhit")
						+ "</tr>");
					}

					//////////////////////////////////
					//3. JDBD 끊기 필요한 코드? conn.close()
					if (rset != null) {
						pstmt.close();
					}
					if (pstmt != null) {
						conn.close();
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

		<div class="text-end">
			<a href="write.jsp" title="글쓰기 폼" class="btn btn-danger ">글쓰기</a>
		</div>

	</form>
</section>
<%@include file="./inc/footer.jsp"%>
<!--Q1.header-navbard 좋아하는 색상-->
<!--Q2. footer-copyright 넣고 좋아하는 배경색상/글자중앙-->
<!--board1.html-->
<!--boot-->