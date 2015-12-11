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
import dao.CAssignAreaDao;
import dao.CStaffRegDao;
import dao.WardDao;
import dao.ZoneDao;
import vo.AreaVo;
import vo.CAssignAreaVo;
import vo.CStaffRegVo;
import vo.WardVo;
import vo.ZoneVo;

/**
 * Servlet implementation class CAssignAreaController
 */
@WebServlet("/CAssignAreaController")
public class CAssignAreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CAssignAreaController() {
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
		if (flag.equals("search")) {
			search(request, response);
		}
		if (flag.equals("edit")) {
			edit(request, response);
		}
	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int cAssignAreaId=Integer.parseInt(request.getParameter("id"));
		CAssignAreaVo cAssignAreaVo=new CAssignAreaVo();
		cAssignAreaVo.setcAssignAreaId(cAssignAreaId);		
		
		HttpSession r= request.getSession();
		
		CStaffRegDao cStaffRegDao=new CStaffRegDao();
		List<?> listStaff=cStaffRegDao.load();		
		r.setAttribute("cStaff", listStaff);
		
		AreaDao areaDao=new AreaDao();
		List<?> listArea=areaDao.load();
		r.setAttribute("area", listArea);
		
		CAssignAreaDao cAssignAreaDao=new CAssignAreaDao();
		List<?> listAssignArea=cAssignAreaDao.edit(cAssignAreaVo);
		r.setAttribute("editAssignArea",listAssignArea );
 		System.out.println("after edit");
		response.sendRedirect("admin/c_edit_assignarea.jsp");
		
	}

	protected void search(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		CAssignAreaDao cAssignAreaDao= new CAssignAreaDao();
		CStaffRegDao cStaffRegDao=new CStaffRegDao();
		AreaDao areaDao=new AreaDao();
		cStaffRegDao.search();
		cAssignAreaDao.search();
		areaDao.search();
		List<?> list =cAssignAreaDao.search();
		List<?> ls=cStaffRegDao.search();
		List<?> la=areaDao.search();
		HttpSession r= request.getSession();
		r.setAttribute("assignstaff", list);
		r.setAttribute("cStaff", ls);
		r.setAttribute("area", la);
		try {
			response.sendRedirect("admin/c_search_assignarea.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		CStaffRegDao cStaffRegDao = new CStaffRegDao();

		List<?> list = cStaffRegDao.load();
		HttpSession r = request.getSession();

		r.setAttribute("cStaff", list);
		
		AreaDao k = new AreaDao();
		List<?> ls2 = k.load();
		HttpSession r1 = request.getSession();
		r1.setAttribute("areaName", ls2);
		
		response.sendRedirect("admin/c_assign_area.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String flag=request.getParameter("flag");
		System.out.println(flag);
		if(flag.equals("insert"))
		{
			insert(request,response);
		}if(flag.equals("update"))
		{
			update(request,response);
		}
		
		
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		System.out.println("^_^");
		
		int cAssignAreaId=Integer.parseInt(request.getParameter("id"));
		int cStaffId=Integer.parseInt(request.getParameter("cStaffId"));
		int areaId=Integer.parseInt(request.getParameter("areaId"));
		
		System.out.println("Data:"+cAssignAreaId +""+ cStaffId+""+areaId);
		System.out.println("11111111111");
		
		CAssignAreaVo cAssignAreaVo=new CAssignAreaVo();
		AreaVo areaVo=new AreaVo();
		CStaffRegVo cStaffRegVo=new CStaffRegVo();
		System.out.println("222222222");
		
		cAssignAreaVo.setcAssignAreaId(cAssignAreaId);
		cStaffRegVo.setStaffId(cStaffId);
		areaVo.setAreaId(areaId);
		System.out.println("3333333333");
		
		cAssignAreaVo.setAreaRef(areaVo);
		cAssignAreaVo.setcStaffRef(cStaffRegVo);
		System.out.println("444444");
		
		CAssignAreaDao cAssignAreaDao=new CAssignAreaDao();
		cAssignAreaDao.update(cAssignAreaVo);
		
		
		search(request,response);
		
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int i =Integer.parseInt(request.getParameter("cStaff"));
		int k = Integer.parseInt(request.getParameter("area"));   
		CStaffRegVo cStaffRegVo = new CStaffRegVo();
		cStaffRegVo.setStaffId(i);
		AreaVo areaVo = new AreaVo();
		areaVo.setAreaId(k);
		CAssignAreaVo cAssignAreaVo = new CAssignAreaVo();
		cAssignAreaVo.setcStaffRef(cStaffRegVo);
		cAssignAreaVo.setAreaRef(areaVo );
		
		
		CAssignAreaDao cAssignAreaDao = new CAssignAreaDao();
		cAssignAreaDao.insert(cAssignAreaVo);
		
		

		response.sendRedirect("admin/c_assign_area.jsp");
		
	}

}
