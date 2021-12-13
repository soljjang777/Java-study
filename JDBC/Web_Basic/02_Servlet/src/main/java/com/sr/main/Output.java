package com.sr.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Output")
public class Output extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  // 파라미터 변수를 사용하려면 request
	      String say = request.getParameter("say");
	      int cnt = Integer.parseInt(request.getParameter("cnt"));
	      
	      response.setCharacterEncoding("euc-kr");
	      PrintWriter out = response.getWriter();
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"euc-kr\">");
	      out.print("</head>");
	      out.print("<body>");
	      
	      for (int i = 0; i < cnt; i++) {
			out.printf("<h2> %s </h2>",say);
		}
	      
	      out.print("</body>");
	      out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
