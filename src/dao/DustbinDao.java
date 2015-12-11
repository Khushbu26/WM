package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.DustbinVo;
public class DustbinDao {
	public void insert(DustbinVo dustVo){
		try
		{System.out.println("2222222");
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.save(dustVo);
			  System.out.println("333");
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
			  Query q= session.createQuery("from DustbinVo");
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
			  Query q= session.createQuery("from DustbinVo");
			  list=q.list();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
	}
	
	public List<?> edit(DustbinVo dustVo)
	{
		List<?> list= new ArrayList<>();
		try
		{
			
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
			  Query q= session.createQuery("from DustbinVo where id="+dustVo.getDustId()+"");
			  list=q.list();
			  
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
	}
	public void update(DustbinVo dustVo){
		try
		{
			System.out.println("2222222");
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.update(dustVo);
			  
			  System.out.println("333");
			  tr.commit();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	
	}
	
	public boolean delete(DustbinVo dustVo){
		try
		{
	
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.delete(dustVo);
			  
			  
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
