package com.sr.sr;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//��Ĺ����ȵǸ� �Ʒ� �޼ҵ� ����ȵ�
@WebServlet("/Test")
public class Test extends HttpServlet {

	//  �ǹ� : ���� servlet�� ��� �� ������ �ְ�
	// ���� ���� �߰��ؼ� ���ڴ�
	
	// servlet class : �⺻���ΰ� �� ����� �ִ°�
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(req, resp);
		System.out.println("test");
	}
	
	
}
