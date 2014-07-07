package jp.co.fitec.lesson.DAO;

import org.hibernate.SessionFactory;

public abstract class BaseDAO {

	protected static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

}
