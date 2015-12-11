package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.AreaVo;

public class AreaDao {
	public void insert(AreaVo areaVo) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(areaVo);
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
			Query q = session.createQuery("from AreaVo");
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
			Query q = session.createQuery("from AreaVo");
			list = q.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	public List<?> edit(AreaVo areaVo) {
		List<?> list = new ArrayList<>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();
			Query q = session.createQuery("from AreaVo where id=" + areaVo.getAreaId() + "");
			list = q.list();
			return list;

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;

	}

	public void update(AreaVo areaVo) {
		try {
			System.out.println("2222222");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.update(areaVo);

			System.out.println("333");
			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	public boolean delete(AreaVo areaVo) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.delete(areaVo);

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
	public List<?> loadArea(AreaVo areaVo) {
		// TODO Auto-generated method stub
		List l1=new ArrayList();
		 SessionFactory sf= new Configuration().configure().buildSessionFactory();
		Session ss=sf.openSession();
		Transaction t=ss.beginTransaction();
		System.out.println("Before Qqqqqqqqqqqqq");
		Query q=ss.createQuery("from AreaVo where wardref = "+areaVo.getWardref().getWardId());
		
		l1=q.list();
		
		return l1;
	
	}
	public List search(AreaVo areaVo) {
		// TODO Auto-generated method stub
		List<?> list = new ArrayList<>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();
			Query q = session.createQuery("from AreaVo a where areaId='" + areaVo.getAreaId() + "'");
			list = q.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;

	}
}
