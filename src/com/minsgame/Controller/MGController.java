package com.minsgame.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minsgame.BIZ.TestBIZ;
import com.minsgame.VO.Test;

public class MGController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MGController() {

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		
		if(uri.endsWith("signup")) {
			doSignUp(request, response);
		} else if(uri.endsWith("login")) {
			doLogIn(request, response);
		} else if(uri.endsWith("logout")) {
			doLogOut(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void doSignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		
		System.out.println("doSignUp()");
		System.out.println(userid + " : " + password);
		
		Test test = new Test(userid, password);
		
		Test test_res = new TestBIZ().insertMember(test);
	
	}
	
	protected void doLogIn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doLogOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
