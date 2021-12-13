package com.sr.unit;

import javax.servlet.http.HttpServletRequest;

public class Bmi {

	public static void calc(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
			 int in = Integer.parseInt(request.getParameter("in"));
			 String dan = request.getParameter("dan");
			 
			 String danwi2 = "";
			 String danwi3 = "";
			 String cn = "";
			 double result = 0;

			 if(dan.equals("길이")) {
				 danwi3 ="cm";
				 danwi2 = "inch";
				 result = in / 2.54; 
				 cn = "a";
			 }else if(dan.equals("넓이")) {
				 danwi3 ="㎥";
				 danwi2 = "평";
				 result = in * 0.3025;
				 cn = "b";
			 }else if(dan.equals("온도")){
				 danwi3 ="℃";
				 danwi2 = "℉";
				 result = (in * 1.8) + 32;
				 cn = "c";
			 }else if(dan.equals("속도")) {
				 danwi3 ="km/h";
				 danwi2 = "mi/h";
				 result = in * 0.621371;
				 cn = "d";
			 }
		
			 String result2 = String.format("%.1f",result);
			 
			 Result r = new Result(in, dan, danwi2, cn, result2);
			 request.setAttribute("rr", r);
			 request.setAttribute("danwi3", danwi3);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 
	}

}
