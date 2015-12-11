package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.WasteInfoVo;

public class WasteInfoDao {
	public void insert(WasteInfoVo wasteInfoVo) {
		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(wasteInfoVo);

			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
