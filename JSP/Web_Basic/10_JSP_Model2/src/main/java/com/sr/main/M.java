package com.sr.main;

import javax.servlet.http.HttpServletRequest;

// M (Model) - 비즈니스 로직
// 계산, DB

public class M {

	public void calc(HttpServletRequest request) {
	//void말고 스태틱 쓰면 다른데서 객체 안만들고 쓸 수 있음	
		// a, b가 request에 담겨 있음
		int aa = Integer.parseInt(request.getParameter("a"));
		int bb = Integer.parseInt(request.getParameter("b"));
		System.out.println(aa);
		System.out.println(bb);
		int cc = aa+bb;
		
		// 여기서 나온 cc를 v2로 보낼 수 있게
		request.setAttribute("ccc", cc);
		
	}


	
	
	
	
	
	
	
	
}
