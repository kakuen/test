package jp.co.fitec.lesson.DAO;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import jp.co.fitec.lesson.entity.Event;
public class ReportDAO extends BaseDAO {

	public List<Event> findByCategory(String categoryId) {
		Session session = sessionFactory.getCurrentSession();
		List<Event> eventList = session.createCriteria(Event.class)
				.add(Restrictions.eq("categoryId", categoryId))
				.list();
		
		return eventList;
	}

	public List<Event> findByTime(Date time,Date time2) {
		
		Session session = sessionFactory.getCurrentSession();
		List<Event> eventList = session.createCriteria(Event.class)
				.add(Restrictions.ge("eventStart", time2))
				.add(Restrictions.le("eventEnd", time))
				.list();
		
		return eventList;
	}

	


}
