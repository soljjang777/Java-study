package com.sr.main;

import javax.servlet.http.HttpServletRequest;

public class Exchange {

	public static void calc(HttpServletRequest request) {

		 int price = Integer.parseInt(request.getParameter("p"));
		 int money = Integer.parseInt(request.getParameter("m"));
		 
		 int ex = 0;
		 String say = null;
		 if (price < money) {
				ex = money - price;
				say = "�ܵ� ���� �ֽ��ϴ�~";
			} else if (price > money) {
				ex = money - price;

				say = "���� ���ڸ�����~";
			} else {
				say = "�����մϴ�";
			}
		 
		 Result r = new Result(price, money, ex, say);
		 request.setAttribute("rr", r);
		
	}

}
