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
		
		// °úÀÚ (°´Ã¼) ¿©·¯°³ ÀúÀå
		//		3°³Á¤µµ ÀÌ¸§, °¡°İ
		
		ArrayList<Snacs> snacks = new ArrayList<Snacs>();
		
		snacks.add(new Snacs("·Ôµ¥»©»©·Î", 1500, d));
		snacks.add(new Snacs("½ã´õÃÊÄİ¸´", 5000, d));
		snacks.add(new Snacs("»õ¿ì±ø", 1000, d));
		
		
		request.setAttribute("snacks", snacks);
	}

}
