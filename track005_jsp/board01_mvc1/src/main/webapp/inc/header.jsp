<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
    <!--header -->
	<!--header -->
	<!--header -->
	<!--header -->
	<!--header -->

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>mvc1-board</title>
<!-- Latest compiled and minified CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet">
<!-- Latest compiled JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"></script>
<link href="./css/board.css" rel="stylesheet">
</head>

<body>
	<header>

		<div class=" p-5 text-white text-center myvisual" style=" background-color:#CDB4DB">
			<h1>First Template</h1>
			<p>MVC1 JSP PROJECT</p>
		</div>

		<nav class="mynav navbar navbar-expand-sm navbar-info" style=" background-color:#FFB6C1" >
			<h2 class="myhidden">Logo</h2>
			<div class="container-fluid">
				<a class="navbar-brand" href="javascript:void(0)">hyewon</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#mynavbar">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="mynavbar">
					<ul class="navbar-nav ms-auto">
					<!--애플리케이션 루트기준 -->
					<%@taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
					<c:if test="${empty sessionScope.emil}">					
						<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/LoginAction">Login</a></li>
						<li class="nav-item">
						<a class="nav-link"href="${pageContext.request.contextPath}/JoinAction">Join</a></li>
							</c:if>
							
						<c:if test="${not empty sessionScope.email}">
						<li class="nav-item">
						<a class="nav-link" href="${pageContext.request.contextPath}/MyAction">${sessionScope.email}</a></li>
						
						<li class="nav-item">						
						<a class="nav-link"href="${pageContext.request.contextPath}/Logout">Logout</a></li>
						</c:if>	
						
					</ul>

				</div>
			</div>
		</nav>
	</header>