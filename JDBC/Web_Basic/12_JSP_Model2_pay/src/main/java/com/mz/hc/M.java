package com.mz.hc;

import javax.servlet.http.HttpServletRequest;

public class M {

	public static void calc(HttpServletRequest request) {
		
		//�� �ޱ�
		int e = Integer.parseInt(request.getParameter("earn"));
		int s = Integer.parseInt(request.getParameter("spend"));
		
		// ������ ���
		int result = e - s;
		
		System.out.println(e);
		System.out.println(s);
		System.out.println(result);
		
		// �װ� �ѵ� ��ġ��
		
		Remain re = new Remain();
		re.setE(e);
		re.setS(s);
		re.setR(result);
		request.setAttribute("re", re);
		
	}

}
