package com.sr.format;

import java.util.ArrayList;
import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;

public class DataMaker {

	public static void make(HttpServletRequest request) {
		
		int a = 123456789;
		request.setAttribute("a", a);
		
		double b = 0.4566;
		request.setAttribute("b", b);
		
		double c = 123123.456456;
		request.setAttribute("c", c);
		
		Date d = new Date();
		request.setAttribute("d", d);
		
		// ���� (��ü) ������ ����
		//		3������ �̸�, ����
		
		ArrayList<Snacs> snacks = new ArrayList<Snacs>();
		
		snacks.add(new Snacs("�Ե�������", 1500, d));
		snacks.add(new Snacs("������ݸ�", 5000, d));
		snacks.add(new Snacs("�����", 1000, d));
		
		
		request.setAttribute("snacks", snacks);
	}

}
