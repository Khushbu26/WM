package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import java.util.ArrayList;

import vo.LoginVo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class LoginDao {

	public List authentication(LoginVo loginVo) {
		// TODO Auto-generated method stub
		List ls = new ArrayList();

		try {
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();

			session.save(loginVo);

			tr.commit();

			Query q = session.createQuery("from LoginVo where userName='" + loginVo.getUserName()
					+ "' and userPassword='" + loginVo.getUserPassword() + "' ");

			ls = q.list();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ls;
	}

}
