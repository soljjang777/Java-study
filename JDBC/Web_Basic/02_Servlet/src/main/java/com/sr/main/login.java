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
	    	  out.print("���� ���� �ʴ� ȸ���Դϴ�!");
	      }else if(id.equals("sr") && !pw.equals("1004")) {
	    	  out.print("��й�ȣ����!");
	      }else if(id.equals("sr") && pw.equals("1004")) {
	    	  out.print("<h2 style=\"color: red;\">�α��μ���!</h2>");	    	  
	      }

	      
	      out.print("</body>");
	      out.print("</html>");

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// (id�� �ѱ��� �Ⱦ��µ� �׳� ���ο�)
		// post��� �ѱ�ó��
		request.setCharacterEncoding("utf-8");  //post�� �ѱ� ó���� �� ������ߵ�(get�� utf-8������ post�� io�ӽñ�)
		
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
	    	  out.print("���� ���� �ʴ� ȸ���Դϴ�!");
	      }else if(id.equals("sr") && !pw.equals("1004")) {
	    	  out.print("��й�ȣ����!");
	      }else if(id.equals("sr") && pw.equals("1004")) {
	    	  out.print("<h2 style=\"color: red;\">�α��μ���!</h2>");	    	  
	      }

	      
	      out.print("</body>");
	      out.print("</html>");

	}
	}

}
