package com.sr.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 String id = request.getParameter("id");
		 String pw = request.getParameter("pw");
		 
		 response.setCharacterEncoding("euc-kr");
	      PrintWriter out = response.getWriter();
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"euc-kr\">");
	      out.print("</head>");
	      out.print("<body>");
	      
	      out.print("id : " + id + "<br>");
	      out.print("pw : " + pw );
	      
	      if(!id.equals("sr")) {
	    	  out.print("존재 하지 않는 회원입니다!");
	      }else if(id.equals("sr") && !pw.equals("1004")) {
	    	  out.print("비밀번호오류!");
	      }else if(id.equals("sr") && pw.equals("1004")) {
	    	  out.print("<h2 style=\"color: red;\">로그인성공!</h2>");	    	  
	      }

	      
	      out.print("</body>");
	      out.print("</html>");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// (id는 한글을 안쓰는데 그냥 공부용)
		// post방식 한극처리
		request.setCharacterEncoding("utf-8");  //post는 한글 처리할 때 적어줘야됨(get은 utf-8이지만 post는 io머시기)
		
		 String id = request.getParameter("id");
		 String pw = request.getParameter("pw");
		 
		 response.setCharacterEncoding("utf-8");
	     PrintWriter out = response.getWriter();
	      
	      out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"euc-kr\">");
	      out.print("</head>");
	      out.print("<body>");
	      
	      out.print("id : " + id + "<br>");
	      out.print("pw : " + pw );
	      
	      if(!id.equals("sr")) {
	    	  out.print("존재 하지 않는 회원입니다!");
	      }else if(id.equals("sr") && !pw.equals("1004")) {
	    	  out.print("비밀번호오류!");
	      }else if(id.equals("sr") && pw.equals("1004")) {
	    	  out.print("<h2 style=\"color: red;\">로그인성공!</h2>");	    	  
	      }

	      
	      out.print("</body>");
	      out.print("</html>");

	}
	}

}
