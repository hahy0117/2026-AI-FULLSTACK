package com.the703.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlet002
 */
@WebServlet("/life")
public class servlet002 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int initCnt=1; //init 맨처음
	int doGetCnt=1; //Thread get/post
	int destroyCnt=1; // 맨마지막
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet002() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("...............#1. init() 첫요청에만 호출>"+ initCnt++);
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.err.println("파일 조금수정하기 ctrl+s 저장");
		System.out.println("..............#3. destroy() 맨마지막에 호출 호출>"+destroyCnt++);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("................#2. get() 요청처리를 할때마다 호출>"+ doGetCnt++);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
