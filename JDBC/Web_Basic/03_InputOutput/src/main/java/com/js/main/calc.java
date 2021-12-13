package com.js.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc")
public class calc extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int x = Integer.parseInt(request.getParameter("x"));
		 int y = Integer.parseInt(request.getParameter("y"));
		 
		 response.setCharacterEncoding("utf-8");
	      PrintWriter out = response.getWriter();
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"utf-8\">");
	      out.print("</head>");
	      out.print("<body>");
	      out.print("<table border=\"3\" style=\"width: 400px; height: 300px\">");
	      out.printf("<tr><td>%d + %d = %d</td></tr>", x, y, x+y);
	      out.printf("<tr><td>%d - %d = %d</td></tr>", x, y, x-y);
	      out.printf("<tr><td>%d x %d = %d</td></tr>", x, y, x*y);
	      out.printf("<tr><td>%d / %d = %d</td></tr>", x, y, x/y);
	      out.print("</table>");
	         
	      out.print("</body>");
	      out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
