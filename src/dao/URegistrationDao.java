package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.URegistrationVo;

public class URegistrationDao {
	public void insert(URegistrationVo uRegistrationVo) {
		try {
			System.out.println("2222222");

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();
			System.out.println("211111111112");
			session.save(uRegistrationVo);

			System.out.println("333");
			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
}
