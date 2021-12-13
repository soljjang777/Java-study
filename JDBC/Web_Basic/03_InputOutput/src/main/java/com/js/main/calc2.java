package com.js.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc2")
public class calc2 extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int x = Integer.parseInt(request.getParameter("x"));
		 int y = Integer.parseInt(request.getParameter("y"));
		 String[] cc = request.getParameterValues("c");
				 			 
		 response.setCharacterEncoding("utf-8");
	      PrintWriter out = response.getWriter();
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"utf-8\">");
	      out.print("</head>");
	      out.print("<body>");
	      for (String s : cc) {
			if(s.equals("+")) {
				out.printf("%d + %d = %d<p>", x, y ,x+y);
			}else if (s.equals("-")) {
				out.printf("%d - %d = %d<p>", x, y ,x-y);
			}else if (s.equals("*")) {
				out.printf("%d * %d = %d<p>", x, y ,x*y);
			}else if (s.equals("/")) {
				out.printf("%d %s %d = %d<p>", x, s, y , x/y);
			}
		}
	    	         
	      out.print("</body>");
	      out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
