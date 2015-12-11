package dao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.RoadsideunitVo;

import org.hibernate.*;

import java.util.List;
import java.util.ArrayList;

public class RoadsideunitDao  {
	public void insert(RoadsideunitVo roadsideunitVo){
		try
		{System.out.println("2222222");
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.save(roadsideunitVo);
			  System.out.println("333");
			  tr.commit();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	
	}
	
	public List load()
	{
		List list= new ArrayList();
		try
		{
			
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
			  Query q= session.createQuery("from RoadsideunitVo");
			  list=q.list();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
	}
	
	public List search(int dustID)
	{
		List list= new ArrayList();
		try
		{
			
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
			  Query q= session.createQuery("from RoadsideunitVo where lm="+dustID);
			  list=q.list();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
	}
	public List search() {
		List list = new ArrayList();
		try {

			SessionFactory sessionFactory = new Configuration().configure()
					.buildSessionFactory();

			Session session = sessionFactory.openSession();
			Query q = session.createQuery("from RoadsideunitVo");
			list = q.list();
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}
	public List edit(RoadsideunitVo roadsideunitVo)
	{
		List list= new ArrayList();
		try
		{
			System.out.println("2222222");
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
			  Query q= session.createQuery("from RoadsideunitVo where id="+roadsideunitVo.getRoadId()+"");
			  list=q.list();
			  System.out.println("333");
			  return list;
			  
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
		
	}
	public void update(RoadsideunitVo roadsideunitVo){
		try
		{
			System.out.println("2222222");
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.update(roadsideunitVo);
			  
			  System.out.println("333");
			  tr.commit();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	
	}
	public boolean delete(RoadsideunitVo roadsideunitVo){
		try
		{
			System.out.println("start delete");
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.delete(roadsideunitVo);
			  System.out.println("End delete");
			  
			  tr.commit();
			  
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			String s[] =exception.getCause()!=null?exception.getCause().toString().split(":"): null;
			if(s[0]!=null && s[0].equals("java.sql.BatchUpdateException"))
			{
				return false;
				
			}
			
		}
		return true;
	
	}
	
	
}
