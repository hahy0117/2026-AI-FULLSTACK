<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@include file="inc/header.jsp" %>

<div class="container my-5">
  <h3>마이페이지</h3>
  <table class="table table-bordered table-striped">
    <caption>Userinfo</caption>
    <tbody>
      <tr>
        <th scope="row">닉네임</th>
        <td><%=request.getAttribute("nickname") %></td>
      </tr>
      <tr>
        <th scope="row">이메일</th>
        <td><%=request.getAttribute("email") %></td>
      </tr>
      <tr>
        <th scope="row">휴대폰</th>
        <td><%=request.getAttribute("mobile") %></td>
      </tr>
      <tr>
        <th scope="row">가입일</th>
        <td><%=request.getAttribute("update") %></td>
      </tr>
      <tr>
        <th scope="row">가입IP</th>
        <td><%=request.getAttribute("bip") %></td>
      </tr>
    </tbody>
  </table>
</div>

<%@include file="inc/footer.jsp" %>
