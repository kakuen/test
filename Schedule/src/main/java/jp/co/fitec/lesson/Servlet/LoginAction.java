package jp.co.fitec.lesson.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.swing.Action;
import jp.co.fitec.lesson.entity.Employee;


public abstract class LoginAction implements Action {

	public String doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Employee employee = Authenticator.authenticate(email, password);
	
		if(employee != null) { 
			
			HttpSession session = request.getSession();
			session.setAttribute("employeeId", employee);
			
			response.sendRedirect("result.do");
			return null;
			
		} else { 

			request.setAttribute("message", "Incorrect email or password.");
			return "/";
		}
		
	}

}

