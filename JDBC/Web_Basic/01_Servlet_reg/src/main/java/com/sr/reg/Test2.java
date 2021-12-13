package com.sr.reg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Test2")
public class Test2 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setCharacterEncoding("euc-kr");
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<mete charset=\"euc-kr\">");
		out.print("</head>");
		out.print("<body>");
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				out.print("<h1>¼­ºí¸´ ¼º°ø" + i + j + "</h1>");	
			}
			out.print("<h1>--------------------------------</h1>");
		}
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
