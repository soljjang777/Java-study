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
		   // 파라미터 변수를 사용하려면 request
	      String name = request.getParameter("name");
	      int age = Integer.parseInt(request.getParameter("age"));
	      
	      response.setCharacterEncoding("euc-kr");
	      PrintWriter out = response.getWriter();
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"euc-kr\">");
	      out.print("</head>");
	      out.print("<body>");
	      
	      // 나이가 20살이 넘으면 존댓말, 아니면 반말로 인사
	      if (age >= 20) {
	         out.printf("%s님 안녕하세요", name);
	      } else {
	         out.printf("%s, 안녕", name);
	      }
	      out.print("<h1>메롱 ㅋㅋ</h1>");
	      
	      out.print("</body>");
	      out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
