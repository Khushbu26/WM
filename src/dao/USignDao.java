package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.USignVo;

public class USignDao {
	public void insert(USignVo uSignVo) {
		// TODO Auto-generated method stub
		try {
			System.out.println("In Sing In Dao Insert");
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.save(uSignVo);
			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
