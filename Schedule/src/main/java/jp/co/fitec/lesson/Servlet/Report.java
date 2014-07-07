package jp.co.fitec.lesson.Servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.lesson.DAO.ReportDAO;


public class Report implements Action {
	
	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String time = request.getParameter("time");
		String categoryId = request.getParameter("code");
		
		ReportDAO reportDao = new ReportDAO();
		request.setAttribute("Category", reportDao.findBy(time, categoryId));
		

		return "Report.jsp";
	}

}

