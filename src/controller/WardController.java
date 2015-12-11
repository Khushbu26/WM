package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.WardDao;
import dao.ZoneDao;
import vo.WardVo;
import vo.ZoneVo;

import java.util.List;

/**
 * Servlet implementation class WardController
 */
@WebServlet("/WardController")
public class WardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WardController() {
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
		doGet(request, response);
		String flag=request.getParameter("flag");
		System.out.println(flag);
		if(flag.equals("insert"))
		{
			insert(request,response);
		}
		if(flag.equals("update"))
		{ 
			update(request,response);
		}
	}
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String wardName =request.getParameter("ward");
		String wardDes =request.getParameter("ward_des");
		System.out.println(wardDes + wardName);
		int i = Integer.parseInt(request.getParameter("zoneId"));
		ZoneVo zoneVo = new ZoneVo();
		zoneVo.setZoneId(i);
		
		WardVo wardVo=new WardVo();
		wardVo.setWardName(wardName);
		wardVo.setWardDes(wardDes);
		wardVo.setZoneref(zoneVo);
		
		WardDao wardDao=new WardDao();
		wardDao.insert(wardVo);
		response.sendRedirect("admin/add_ward.jsp");
		
		
		
}
	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("in load method");
			ZoneDao zoneDao= new ZoneDao();
			List<?> ls =zoneDao.load();
			HttpSession r= request.getSession();
			r.setAttribute("zone", ls);
			response.sendRedirect("admin/add_ward.jsp");				
			
		}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		WardDao wardDao=new WardDao();
			
		wardDao.search();
		List<?> list =wardDao.search();
		HttpSession r= request.getSession();
		r.setAttribute("ward", list);
		response.sendRedirect("admin/search_ward.jsp");
		
		
		
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{	
		
		int wardId =Integer.parseInt(request.getParameter("id"));
		WardVo wardVo=new WardVo();
		wardVo.setWardId(wardId);
		
		WardDao wardDao=new WardDao();
		ZoneDao zoneDao= new ZoneDao();
		List<?> ls =zoneDao.load();
		System.out.println("in edit method");
		List<?> list =wardDao.edit(wardVo);
		System.out.print("edit size is"+list.size());
		HttpSession r= request.getSession();
		r.setAttribute("editward", list);
		r.setAttribute("zone", ls);
		response.sendRedirect("admin/editward.jsp");
		System.out.println("end of edit method");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("in update method");
		String wardName =request.getParameter("ward");
		String wardDes =request.getParameter("ward_des");
		int ed=Integer.parseInt(request.getParameter("id"));
		System.out.println("11111111111");
		int pd=Integer.parseInt(request.getParameter("zoneId"));
		System.out.println("Data:"+wardDes +""+ wardName+""+ed+pd);
		System.out.println("11111111111");
		

		ZoneVo zoneVo=new ZoneVo();
		WardVo wardVo=new WardVo();
		wardVo.setWardName(wardName);
		wardVo.setWardDes(wardDes);
		wardVo.setWardId(ed);
		zoneVo.setZoneId(pd);
		
		
		wardVo.setZoneref(zoneVo);
		
		
		
		WardDao wardDao=new WardDao();
		wardDao.update(wardVo);
		response.sendRedirect("admin/add_ward.jsp");
		System.out.println("end of update method");
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int wardId =Integer.parseInt(request.getParameter("id"));
		
		System.out.println(wardId);
		WardVo wardVo=new WardVo();
		wardVo.setWardId(wardId);
		
		WardDao wardDao=new WardDao();
		//category_DAO.delete(category_VO);
		
		HttpSession r= request.getSession();
		
		
		if(!wardDao.delete(wardVo))
		{
			r.setAttribute("ErrorMsg","Plz Delete Child Class First");
			
		}
		else{
			
			r.removeAttribute("ErrorMsg");
		}
		
		search(request, response);
		
	}


}
