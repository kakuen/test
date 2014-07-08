package jp.co.fitec.lesson.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.Action;

public class LogoutAction {

	public String doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		response.sendRedirect("/webapp-bookstore/");
		return null;
	}

}
