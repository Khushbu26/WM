package controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.restfb.json.JsonArray;

import dao.DustbinDao;
import vo.DustbinVo;

/**
 * Servlet implementation class DustbinController
 */
@WebServlet("/DustbinController")
public class DustbinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DustbinController() {
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
		if (flag.equals("search")) {
			search(request, response);
		}
		/*if (flag.equals("searchMap")) {
			searchMap(request, response);
		}*/
		if (flag.equals("edit")) {
			edit(request, response);
		}
		if (flag.equals("delete")) {
			delete(request, response);
		}
	}
/*
	protected void searchMap(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		System.out.println("in map");
		DustbinDao dustDao1 = new DustbinDao();

		dustDao1.search();
		List<?> list = dustDao1.search();
		HttpSession r = request.getSession();
		r.setAttribute("dust", list);
			response.sendRedirect("user/track_dustbin.jsp");

		}
	*/

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
		String dustNo = request.getParameter("dustno");
		String dustName = request.getParameter("dust");
		double latitude = Double.parseDouble(request.getParameter("latitude"));
		double longitude = Double.parseDouble(request.getParameter("longitude"));
		System.out.println(dustNo + dustName);
		System.out.println("11111111111");

		DustbinVo dustVo = new DustbinVo();
		dustVo.setDustNo(dustNo);
		dustVo.setDustName(dustName);
		dustVo.setLatitude(latitude);
		dustVo.setLongitude(longitude);

		DustbinDao dustDao = new DustbinDao();
		dustDao.insert(dustVo);
		search(request, response);
		/* response.sendRedirect("admin/add_dustbin.jsp"); */

	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		DustbinDao dustDao = new DustbinDao();

		dustDao.search();
		List<?> list = dustDao.search();
		HttpSession r = request.getSession();
		String abc;
		r.setAttribute("dust", list);
		response.sendRedirect("admin/search_dustbin.jsp");

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int dustId = Integer.parseInt(request.getParameter("id"));
		DustbinVo dustVo = new DustbinVo();
		dustVo.setDustId(dustId);
		System.out.println("in edit method");

		DustbinDao dustDao = new DustbinDao();

		List<?> list = dustDao.edit(dustVo);

		HttpSession r = request.getSession();
		r.setAttribute("editdustbin", list);
		response.sendRedirect("admin/edit_dustbin.jsp");
		System.out.println("end of edit method");

	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in edit");
		String dustNo = request.getParameter("dustno");
		String dustName = request.getParameter("dust");
		double latitude = Double.parseDouble(request.getParameter("latitude"));
		double longitude = Double.parseDouble(request.getParameter("longitude"));
		int ed = Integer.parseInt(request.getParameter("id"));
		System.out.println("Data:" + dustNo + "" + dustName + "" + ed);

		DustbinVo dustVo = new DustbinVo();
		dustVo.setDustNo(dustNo);
		dustVo.setDustName(dustName);
		dustVo.setDustId(ed);
		dustVo.setLatitude(latitude);
		dustVo.setLongitude(longitude);

		DustbinDao dustDao = new DustbinDao();
		dustDao.update(dustVo);
		search(request, response);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int dustId = Integer.parseInt(request.getParameter("id"));
		System.out.println(dustId);
		DustbinVo dustVo = new DustbinVo();
		dustVo.setDustId(dustId);

		DustbinDao dustDao = new DustbinDao();
		dustDao.delete(dustVo);

		search(request, response);

	}
}
