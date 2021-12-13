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
				say = "잔돈 여기 있습니다~";
			} else if (price > money) {
				ex = money - price;

				say = "돈이 모자른데요~";
			} else {
				say = "감사합니다";
			}
		 
		 Result r = new Result(price, money, ex, say);
		 request.setAttribute("rr", r);
		
	}

}
