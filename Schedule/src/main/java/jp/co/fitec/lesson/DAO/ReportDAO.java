package jp.co.fitec.lesson.DAO;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import jp.co.fitec.lesson.Servlet.Report;
import jp.co.fitec.lesson.entity.Event;


public class ReportDAO extends BaseDAO {


	public List<Report> findAll() {
		
			return  findBy(null, null);

	}

	public List<Report>  findBy(String time, String categoryId) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Event.class);
		
		if(StringUtils.isNotBlank(time)) {
			criteria.add(Restrictions.like("isbn", time, MatchMode.ANYWHERE));
		}
		
		
		if(StringUtils.isNotBlank(categoryId)) {
			criteria.add(Restrictions.eq("publisher.code", categoryId));
		}
		
		return criteria.list();
	}
	


}
