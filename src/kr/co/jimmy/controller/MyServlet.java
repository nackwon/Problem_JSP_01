package kr.co.jimmy.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.jimmy.DAO.InfoDAO;

public class MyServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("맵핑"); 연결확인
		this.doPost(request, response );
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "./Main/Information.jsp"; //처음 연결 페이지
		
		String path = this.getServletContext().getRealPath("WEB-INF/file/Abc1115.txt");
		InfoDAO dao = new InfoDAO();
		dao.insertInfo(path);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}	
	

}
