package com.sr.fu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/FileUpload")
public class FileUpload extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// 1. ����ڰ� ������ ������ ������ ���� ���(������ �����)
									// ������ ��ǻ�� ���� �������� ��� 
	// String path = "C:\\user\\Desktop";
		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);
		
	// ���� ���ε� -> cos.jar	
		
		// d�̹� ���ε� ��� ó�� ����.
		MultipartRequest mr = new MultipartRequest(request, path, 
				30 * 1021 * 1024, // 30mb
				// ���� �ִ� ��� �뷮(������ ����) ������ ����Ʈ
				"utf-8", //�̰� ������ post��Ŀ��� request.setCharacterEncoding �̰� ���P ��
				new DefaultFileRenamePolicy());
				// ���� ���� ���°� �ƴѵ�, ���ϸ� �ߺ��Ǹ� ��¿����
				// a.jpg, a1.jpg, a2.jpg,......
	
			String name = mr.getParameter("n");
			System.out.println(name);
			
			// ���� ������
			// �ߺ� �ȵǰ� ó���Ѱ� ������ �ø����� ���� �̸��� �߿��Ѱ� �ƴ�
			// ������ ������ �ö� ���ϸ��� �߿�
			String file = mr.getFilesystemName("f");
			System.out.println(file);
			
			String etc = mr.getFilesystemName("e");
			System.out.println(etc);
		
			response.setCharacterEncoding("utf-8");
		    PrintWriter out = response.getWriter();
		      
		      out.print("<html>");
		      out.print("<head>");
		      out.print("<meta charset=\"utf-8\">");
		      out.print("</head>");
		      out.print("<body>");
		     
		      out.print("<h1>" + name + "</h1>");
		      out.print(file);
		      out.printf("<img src='img/%s' width=200px>", file);
		      out.printf("<a href='img/%s'>��������</a>", file);
		      out.printf("<a href='img/%s'>�ٿ�ε�</a>", etc);

		      
		      out.print("</body>");
		      out.print("</html>");

		
	}

}
