package com.sr.m3;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/MovieUpdateC")
public class MovieUpdateC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("title") == null) {
			MovieDAO.getMovie(request);			
			request.setAttribute("contentPage", "jsp/m3detail.jsp");
		}else {
			// 일 (입력 받은 내용)
			
			MovieDAO.updateMoive(request);	
			MovieDAO.getAllmovie(request);
			
			request.setAttribute("contentPage", "jsp/m3.jsp");				
			
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MovieDAO.updateMoive(request);	
		MovieDAO.getAllmovie(request);
		request.setAttribute("contentPage", "jsp/m3.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);

	}

}
