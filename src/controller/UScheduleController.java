package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import dao.AreaDao;
import dao.ScheduleDao;
import vo.AreaVo;
import vo.ScheduleVo;

/**
 * Servlet implementation class U_ScheduleController
 */
@WebServlet("/UScheduleController")
public class UScheduleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UScheduleController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag=request.getParameter("flag");
		System.out.println(flag);
		if(flag.equals("load"))
		{
			load(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag=request.getParameter("flag");
		if(flag.equals("search"))
		{
			search(request,response);
		}
	}
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 	
			System.out.println("hiii");
			AreaDao areaDao=new AreaDao(); 			
			List ls =areaDao.load();
			HttpSession r= request.getSession();
			r.setAttribute("area",ls);
		
			response.sendRedirect("user/choose_schedule.jsp");
			System.out.println("end of load");
		}

	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{ 	
		System.out.println("in search metho");
		int areaId=Integer.parseInt(request.getParameter("area"));
		/*Street_VO street_VO= new Street_VO();
		street_VO.setStreetId(streetId);
		*/
		
		AreaVo areaVo=new AreaVo();
		areaVo.setAreaId(areaId);
		ScheduleVo scheduleVo=new ScheduleVo();
		scheduleVo.setAreaRef(areaVo);
		
		System.out.println("middel of search metho");
		
		ScheduleDao scheduleDao=new ScheduleDao();
		List l= scheduleDao.search(scheduleVo);
		
		HttpSession r= request.getSession();
		r.setAttribute("area",l);
		
		List l2 = scheduleDao.search2();
		r.setAttribute("search",l2);
			
	
		response.sendRedirect("user/schedule_fetch.jsp");
		System.out.println("end search method");
		}
}
