package com.sr.sr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@xxx : anotation - �ڵ����� ���� ����

//servlet 2.x�� ��� 3.0 ���ĺ��� @WebServlet ��� ����
//Tomcat 5.0 ���� : ��Ĺ �������Ͽ� ���� ��� �ؾߵ�

@WebServlet("/AA")
public class AA extends HttpServlet {
	// ������̼� ���ǻ���
	   // 1. �����ص� �ȹٲ��� �������� �ٲ���� �� (CTRL+C,V)
	   // 2. �����ͷ� �ٲ㵵 �������� �ٲ���� �� (RENAME)	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test!!!!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
