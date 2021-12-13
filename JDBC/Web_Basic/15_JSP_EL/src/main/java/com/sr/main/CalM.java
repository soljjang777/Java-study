package com.sr.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class CalM {

	public static void calc(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			String n = request.getParameter("n");
			double m = Double.parseDouble(request.getParameter("mid"));
			double l = Double.parseDouble(request.getParameter("last"));
			
			double avg = (m + l) /2;
			String grade = "F";
			
			if(avg >= 90 ) {
				grade = "A";
			}else if(avg >= 80) {
				grade = "B";
			}else if(avg >= 70) {
				grade = "C";
			}else if(avg >= 60) {
				grade = "D";
			}
			
			String avg2 = String.format("%.2f", avg);
			
			Result r = new Result(n, m, l, avg2, grade);
			request.setAttribute("rr", r);
			
			///////////////////////////////////////////////////////
			
			request.setAttribute("a", "ㅋㄷ");
			request.setAttribute("b", "ㅎㅅㅎ");
			
			int[] ar = {3,6,9};
			request.setAttribute("c", ar);
			
			Result[] ar2 = new Result[2];
			ar2[0] = new Result("솔리", 80, 90, "90", "A");
			ar2[1] = new Result("준석", 70, 60, "100", "A");
			request.setAttribute("d", ar2);
			
			ArrayList<Result> al = new ArrayList<Result>(); //가변배열
			al.add(new Result("사", 10, 20, "50", "A"));
			al.add(new Result("랑", 10, 20, "60", "B"));
			al.add(new Result("해", 10, 20, "70", "C"));
			
			request.setAttribute("e", al);
					
			
												
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
