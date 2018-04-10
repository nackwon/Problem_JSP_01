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
		//System.out.println("����"); ����Ȯ��
		this.doPost(request, response );
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "./Main/Information.jsp"; //ó�� ���� ������
		
		//���� ����
		//String path = this.getServletContext().getRealPath("WEB-INF/file/Abc1115.txt");
		//InfoDAO dao = new InfoDAO();
		//dao.insertInfo(path);
		
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}	
}
