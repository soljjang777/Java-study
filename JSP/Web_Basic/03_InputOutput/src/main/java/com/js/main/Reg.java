package com.js.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Reg")
public class Reg extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 // 1. ���� �ޱ�
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String sex = request.getParameter("sex");	
		String adress = request.getParameter("adress");	
		String []hobby = request.getParameterValues("hobby");
		String itd = request.getParameter("itd");
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(sex);
		System.out.println(adress);
		System.out.println(hobby);
		System.out.println(itd);
		
		// 2. �� Ȯ�� �Ǹ�, body�ȿ� �� ������ ���еǰ� �����ֱ�
		response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		
		  out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"utf-8\">");
	      out.print("<link rel=\"stylesheet\" href=\"reg.css\">");
	      out.print("</head>");
	      out.print("<body>");
	      out.print("name : " + name + "<br>");
	      out.print("id : " + id + "<br>");
	      out.print("pw : " + pw + "<br>");
	      out.print("Gender : " + sex + "<br>");
	      out.print("Adress : " + adress + "<br>");
	      

	      for (String s : hobby) {
	    	  out.printf("hobby :" + s +"<br>");
		}
	      
	      out.print("<hr>");
	      itd = itd.replace("\r\n","<br>");
	      out.print("Introduce : " + itd + "<br>");
	      
	      
	      

	    	         
	      out.print("</body>");
	      out.print("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post �ѱ�ó��
		request.setCharacterEncoding("utf-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String sex = request.getParameter("sex");	
		String adress = request.getParameter("adress");	
		String []hobby = request.getParameterValues("hobby");
		String itd = request.getParameter("itd");
		
		System.out.println(name);
		System.out.println(id);
		System.out.println(pw);
		System.out.println(sex);
		System.out.println(adress);
		System.out.println(hobby);
		System.out.println(itd);
		
		// 2. �� Ȯ�� �Ǹ�, body�ȿ� �� ������ ���еǰ� �����ֱ�
		response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		
		  out.print("<html>");
	      out.print("<head>");
	      out.print("<meta charset=\"utf-8\">");
	      out.print("<link rel=\"stylesheet\" href=\"reg.css\">");
	      out.print("</head>");
	      out.print("<body>");
	      
	      out.print("<table border=\"\">\r\n"
	      		+ "		<tr>\r\n"
	      		+ "			<td colspan=\"2\">���ԿϷ�</td>\r\n"
	      		+ "		</tr>\r\n"
	      		+ "		<tr>\r\n"
	      		+ "			<td>�̸�</td>\r\n"
	      		+ "			<td>"+ name +"</td>\r\n"
	      		+ "		</tr>\r\n"
	      		+ "		<tr>\r\n"
	      		+ "			<td>ID</td>\r\n"
	      		+ "			<td>"+ id +"</td>\r\n"
	      		+ "		</tr>		\r\n"
	      		+ "		<tr>\r\n"
	      		+ "			<td>PW</td>\r\n"
	      		+ "			<td>"+ pw +"</td>\r\n"
	      		+ "		</tr>		\r\n"
	      		+ "		<tr>\r\n"
	      		+ "			<td>����</td>\r\n"
	      		+ "			<td>"+ sex +"</td>\r\n"
	      		+ "		</tr>		\r\n"
	      		+ "		<tr>\r\n"
	      		+ "			<td>�ּ�</td>\r\n"
	      		+ "			<td>"+ adress +"</td>\r\n"
	      		+ "		</tr>\r\n"
	      		+ "		<tr>\r\n");
	      		for (String s : hobby) {
					out.print("<tr>\r\n"
							+ "			<td>���ɻ�</td>\r\n"
							+ "			<td>" + s +"</td>");
				}
	      		out.print("<tr>\r\n"
	      				+ "			<td>�ڱ�Ұ�</td>\r\n"
	      				+ "			<td><textarea name=\"itd\">"+ itd.replace("\r\n", "<br>") +"</textarea></td>\r\n"
	      				+ "		</tr>");

	      

	     	      
   	         
	      out.print("</body>");
	      out.print("</html>");

	}

}
