package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.UEmailVo;

public class UEmailDao {
	public void insert(UEmailVo uEmailVo) {
		// TODO Auto-generated method stub
		try {
			System.out.println("In Email Dao Insert");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(uEmailVo);

			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
