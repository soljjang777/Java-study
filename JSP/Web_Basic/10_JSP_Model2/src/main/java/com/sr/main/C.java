package com.sr.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// C (Controller) - 교통정리
// 상황 판단해서 필요한쪽으로 보냄

//웹사이트 진입점
@WebServlet("/C")
public class C extends HttpServlet {
// 주소를 쳐서 접속하거나 클릭해서 들어가는 경우	
// 어떤 사이트에 처음 들어가는경우 : GET방식 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식 요청 들어오면 v.html로 포워딩
		
		request.getRequestDispatcher("v.html").forward(request, response); //리퀘스트값을 가져감
		
		//response.sendRedirect("v.html"); //리퀘스트값을 안가져감
		// 지금 같은 경우 써도 되는데 나중에 다 forward로 처리하닌깐
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		M m = new M();
		m.calc(request);
		
		request.getRequestDispatcher("v2.jsp").forward(request, response);
	}

}
