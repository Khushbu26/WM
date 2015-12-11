package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.CStaffRegVo;

public class CStaffRegDao {

	public void insert(CStaffRegVo cStaffRegVo) {
		try {
			System.out.println("2222222");
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();
			System.out.println("211111111112");
			session.save(cStaffRegVo);

			System.out.println("333");
			tr.commit();
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}
	
	public List<?> search() {
		List<?> list = new ArrayList<>();
		try {

			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();
			Query q = session.createQuery("from CStaffRegVo");
			list = q.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	public List<?> load() {
		// TODO Auto-generated method stub
		List<?> list= new ArrayList<>();
		try
		{
			
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
			  Query q= session.createQuery("from CStaffRegVo");
			  list=q.list();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
	}
	 
	/*
	 * public List<?> edit(C_Reg_VO c_Reg_VO) { List<?> list= new ArrayList<>();
	 * try {
	 * 
	 * SessionFactory sessionFactory = new
	 * Configuration().configure().buildSessionFactory();
	 * 
	 * Session session =sessionFactory.openSession(); Query q=
	 * session.createQuery("from C_Reg_VO as c where c.login ='"
	 * +c_Reg_VO.getLogin().getUserId()+"'"); list=q.list(); return list;
	 * 
	 * } catch(Exception exception) { exception.printStackTrace(); } return
	 * list;
	 * 
	 * }
	 */
	/*
	 * public void update(C_Reg_VO c_Reg_VO){ try {
	 * System.out.println("2222222"); SessionFactory sessionFactory = new
	 * Configuration().configure().buildSessionFactory();
	 * 
	 * Session session =sessionFactory.openSession();
	 * 
	 * Transaction tr = session.beginTransaction();
	 * 
	 * session.update(c_Reg_VO);
	 * 
	 * System.out.println("333"); tr.commit(); } catch(Exception exception) {
	 * exception.printStackTrace(); }
	 * 
	 * }
	 */
	/*
	 * public void delete(C_Reg_VO c_Reg_VO){ try { SessionFactory
	 * sessionFactory = new Configuration().configure().buildSessionFactory();
	 * 
	 * Session session =sessionFactory.openSession();
	 * 
	 * Transaction tr = session.beginTransaction();
	 * 
	 * session.delete(c_Reg_VO);
	 * 
	 * tr.commit(); } catch(Exception exception) { exception.printStackTrace();
	 * } }
	 */

}
