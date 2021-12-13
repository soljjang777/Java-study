package com.sr.bmi;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class B {

	public static void calc(HttpServletRequest request) throws IOException {
		
		String path = request.getSession().getServletContext().getRealPath("img");
		System.out.println(path);
		
		MultipartRequest mr = new MultipartRequest(request, path, 
		30 * 1021 * 1024, "utf-8", new DefaultFileRenamePolicy());

		String sa = mr.getFilesystemName("sa");
		String name = mr.getParameter("name");
		int weight = Integer.parseInt( mr.getParameter("weight"));
		int height = Integer.parseInt( mr.getParameter("height"));

		double bmi = (weight) / ((height / 100) * (height / 100));
		String result = "비만";

		if (bmi < 18.5) {
			result = "저체중";
		} else if (bmi < 23) {
			result = "정상";
		} else if (bmi >= 23 && bmi < 25) {
			result = "과체중";
		}
		
		Result re = new Result(weight, height, bmi, result, name, sa);
		request.setAttribute("re", re);
	}

}
