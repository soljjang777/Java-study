package com.sr.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NameAge")
public class NameAge extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   // �Ķ���� ������ ����Ϸ��� request
	      String name = request.getParameter("name");
	      int age = Integer.parseInt(request.getParameter("age"));
	      
	      response.setCharacterEncoding("euc-kr");
	      PrintWriter out = response.getWriter();
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"euc-kr\">");
	      out.print("</head>");
	      out.print("<body>");
	      
	      // ���̰� 20���� ������ ����, �ƴϸ� �ݸ��� �λ�
	      if (age >= 20) {
	         out.printf("%s�� �ȳ��ϼ���", name);
	      } else {
	         out.printf("%s, �ȳ�", name);
	      }
	      out.print("<h1>�޷� ����</h1>");
	      
	      out.print("</body>");
	      out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
