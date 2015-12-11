package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import vo.ScheduleVo;
import vo.UScheduleVo;


public class ScheduleDao {
	
		public void insert(ScheduleVo scheduleVo){
			try
			{
				  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
			   
				  Transaction tr = session.beginTransaction();
				  
				  session.save(scheduleVo);
				  
				  tr.commit();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
		public List<?> search()
		{
			List<?> list= new ArrayList<>();
			try
			{
				
				 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
				  Query q= session.createQuery("from ScheduleVo");
				  list=q.list();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return list;
		}
		public List<?> edit(ScheduleVo scheduleVo) {
			// TODO Auto-generated method stub
			List<?> list= new ArrayList<>();
			try
			{
				
				 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
				  Query q= session.createQuery("from ScheduleVo");
				  list=q.list();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return list;
			
		}
		
		public void update(ScheduleVo scheduleVo){
			try
			{
				System.out.println("2222222");
				  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
			   
				  Transaction tr = session.beginTransaction();
				  
				  session.update(scheduleVo);
				  
				  System.out.println("333");
				  tr.commit();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			
		
		}
		public void delete(ScheduleVo scheduleVo){
			try
			{
				  SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
			   
				  Transaction tr = session.beginTransaction();
				  
				  session.delete(scheduleVo);
				  
				  tr.commit();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
		}
		public List search(ScheduleVo scheduleVo) {
			// TODO Auto-generated method stub
			List<?> list= new ArrayList<>();
			try
			{
				
				 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
				  
				  Session session =sessionFactory.openSession();
				  Query q= session.createQuery("from ScheduleVo as a where a.areaRef='"+scheduleVo.getAreaRef().getAreaId()+"'");
				  list=q.list();
			}
			catch(Exception exception)
			{
				exception.printStackTrace();
			}
			return list;
			
			
			
		}
		
		
		
			
			public List search2() {
				// TODO Auto-generated method stub
				List<?> list= new ArrayList<>();
				try
				{
					
					 SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
					  
					  Session session =sessionFactory.openSession();
					  Query q= session.createQuery("from AreaVo");
					  list=q.list();
				}
				catch(Exception exception)
				{
					exception.printStackTrace();
				}
				return list;
			
			
			
			}
}
