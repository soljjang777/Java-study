package com.sr.bmi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sr.log.AccountDAO;


@WebServlet("/BmiController")
public class BmiController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "bmi/bmi_input.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		B.calc(request);
		AccountDAO.loginCheck(request);
		request.setAttribute("contentPage", "bmi/bmi_output.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

}
