package jp.co.fitec.lesson.Servlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.fitec.lesson.DAO.ReportDAO;
import jp.co.fitec.lesson.entity.Event;


public class ReportByTime implements Action{
	
	@Override
	public String doAction(HttpServletRequest request, HttpServletResponse response) 
			                              throws ServletException, IOException, ParseException {
		
		String dat = request.getParameter("time");
		Date time = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss").parse(dat);
		
			Date time2 = new Date();
			time2.setYear(time.getYear());
			time2.setMonth(time.getMonth()-1);
			time2.setDate(time.getDate());
			time2.setHours(time.getHours());
			time2.setMinutes(time.getMinutes());
			time2.setSeconds(time.getSeconds());
			
			ReportDAO reportDao = new ReportDAO();
			List<Event> eventList = reportDao.findByTime(time,time2);
			
			List<Event> eventList2 = eventList;
			
			long totalTime = 0;
			long diffTime = 0;
			for(Event event : eventList){
				for(Event event2 : eventList2){
					if(event.getCategory().equals(event2.getCategory())){
						diffTime = event.getEventEnd().getTime() - event.getEvenStart().getTime();
					}
					}
			}
			request.setAttribute("results", eventList);
	
			return "RpByTm.jsp";
		

	}


}
