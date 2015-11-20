package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import vo.ZoneVo;

public class ZoneDao {

	public void insert(ZoneVo zoneVo) {
		// TODO Auto-generated method stub
		try{
		SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
		  Session session =sessionFactory.openSession();
		   
		  Transaction tr = session.beginTransaction();
		  
		  session.save(zoneVo);
		  
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
		  Query q= session.createQuery("from ZoneVo");
		  list=q.list();
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	return list;
}


public List load()
{
	List list= new ArrayList();
	try
	{
		
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  
		  Session session =sessionFactory.openSession();
		  Query q= session.createQuery("from ZoneVo");
		  list=q.list();
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	return list;
}
public List edit(ZoneVo zoneVo)
{
	List list= new ArrayList();
	try
	{
		
		 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  
		  Session session =sessionFactory.openSession();
		  Query q= session.createQuery("from ZoneVo where id="+zoneVo.getZoneId()+"");
		  list=q.list();
		  
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}
	return list;
}
public void update(ZoneVo zoneVo){
	try
	{
		System.out.println("2222222");
		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  
		  Session session =sessionFactory.openSession();
	   
		  Transaction tr = session.beginTransaction();
		  
		  session.update(zoneVo);
		  
		  System.out.println("333");
		  tr.commit();
	}
	catch(Exception exception)
	{
		exception.printStackTrace();
	}

}
public boolean delete(ZoneVo zoneVo){
	try
	{

		  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		  
		  Session session =sessionFactory.openSession();
	   
		  Transaction tr = session.beginTransaction();
		  
		  session.delete(zoneVo);
		  
		  
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

