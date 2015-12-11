package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AreaDao;
import dao.ScheduleDao;
import dao.WardDao;
import dao.ZoneDao;
import vo.AreaVo;
import vo.ScheduleVo;
import vo.WardVo;

/**
 * Servlet implementation class ScheduleController
 */
@WebServlet("/ScheduleController")
public class ScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String flag=request.getParameter("flag");
		System.out.println("pratik");

		System.out.println(flag);
		if(flag.equals("load"))
		{
			load(request,response);
		}
		if(flag.equals("search"))
		{
			search(request,response);
		}
		if(flag.equals("edit"))
		{
			edit(request,response);
		}
		if(flag.equals("delete"))
		{
			delete(request,response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("pratik");
		String flag=request.getParameter("flag");
		System.out.println("flag");
		System.out.println("Pratik");
		if(flag.equals("insert"))
		{
			insert(request,response);
		}
		if(flag.equals("update"))
		{
			update(request,response);
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		// TODO Auto-generated method stub
		System.out.println("in insert");
		int i=Integer.parseInt(request.getParameter("area"));
		String timePick=request.getParameter("timePick");
		System.out.println(i+timePick);	
		
		AreaVo areaVo = new AreaVo();
		areaVo.setAreaId(i);
		ScheduleVo scheduleVo = new ScheduleVo();
		scheduleVo.setTimePick(timePick);
		scheduleVo.setAreaRef(areaVo);
		
		
		ScheduleDao scheduleDao = new ScheduleDao();
		scheduleDao.insert(scheduleVo);
		response.sendRedirect("admin/generate_schedule.jsp");		
	}
	
	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		ScheduleDao scheduleDao = new ScheduleDao();
		scheduleDao.search();
		List list =scheduleDao.search();
		HttpSession r= request.getSession();
		r.setAttribute("schedule", list);
		response.sendRedirect("admin/search_schedule.jsp");
		
		
	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("in new load");
		
		AreaDao areaDao = new AreaDao();
		List<?> ls = areaDao.load();
		HttpSession r= request.getSession();
		r.setAttribute("area", ls);
		response.sendRedirect("admin/generate_schedule.jsp");
		System.out.println("after load");
		
		
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	System.out.println("in edit");
	    System.out.println("in edit method");
		int scheduleId =Integer.parseInt(request.getParameter("id"));
		ScheduleVo scheduleVo = new ScheduleVo();
		scheduleVo.setScheduleId(scheduleId);
		HttpSession r= request.getSession();
		
		
		AreaDao areaDao = new AreaDao();		
		List<?> ls =areaDao.load();
		r.setAttribute("area", ls);
		
		
		ScheduleDao scheduleDao = new ScheduleDao();		
		List<?> list =scheduleDao.edit(scheduleVo);
		r.setAttribute("editschedule", list);
		System.out.print("edit size is"+list.size());
		
		
		
		response.sendRedirect("admin/edit_schedule.jsp");
		System.out.println("end of edit method");
	}
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("^_^");
	
		String timePick=request.getParameter("timePick");
		int ld=Integer.parseInt(request.getParameter("id"));
		int pd=Integer.parseInt(request.getParameter("area"));
	
		System.out.println("Data:"+ timePick+""+ld+pd);
			
		
		ScheduleVo scheduleVo = new ScheduleVo();
		AreaVo areaVo=new AreaVo();
		scheduleVo.setTimePick(timePick);
		scheduleVo.setScheduleId(ld);
		areaVo.setAreaId(pd);
		scheduleVo.setAreaRef(areaVo);
		
		ScheduleDao scheduleDao = new ScheduleDao();
		scheduleDao.update(scheduleVo);		
		
		search(request,response);
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		int scheduleId =Integer.parseInt(request.getParameter("id"));
		System.out.println(scheduleId);
		ScheduleVo scheduleVo = new ScheduleVo();
		scheduleVo.setScheduleId(scheduleId);
		
		ScheduleDao scheduleDao = new ScheduleDao();
		scheduleDao.delete(scheduleVo);			
	
		search(request, response);

	}
}
