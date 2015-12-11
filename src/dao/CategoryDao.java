package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.CategoryVo;


public class CategoryDao {

	public static void insert(CategoryVo categoryVo) {
		// TODO Auto-generated method stub
		try{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		  Session session =sessionFactory.openSession();
		   
		  Transaction tr = session.beginTransaction();
		  
		  session.save(categoryVo);
		  
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
		  Query q= session.createQuery("from CategoryVo");
		  list=q.list();
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	return list;
}


public List<?> load(){

	List<?> list= new ArrayList<>();
	try
	{
			System.out.println("in category dao Load method");
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  
		  Session session =sessionFactory.openSession();
		  Query q= session.createQuery("from CategoryVo");
		  list=q.list();
		  
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	return list;
}
public List edit(CategoryVo categoryVo)
{
	List list= new ArrayList();
	try
	{
		
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  
		  Session session =sessionFactory.openSession();
		  Query q= session.createQuery("from CategoryVo where id="+categoryVo.getCategoryId()+"");
		  list=q.list();
		  
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	return list;
}
public void update(CategoryVo categoryVo){
	try
	{
		System.out.println("2222222");
		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  
		  Session session =sessionFactory.openSession();
	   
		  Transaction tr = session.beginTransaction();
		  
		  session.update(categoryVo);
		  
		  System.out.println("333");
		  tr.commit();
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}

}
public boolean delete(CategoryVo categoryVo){
	try
	{

		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  
		  Session session =sessionFactory.openSession();
	   
		  Transaction tr = session.beginTransaction();
		  
		  session.delete(categoryVo);
		  
		  
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

