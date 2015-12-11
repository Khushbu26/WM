package dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.SubcategoryVo;

import org.hibernate.*;

import java.util.*;
public class SubcategoryDao {
	public void insert(SubcategoryVo subcategoryVo){
		try
		{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.save(subcategoryVo);
			  
			  tr.commit();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	
	}
	public List search()
	{
		List list= new ArrayList();
		try
		{
			
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
			  Query q= session.createQuery("from SubcategoryVo");
			  list=q.list();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
	}
	public List<?> edit(SubcategoryVo subcategoryVo)
	{
		List<?> list= new ArrayList<>();
		try
		{
			
			 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
			  Query q= session.createQuery("from SubcategoryVo where id="+subcategoryVo.getSubcategoryId()+"");
			  list=q.list();
			  return list;
			  
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
		return list;
		
	}
	public void update(SubcategoryVo subcategoryVo){
		try
		{
			System.out.println("2222222");
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.update(subcategoryVo);
			  
			  System.out.println("333");
			  tr.commit();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	
	}
	public void delete(SubcategoryVo subcategoryVo){
		try
		{
			  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
			  
			  Session session =sessionFactory.openSession();
		   
			  Transaction tr = session.beginTransaction();
			  
			  session.delete(subcategoryVo);
			  
			  tr.commit();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
		}
	}
	
		
		
		
	
	
}
