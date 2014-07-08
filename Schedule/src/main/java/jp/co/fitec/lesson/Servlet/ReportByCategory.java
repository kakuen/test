package jp.co.fitec.lesson.Servlet;

import java.io.IOException;



import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.lesson.DAO.ReportDAO;
import jp.co.fitec.lesson.entity.Event;


public class ReportByCategory implements Action {
	
	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String categoryId = request.getParameter("categoryId");
		
		ReportDAO reportDao = new ReportDAO();
		List<Event> eventList = reportDao.findByCategory(categoryId);
		
		long totalTime = 0;
		long diffTime = 0;
		for(Event event : eventList){
			diffTime = event.getEventEnd().getTime() - event.getEvenStart().getTime();
		}
		request.setAttribute("results",eventList );
		return "RpByCtg.jsp";
	}

}

