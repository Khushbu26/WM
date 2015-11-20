package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import vo.WardVo;
import vo.ZoneVo;

public class WardDao {
	public void insert(WardVo wardVo){
		try
		{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.save(wardVo);
			  
			  tr.commit();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
		public List<?> load()
		{
			List<?> list= new ArrayList<>();
			try
			{
				
				 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
				  Query q= session.createQuery("from WardVo");
				  list=q.list();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return list;
		}
		public List<?> search()
		{
			List<?> list= new ArrayList<>();
			try
			{
				
				 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
				  Query q= session.createQuery("from WardVo");
				  list=q.list();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return list;
		}

		public List<?> edit(WardVo wardVo)
		{
			List<?> list= new ArrayList<>();
			try
			{
				
				 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
				  Query q= session.createQuery("from WardVo where id="+wardVo.getWardId()+"");
				  list=q.list();
				  return list;
				  
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return list;
			
		}
		public void update(WardVo wardVo){
			try
			{
				System.out.println("2222222");
				  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
			   
				  Transaction tr = session.beginTransaction();
				  
				  session.update(wardVo);
				  
				  System.out.println("333");
				  tr.commit();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		
		}
		public boolean delete(WardVo wardVo){
			try
			{
		
				  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
			   
				  Transaction tr = session.beginTransaction();
				  
				  session.delete(wardVo);
				  
				  
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
		public List<?> loadWard(WardVo wardVo) {
			// TODO Auto-generated method stub
		 		
				List<?> l=new ArrayList<>();
				 SessionFactory sf= new Configuration().configure().buildSessionFactory();
				Session ss=sf.openSession();
				Transaction t=ss.beginTransaction();
				Query q=ss.createQuery("from WardVo where zoneId = "+wardVo.getZoneref().getZoneId());
				l=q.list();
				return l;
			
			
		}

		





}
