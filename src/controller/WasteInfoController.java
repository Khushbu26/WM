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
import dao.WasteInfoDao;
import vo.AreaVo;
import vo.ScheduleVo;
import vo.WasteInfoVo;

/**
 * Servlet implementation class WasteInfoController
 */
@WebServlet("/WasteInfoController")
public class WasteInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WasteInfoController() {
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
		System.out.println("pratik");

		System.out.println(flag);
		if(flag.equals("load"))
		{
			load(request,response);
		}
	}

	
		protected void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
			// TODO Auto-generated method stub
			System.out.println("in new load");
			
			AreaDao areaDao = new AreaDao();
			List<?> ls = areaDao.load();
			HttpSession r= request.getSession();
			r.setAttribute("area", ls);
			response.sendRedirect("user/post_waste_info.jsp");
			System.out.println("after load");
			
			
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		System.out.println("pratik");
		String flag=request.getParameter("flag");
		System.out.println("flag");
		System.out.println("Pratik");
		if(flag.equals("insert"))
		{
			insert(request,response);
		}
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("in insert");
		int i=Integer.parseInt(request.getParameter("area"));
		String waste_info=request.getParameter("waste_info");
		String des=request.getParameter("des");
		
		System.out.println(i+waste_info+des);	
		
		AreaVo areaVo = new AreaVo();
		areaVo.setAreaId(i);
		
		WasteInfoVo wasteInfoVo = new WasteInfoVo();
		wasteInfoVo.setWaste_info(waste_info);
		wasteInfoVo.setDes(des);
		wasteInfoVo.setAreaRef(areaVo);
		
		WasteInfoDao wasteInfoDao = new WasteInfoDao();
		wasteInfoDao.insert(wasteInfoVo);
		
		response.sendRedirect("user/post_waste_info.jsp");		
		
	}

}
