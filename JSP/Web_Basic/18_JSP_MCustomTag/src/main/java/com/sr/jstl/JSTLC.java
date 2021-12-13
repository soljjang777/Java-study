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
		
		// �Ķ���Ͱ� �ֵ��� ���ε� �տ� ! NOT�� �������� ������ ���� �� ���´�
		// �Ķ���Ͱ� ���ٴ� ��
		if(!request.getParameterNames().hasMoreElements()) {
			// ���� �Է� �ޱ����� �� ��� (�Ķ���� ����, ��ǲ������)
			request.setAttribute("contentPage", "jstl/input.jsp");
		}else {
			// ��� 
			Age.calc(request);
			request.setAttribute("contentPage", "jstl/output.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
