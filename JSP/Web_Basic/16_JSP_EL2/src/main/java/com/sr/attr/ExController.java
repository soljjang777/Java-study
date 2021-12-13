package com.sr.attr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ExController")
public class ExController extends HttpServlet {

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Exchange.mrv(request);

		request.getRequestDispatcher("attr/output3.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 950추가 처리할게 없음. 그냥 결과 페이지로 잘 보내주기만 하면 됨.
		request.getRequestDispatcher("attr/output3.jsp").forward(request, response);
	}

}
