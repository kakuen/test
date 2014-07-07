package jp.co.fitec.lesson.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.lesson.DAO.ReportDAO;


public class ReportList implements Action{
	
	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response) 
			                              throws ServletException, IOException {
		
		ReportDAO reportDao = new ReportDAO();
		List<Report> categoryList = reportDao.findAll();
		request.setAttribute("categoryList", categoryList);
		
		return "Report.jsp";
	}
}
