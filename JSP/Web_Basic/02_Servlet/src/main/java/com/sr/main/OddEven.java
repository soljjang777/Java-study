package com.sr.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OddEven")
public class OddEven extends HttpServlet {

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value = Integer.parseInt(request.getParameter("value"));
		
	      response.setCharacterEncoding("euc-kr");
	      PrintWriter out = response.getWriter();
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"euc-kr\">");
	      out.print("</head>");
	      out.print("<body>");
	      
	      if (value % 2 == 0) {
	    	  out.print("Â¦¼öÀÔ´Ï´Ù");
	      }else {
	    	  out.print("È¦¼öÀÔ´Ï´Ù");
	      }
	      
	      out.print("</body>");
	      out.print("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
