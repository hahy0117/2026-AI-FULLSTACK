package com.the703.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



/**
 * Servlet implementation class LoginAction
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("login.jsp").forward(request, response); // 로그인 폼으로
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		//데이터 넘겨받기
		String email=request.getParameter("email");
		String bpass=request.getParameter("bpass");	
		HttpSession session=request.getSession();
		
		PrintWriter out=response.getWriter();
		//sql 처리 ( 드 커 프 리)
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		String url="jdbc:mysql://localhost:3306/mbasic";
		String sql="select count(*) cnt from users where email=? and bpass=?";
		int find=-1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(url,"root","1234");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, bpass);
			rset=pstmt.executeQuery();
			
			if(rset.next()) {
				find=rset.getInt("cnt");
			}
			if(find==1) {
				session.setAttribute("email",email);
				out.println("<script> alert('로그인성공'); location.href='MyAction'; </script>");
			}else {
				out.println("<script> alert('정보 확인!'); history.go(-1); </script>");
			}
			if(pstmt != null)  { pstmt.close();}
			if(conn != null)  { conn.close();}
		}catch(Exception e) {
			e.printStackTrace();
		}
		//해당화면으로 넘기기
		//request.getRequestDispatcher("login.jsp").forward(request,response);
		
		
		
		
	}

}
