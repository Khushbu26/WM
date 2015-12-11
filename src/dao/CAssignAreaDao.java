package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.AreaVo;
import vo.CAssignAreaVo;

public class CAssignAreaDao {
	public void insert(CAssignAreaVo cAssignAreaVo) {
		try {
			System.out.println("2222222");
			
			SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

			Session session = sessionFactory.openSession();

			Transaction tr = session.beginTransaction();
			System.out.println("211111111112");
			session.save(cAssignAreaVo);

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
			Query q = session.createQuery("from CAssignAreaVo");
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
			  Query q= session.createQuery("from CAssignAreaVo");
			  list=q.list();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
	}

	public void update(CAssignAreaVo cAssignAreaVo) {
		// TODO Auto-generated method stub
		
		try
		{
			System.out.println("2222222");
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.update(cAssignAreaVo);
			  
			  System.out.println("333");
			  tr.commit();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	
	}

	public List<?> edit(CAssignAreaVo cAssignAreaVo) {
		// TODO Auto-generated method stub
		
		List<?> list= new ArrayList<>();
		try
		{
			
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
			  Query q= session.createQuery("from CAssignAreaVo where id="+cAssignAreaVo.getcAssignAreaId()+"");
			  list=q.list();
			  return list;
			  
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
	
	}
		
	}

