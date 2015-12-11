package dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import vo.EventVo;

public class EventDao {
	public void insert(EventVo eventVo) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(eventVo);

			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	public List<?> load() {
		List<?> list = new ArrayList<>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();
			System.out.println("list load method");
			Query q = session.createQuery("from EventVo");
			list = q.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	public List<?> search() {
		List<?> list = new ArrayList<>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();
			Query q = session.createQuery("from EventVo");
			list = q.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	public List<?> edit(EventVo eventVo) {
		List<?> list = new ArrayList<>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			System.out.println("edit method");
			Session session = sessionFactory.openSession();
			Query q = session.createQuery("from EventVo where id=" + eventVo.getEventId() + "");
			list = q.list();
			return list;

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;

	}

	public void update(EventVo eventVo) {
		try {
			System.out.println("update method from dao start");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.update(eventVo);

			System.out.println("update from dao end");
			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public boolean delete(EventVo eventVo) {
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.delete(eventVo);

			tr.commit();

		} catch (Exception exception) {
			exception.printStackTrace();
			String s[] = exception.getCause() != null ? exception.getCause().toString().split(":") : null;
			if (s[0] != null && s[0].equals("java.sql.BatchUpdateException")) {
				return false;

			}

		}
		return true;

	}
}
