package com.js.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Checkbox")
public class Checkbox extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 
		 response.setCharacterEncoding("utf-8");
	      PrintWriter out = response.getWriter();
	      
	      String[] cc = request.getParameterValues("c");
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"utf-8\">");
	      out.print("</head>");
	      out.print("<body>");
	      
	      for (String s : cc) {
			out.printf("<h3>%s</h3>", s);
		}
	      
	      for (int i = 0; i < cc.length; i++) {
			out.printf("<h3>%s</h3>", cc[i]);
			
		}

	      
	      out.print("</body>");
	      out.print("</html>");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
