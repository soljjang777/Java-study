package com.sr.hc;

import javax.servlet.http.HttpServletRequest;

public class Exchange {

	public static void calc(HttpServletRequest request) {

		// �� �ޱ�

		int price = Integer.parseInt(request.getParameter("p"));
		int money = Integer.parseInt(request.getParameter("m"));

		int ex = 0;

		int ex2 = 0;
		String say = null;

		if (price < money) {
			ex = money - price;
			say = "�ܵ� ���� �ֽ��ϴ�~";
		} else if (price > money) {
			ex = money - price;
			ex2 = price - money;
			say = "���� ���ڸ�����~";
		} else {
			say = "�����մϴ�";
		}

//		request.setAttribute("price", price);
//		request.setAttribute("momey", momey);
//		request.setAttribute("exchange", ex);
//		request.setAttribute("say", say);

		// ����ó�� �ʿ��Ѱ͵��� ���� �Ǿ ������ �Ǵµ�
		// �ѵ� ���ļ� �����ڴ°�(��ü).

		request.setAttribute("ex2", ex2);
		Result r = new Result(price, money, ex, say);
		request.setAttribute("rr", r);
	}

	public static void mrv(HttpServletRequest request) {

		int how = Integer.parseInt(request.getParameter("how"));
		how *= -1;
		request.setAttribute("how2", how);

		
	}

}
