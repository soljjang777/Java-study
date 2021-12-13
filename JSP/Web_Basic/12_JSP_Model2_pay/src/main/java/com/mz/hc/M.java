package com.mz.hc;

import javax.servlet.http.HttpServletRequest;

public class M {

	public static void calc(HttpServletRequest request) {
		
		//값 받기
		int e = Integer.parseInt(request.getParameter("earn"));
		int s = Integer.parseInt(request.getParameter("spend"));
		
		// 남은돈 계산
		int result = e - s;
		
		System.out.println(e);
		System.out.println(s);
		System.out.println(result);
		
		// 그걸 한데 뭉치자
		
		Remain re = new Remain();
		re.setE(e);
		re.setS(s);
		re.setR(result);
		request.setAttribute("re", re);
		
	}

}
