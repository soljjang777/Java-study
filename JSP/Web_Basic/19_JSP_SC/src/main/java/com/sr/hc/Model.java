package com.sr.hc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Model {

	public static void print1(HttpServletRequest request) {

		// parameter = v���� ���� ��
		// String or String[] ��¶�� String
		// �װ� req�� �Ƿ� �Ѿ���°�

		// ���� ������
		// java = req.getParameter("�Ķ���͸�");
		// EL = ${param.�Ķ���͸�}

		String aa = request.getParameter("a");

		// attribute = M(�ڹٿ���)
		// Object(�ڷ��� ����x)
		// req�� �Ƿ���

		// ���� ������
		// java = req.getAttribute("��Ʈ����Ʈ��")
		// EL = ${��Ʈ����Ʈ��}

		String bb = (String) request.getAttribute("b");

		
	}

	public static void print2(HttpServletRequest request, HttpServletResponse response) {

		// session.attr (session�� attr)
		// M���� ���� ��
		// ����------------Ŭ���̾�Ʈ ���� ���¿� ���
		// �ð�����
		// Object

		// �� ������
		// java = req.getSession().getAttribute("��Ʈ����Ʈ��");
		// EL = ${sessionScope.��Ʈ����Ʈ}
		String ccc = (String) request.getSession().getAttribute("c"); //'����'�������
		
		// Cookie
		// M���� ���� ��
		
		// Ŭ���̾�Ʈ ���Ϳ� ���Ϸ� ����
		// ������ ���, ������� �ص� �������
		
		// �� ������
		// java : 
		
		// ���� ������� �ִ� ��Ű��
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			System.out.println(c);
			if(c.getName().equals("d")) {
				System.out.println(c.getValue());
			}
		}
		
		// EL : ${cookie.��Ű�̸�.value}
	}

	public static void make1(HttpServletRequest request, HttpServletResponse response) {
		String bbb = "������";
		request.setAttribute("b", bbb);

		// ����ϴ� �� (�� 4��)
				// param, attr
				// Ư¡�� third���� �� ��

				// Session, Cookie

				// <Session>
				// Session.attribute(������ attr)

				String ccc = "����";
				HttpSession hs = request.getSession();
				hs.setMaxInactiveInterval(10); // ���� ���� 10��
				hs.setAttribute("c", ccc);

				// ������ Ŭ���̾�Ʈ�� �������
				// ���� & Ŭ���̾�Ʈ�� ���Ḹ ��� ������
				// �� ����Ʈ ��𿡼��� ��� ����

				// ������ �������� ���� (���� ���� / ������ ������)
				// ���� �����ð� (�⺻ 30��)
				// �ð� ���� '��û'�� �Ͼ�� ������ ����
				// �ð� ���� '��û'���� �۾��� �ϸ� ����(�����ð� �ʱ�ȭ)

				// <Cookie>

				// ����� ��ǻ�Ϳ� ��������
				// Cookie�� �ð� ���� �� �� ����

				String ddd = "��Ű";
				Cookie coo = new Cookie("d", ddd);
				coo.setMaxAge(5 * 60); // 5��

				response.addCookie(coo);

	}
}
