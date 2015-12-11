package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.UComplaintVo;

public class UComplaintDao {

	public void insert(UComplaintVo uComplaintVo) {
		// TODO Auto-generated method stub
		try {
			System.out.println("In Complaint Dao Insert");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(uComplaintVo);
			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}
	public List load() {
		List list = new ArrayList();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Query q = session.createQuery("from UComplaintVo");
			list = q.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

}
