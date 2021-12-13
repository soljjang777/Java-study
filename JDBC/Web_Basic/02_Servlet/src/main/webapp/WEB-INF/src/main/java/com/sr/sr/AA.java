package com.sr.sr;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@xxx : anotation - 자동으로 뭔가 해줌

//servlet 2.x는 등록 3.0 이후부턴 @WebServlet 사용 가능
//Tomcat 5.0 이전 : 톰캣 설정파일에 따로 등록 해야됨

@WebServlet("/AA")
public class AA extends HttpServlet {
	// 어노테이션 주의사항
	   // 1. 복붙해도 안바껴서 수동으로 바꿔줘야 함 (CTRL+C,V)
	   // 2. 리펙터로 바꿔도 수동으로 바꿔줘야 함 (RENAME)	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test!!!!");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
