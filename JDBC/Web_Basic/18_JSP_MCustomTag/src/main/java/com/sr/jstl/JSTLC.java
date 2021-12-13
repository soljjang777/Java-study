package com.sr.jstl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JSTLC")
public class JSTLC extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파라미터가 있따는 뜻인데 앞에 ! NOT로 뒤집었기 때문에 현재 쓴 상태는
		// 파라미터가 없다는 뜻
		if(!request.getParameterNames().hasMoreElements()) {
			// 값을 입력 받기위한 폼 출력 (파라미터 없음, 인풋페이지)
			request.setAttribute("contentPage", "jstl/input.jsp");
		}else {
			// 결과 
			Age.calc(request);
			request.setAttribute("contentPage", "jstl/output.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
