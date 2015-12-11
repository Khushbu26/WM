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
import dao.DustbinDao;
import dao.RoadsideunitDao;
import dao.WardDao;
import dao.ZoneDao;
import vo.AreaVo;
import vo.DustbinVo;
import vo.RoadsideunitVo;
import vo.WardVo;
import vo.ZoneVo;

/**
 * Servlet implementation class RoadsideunitController
 */
@WebServlet("/RoadsideunitController")
public class RoadsideunitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoadsideunitController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if (flag.equals("load")) {
			load(request, response);
		}
		if (flag.equals("search")) {
			search(request, response);
		}
		if (flag.equals("edit")) {
			edit(request, response);
		}
		if (flag.equals("delete")) {
			delete(request, response);
		}
		if(flag.equals("loadWard"))
		{ 
			loadWard(request,response);
		}
		if(flag.equals("loadArea"))
		{ 
			loadArea(request,response);
		}
	}

	private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		RoadsideunitDao roadsideunitDao = new RoadsideunitDao();
		roadsideunitDao.search();
		List list = roadsideunitDao.search();
		HttpSession r = request.getSession();
		r.setAttribute("road", list);
		response.sendRedirect("admin/search_road_side_unit.jsp");
		System.out.println("11111111111");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if (flag.equals("insert")) {
			insert(request, response);
		}
		if (flag.equals("update")) {
			update(request, response);
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		double longi = Double.parseDouble(request.getParameter("longi"));
		double lati = Double.parseDouble(request.getParameter("lati"));

		System.out.println(longi + lati);

		RoadsideunitVo roadsideunitVo = new RoadsideunitVo();
		roadsideunitVo.setLongi(longi);
		roadsideunitVo.setLati(lati);

		int m = Integer.parseInt(request.getParameter("dustId"));
		int j = Integer.parseInt(request.getParameter("zoneId"));
		int i = Integer.parseInt(request.getParameter("wardId"));
		int k = Integer.parseInt(request.getParameter("areaId"));

		WardVo wardVo = new WardVo();
		wardVo.setWardId(i);
		ZoneVo zoneVo = new ZoneVo();
		zoneVo.setZoneId(j);
		AreaVo areaVo = new AreaVo();
		areaVo.setAreaId(k);
		DustbinVo dustVo = new DustbinVo();
		dustVo.setDustId(m);
		roadsideunitVo.setZoneRef(zoneVo);
		roadsideunitVo.setWardRef(wardVo);
		roadsideunitVo.setAreaRef(areaVo);
		roadsideunitVo.setDustbinRef(dustVo);

		System.out.println("11111111111");

		RoadsideunitDao roadsideunitDao = new RoadsideunitDao();
		roadsideunitDao.insert(roadsideunitVo);
		response.sendRedirect("admin/add_road_side_unit.jsp");
		// search(request,response);

	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WardDao i = new WardDao();
		List<?> ls = i.load();
		ZoneDao j = new ZoneDao();
		List<?> ls1 = j.load();
		AreaDao k = new AreaDao();
		List<?> ls2 = k.load();
		DustbinDao m = new DustbinDao();
		List<?> ls4 = m.load();

		HttpSession r = request.getSession();
		r.setAttribute("ward", ls);
		r.setAttribute("zone", ls1);
		r.setAttribute("area", ls2);
		r.setAttribute("dust", ls4);

		response.sendRedirect("admin/add_road_side_unit.jsp");

	}
	private void loadWard(HttpServletRequest request,HttpServletResponse response) throws IOException 
	{
		System.out.println("In Load Ward8");
		ZoneVo zoneVo = new ZoneVo();
		zoneVo.setZoneId(Integer.parseInt(request.getParameter("zoneId")));
	
		System.out.println("id of loadward"+request.getParameter("zoneId"));
		WardVo wardVo = new WardVo();
		wardVo.setZoneref(zoneVo);
	
	
		WardDao wardDao = new WardDao();	
		List<?> l=wardDao.loadWard(wardVo);
		HttpSession hs=request.getSession();
		hs.setAttribute("loadWard", l);
		response.sendRedirect("admin/loadWard.jsp");
	}
	
	private void loadArea(HttpServletRequest request,HttpServletResponse response) throws IOException 
	{
		System.out.println("In Load Area");
		WardVo wardVo = new WardVo();
		wardVo.setWardId(Integer.parseInt(request.getParameter("wardId")));
	
		System.out.println("idis jj"+request.getParameter("wardId"));
		AreaVo areaVo = new AreaVo();
		areaVo.setWardref(wardVo);
	
		AreaDao areaDao = new AreaDao();	
		List l1=areaDao.loadArea(areaVo);
		
		System.out.println("Load Area Size Is:"+l1.size());
		HttpSession hs=request.getSession();
		hs.setAttribute("loadArea", l1);
		response.sendRedirect("admin/loadArea.jsp");
	}
	

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int roadId = Integer.parseInt(request.getParameter("id"));

		RoadsideunitVo roadsideunitVo = new RoadsideunitVo();
		roadsideunitVo.setRoadId(roadId);

		HttpSession r = request.getSession();

		ZoneDao zoneDao = new ZoneDao();
		List ls1 = zoneDao.load();
		r.setAttribute("zone", ls1);

		WardDao wardDao = new WardDao();
		List ls = wardDao.load();
		r.setAttribute("ward", ls);

		AreaDao areaDao = new AreaDao();
		List ls2 = areaDao.load();
		r.setAttribute("area", ls2);

		DustbinDao dustbinDao = new DustbinDao();
		List ls4 = dustbinDao.load();
		r.setAttribute("dust", ls4);

		RoadsideunitDao roadsideunitDao = new RoadsideunitDao();
		List list = roadsideunitDao.edit(roadsideunitVo);
		r.setAttribute("road", list);

		response.sendRedirect("admin/edit_road_side_unit.jsp");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("^_^");
		double longi = Double.parseDouble(request.getParameter("longi"));
		double lati = Double.parseDouble(request.getParameter("lati"));

		System.out.println("11111111111");
		int id = Integer.parseInt(request.getParameter("id"));
		int zoneId = Integer.parseInt(request.getParameter("zoneId"));
		int wardId = Integer.parseInt(request.getParameter("wardId"));
		int areaId = Integer.parseInt(request.getParameter("areaId"));
		int dustId = Integer.parseInt(request.getParameter("dustId"));

		System.out.println("Data:" + longi + "" + lati);
		System.out.println("11111111111");

		DustbinVo dustbinVo = new DustbinVo();
		ZoneVo zoneVo = new ZoneVo();
		WardVo wardVo = new WardVo();
		AreaVo areaVo = new AreaVo();

		RoadsideunitVo roadsideunitVo = new RoadsideunitVo();

		roadsideunitVo.setLongi(longi);
		roadsideunitVo.setLati(lati);
		roadsideunitVo.setRoadId(id);

		zoneVo.setZoneId(zoneId);
		wardVo.setWardId(wardId);
		areaVo.setAreaId(areaId);
		dustbinVo.setDustId(dustId);

		roadsideunitVo.setZoneRef(zoneVo);
		roadsideunitVo.setWardRef(wardVo);
		roadsideunitVo.setAreaRef(areaVo);
		roadsideunitVo.setDustbinRef(dustbinVo);

		RoadsideunitDao roadsideunitDao = new RoadsideunitDao();
		roadsideunitDao.update(roadsideunitVo);
		search(request, response);

	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		System.out.println("delete");
		int roadId =Integer.parseInt(request.getParameter("id"));
		System.out.println(roadId);
		RoadsideunitVo roadsideunitVo = new RoadsideunitVo();
		roadsideunitVo.setRoadId(roadId);
		
		RoadsideunitDao roadsideunitDao = new RoadsideunitDao();
		roadsideunitDao.delete(roadsideunitVo);
		
		
		search(request, response);
	}


}
