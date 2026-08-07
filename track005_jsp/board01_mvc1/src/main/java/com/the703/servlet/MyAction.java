package com.the703.servlet;

import java.io.IOException;
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
 * Servlet implementation class MyAction
 */
@WebServlet("/MyAction")
public class MyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		HttpSession session=request.getSession();
		String email= (String)session.getAttribute("email");
		
		Connection conn=null; PreparedStatement pstmt=null; ResultSet rset=null;
		String url="jdbc:mysql://localhost:3306/mbasic";
		String sql="select * from users where email=?";
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url,"root","1234");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, email);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				request.setAttribute("nickname", rset.getString("nickname"));
				request.setAttribute("email", rset.getString("email"));			
				request.setAttribute("mobile", rset.getString("mobile"));
				request.setAttribute("update", rset.getString("udate"));
				request.setAttribute("bip", rset.getString("bip"));
			}			
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
			if(rset != null)  { rset.close();}
			if(pstmt != null)  { pstmt.close();}
			if(conn != null)  { conn.close();}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
