package controller;

import java.io.IOException;

import javax.naming.directory.SearchControls;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import dao.AreaDao;
import dao.WardDao;
import dao.ZoneDao;
import vo.AreaVo;
import vo.WardVo;
import vo.ZoneVo;

/**
 * Servlet implementation class AreaController
 */
@WebServlet("/AreaController")
public class AreaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AreaController() {
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
		if(flag.equals("loadWard"))
		{ 
			loadWard(request,response);
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag=request.getParameter("flag");
		System.out.println("flag");
		if(flag.equals("insert"))
		{
			insert(request,response);
		}
		if(flag.equals("update"))
		{ 
			update(request,response);
		}
	}
	
	protected void insert(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		System.out.println("in insert");	

		String areaName=request.getParameter("area");
		String areaDes=request.getParameter("area_des");
		System.out.println(areaName+areaDes);
		int i=Integer.parseInt(request.getParameter("zone"));
		int j=Integer.parseInt(request.getParameter("wardId"));
		
		System.out.println(i+j);	
		
		ZoneVo zoneVo=new ZoneVo();
		zoneVo.setZoneId(i);
		
		WardVo wardVo=new WardVo();
		wardVo.setWardId(j);
		System.out.println("hiii");	

		AreaVo areaVo=new AreaVo();
		areaVo.setAreaName(areaName);
		areaVo.setAreaDes(areaDes);
		areaVo.setZoneref(zoneVo);
		areaVo.setWardref(wardVo);
		
		AreaDao areaDao=new AreaDao();
		areaDao.insert(areaVo);
		response.sendRedirect("admin/add_area.jsp");
		//search(request,response);
		
		
	}
	
	
	protected void load(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		// TODO Auto-generated method stub
		WardDao wardDao= new WardDao();
		List<?> ls =wardDao.load();
		ZoneDao zoneDao= new ZoneDao();
		List<?> ls1 =zoneDao.load();
		HttpSession r= request.getSession();
		r.setAttribute("ward", ls);
		r.setAttribute("zone", ls1);
		response.sendRedirect("admin/add_area.jsp");
	}
	private void loadWard(HttpServletRequest request,
			HttpServletResponse response) throws IOException 
	{
		ZoneVo zoneVo=new ZoneVo();
		zoneVo.setZoneId(Integer.parseInt(request.getParameter("zoneId")));
	
		System.out.println("id is jj"+request.getParameter("zoneId"));
		WardVo wardVo=new WardVo();
		wardVo.setZoneref(zoneVo);
	
	
		WardDao wardDao= new WardDao();	
		List<?> l=wardDao.loadWard(wardVo);
		HttpSession hs=request.getSession();
		hs.setAttribute("loadWard", l);
		System.out.println("in ward load method");
		response.sendRedirect("admin/loadWard.jsp");
	}

protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		AreaDao areaDao=new AreaDao();			
		areaDao.search();
		List list =areaDao.search();
		HttpSession r= request.getSession();
		r.setAttribute("area", list);
		response.sendRedirect("admin/search_area.jsp");	
	}
protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{	
	System.out.println("in edit");
	int areaId =Integer.parseInt(request.getParameter("id"));
	AreaVo areaVo=new AreaVo();
	areaVo.setAreaId(areaId);
	
	HttpSession r= request.getSession();
	
	ZoneDao zoneDao= new ZoneDao();
	List ls1 =zoneDao.load();
	r.setAttribute("zone", ls1);
	
	
	WardDao wardDao= new WardDao();
	List ls2=wardDao.load();
	r.setAttribute("ward", ls2);
	
	System.out.println("in edit");

	AreaDao areaDao=new AreaDao();
	List list =areaDao.edit(areaVo);
	r.setAttribute("editarea", list);
	System.out.println("end of edit");
	response.sendRedirect("admin/edit_area.jsp");
}
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	System.out.println("^_^");
	String areaName =request.getParameter("area");
	String areaDes =request.getParameter("area_des");
	int ld=Integer.parseInt(request.getParameter("id"));
	int pd=Integer.parseInt(request.getParameter("zoneId"));
	int ed=Integer.parseInt(request.getParameter("wardId"));
	
	System.out.println("Data:"+areaDes +""+ areaName+""+ed+pd+ld);
	//System.out.println("11111111111");
	
	ZoneVo zoneVo=new ZoneVo();
	WardVo wardVo=new WardVo();
	AreaVo areaVo=new AreaVo();
	
	areaVo.setAreaName(areaName);
	areaVo.setAreaDes(areaDes);
	areaVo.setAreaId(ld);
	zoneVo.setZoneId(pd);
	wardVo.setWardId(ed);	
	areaVo.setZoneref(zoneVo);
	areaVo.setWardref(wardVo);		
	
	AreaDao areaDao=new AreaDao();
	areaDao.update(areaVo);
	search(request,response);
	
}

protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
	int areaId =Integer.parseInt(request.getParameter("id"));
	
	System.out.println(areaId);
	AreaVo areaVo=new AreaVo();
	areaVo.setAreaId(areaId);
	
	AreaDao areaDao=new AreaDao();
	//category_DAO.delete(category_VO);
	
	HttpSession r= request.getSession();
	
	
	if(!areaDao.delete(areaVo))
	{
		r.setAttribute("ErrorMsg","Plz Delete Child Class First");
		
	}
	else{
		
		r.removeAttribute("ErrorMsg");
	}
	
	search(request, response);
	
}


}
