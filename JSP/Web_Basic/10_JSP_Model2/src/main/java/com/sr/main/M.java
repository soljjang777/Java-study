package com.sr.main;

import javax.servlet.http.HttpServletRequest;

// M (Model) - ����Ͻ� ����
// ���, DB

public class M {

	public void calc(HttpServletRequest request) {
	//void���� ����ƽ ���� �ٸ����� ��ü �ȸ���� �� �� ����	
		// a, b�� request�� ��� ����
		int aa = Integer.parseInt(request.getParameter("a"));
		int bb = Integer.parseInt(request.getParameter("b"));
		System.out.println(aa);
		System.out.println(bb);
		int cc = aa+bb;
		
		// ���⼭ ���� cc�� v2�� ���� �� �ְ�
		request.setAttribute("ccc", cc);
		
	}


	
	
	
	
	
	
	
	
}
