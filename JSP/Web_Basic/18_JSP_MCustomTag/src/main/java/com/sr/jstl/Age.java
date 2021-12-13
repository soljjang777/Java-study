package com.sr.jstl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class Age {

	public static void calc(HttpServletRequest request) {
		int birth = Integer.parseInt(request.getParameter("birth"));
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		int curYear = Integer.parseInt(sdf.format(d));

		int age = curYear - birth + 1;

		request.setAttribute("age", age);

		int[] ar = { 1, 3, 4, 7, 9 };
		request.setAttribute("ar", ar);
		
		ArrayList<Menus> menus = new ArrayList<Menus>();
		
		menus.add(new Menus("��ġ���", 6000));
		menus.add(new Menus("������", 7000));
		menus.add(new Menus("�c��ұ���", 10000));
		menus.add(new Menus("��Ÿ��", 13000));
		
		request.setAttribute("menus", menus);

	}

}
