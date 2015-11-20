package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ZoneDao;
import vo.ZoneVo;

/**
 * Servlet implementation class Zone_Controller
 */
@WebServlet("/ZoneController")
public class ZoneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZoneController() {
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

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException,ServletException {
		// TODO Auto-generated method stub
		
		String zoneName=request.getParameter("zone");
		String zoneDes=request.getParameter("zone_des");
		System.out.println(zoneName+zoneDes);
		ZoneVo zoneVo=new ZoneVo();
		
		zoneVo.setZoneName(zoneName);
		zoneVo.setZoneDes(zoneDes);
		System.out.println("after vo");
		ZoneDao zoneDao=new ZoneDao();
		zoneDao.insert(zoneVo);
		response.sendRedirect("admin/add_zone.jsp");
		System.out.println("after dao");
	}


protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
	System.out.println("in search");
	ZoneDao zoneDao=new ZoneDao();
	zoneDao.search();
	List list =zoneDao.search();
	HttpSession r= request.getSession();
	r.setAttribute("zone", list);
	response.sendRedirect("admin/search_zone.jsp");
	
	
	
}
protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
	
	int zoneId =Integer.parseInt(request.getParameter("id"));
	ZoneVo zoneVo=new ZoneVo();
	zoneVo.setZoneId(zoneId);
	
	ZoneDao zoneDao=new ZoneDao();
			
	
	List<?> list =zoneDao.edit(zoneVo);
	HttpSession r= request.getSession();
	r.setAttribute("editzone", list);
	response.sendRedirect("admin/editzone.jsp");
}
protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
System.out.println("11111111111");

String zoneName =request.getParameter("zone");
String zoneDes =request.getParameter("zone_des");
int ed=Integer.parseInt(request.getParameter("id"));
System.out.println("Data: "+zoneDes +""+ zoneName+""+ed);

ZoneVo zoneVo=new ZoneVo();
zoneVo.setZoneName(zoneName);
zoneVo.setZoneDes(zoneDes);
zoneVo.setZoneId(ed);

ZoneDao zoneDao=new ZoneDao();
zoneDao.update(zoneVo);
response.sendRedirect("admin/add_zone.jsp");







}
protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{
int zoneId =Integer.parseInt(request.getParameter("id"));

System.out.println(zoneId);
ZoneVo zoneVo=new ZoneVo();
zoneVo.setZoneId(zoneId);

ZoneDao zoneDao=new ZoneDao();
//category_DAO.delete(category_VO);

HttpSession r= request.getSession();


if(!zoneDao.delete(zoneVo))
{
	r.setAttribute("ErrorMsg","Plz Delete Child Class First");
	
}
else{
	
	r.removeAttribute("ErrorMsg");
}

search(request, response);

}






}
