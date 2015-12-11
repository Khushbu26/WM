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
import dao.UComplaintDao;
import vo.AreaVo;
import vo.UComplaintVo;

@WebServlet("/UComplaintController")
public class UComplaintController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UComplaintController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		System.out.println(flag);

		if (flag.equals("load")) {
			load(request, response);
		}

	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		AreaDao k = new AreaDao();
		List<?> ls2 = k.load();
		HttpSession r = request.getSession();
		r.setAttribute("areaName", ls2);
		response.sendRedirect("user/post_complaint.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if (flag.equals("insert")) {
			insert(request, response);
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String compName = request.getParameter("compName");
		String compDes = request.getParameter("compDes");

		HttpSession r = request.getSession();

		int k = Integer.parseInt(request.getParameter("area"));

		AreaVo areaVo = new AreaVo();
		areaVo.setAreaId(k);

		System.out.println(compName + compDes);

		UComplaintVo uComplaintVo = new UComplaintVo();

		uComplaintVo.setCompName(compName);
		uComplaintVo.setCompDes(compDes);
		uComplaintVo.setAreaRef(areaVo);

		UComplaintDao uComplaintDao = new UComplaintDao();
		uComplaintDao.insert(uComplaintVo);
		response.sendRedirect("user/post_complaint.jsp");

	}

	/*
	 * protected void search(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * U_Complaint_DAO u_Complaint_DAO = new U_Complaint_DAO();
	 * u_Complaint_DAO.search();
	 * 
	 * List list = u_Complaint_DAO.search(); HttpSession r =
	 * request.getSession(); r.setAttribute("complaint", list);
	 * response.sendRedirect("admin/search_complaint.jsp");
	 * 
	 * }
	 */

	/*
	 * protected void search2(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * U_Complaint_DAO u_Complaint_DAO = new U_Complaint_DAO();
	 * u_Complaint_DAO.search(); List list = u_Complaint_DAO.search();
	 * HttpSession r = request.getSession(); r.setAttribute("complaint", list);
	 * response.sendRedirect("admin/search_complaint2.jsp");
	 * 
	 * }
	 */

	/*
	 * protected void search3(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException {
	 * 
	 * U_Complaint_DAO u_Complaint_DAO = new U_Complaint_DAO();
	 * u_Complaint_DAO.search(); List list = u_Complaint_DAO.search();
	 * HttpSession r = request.getSession(); r.setAttribute("complaint", list);
	 * response.sendRedirect("admin/search_complaint3.jsp");
	 * 
	 * 
	 * }
	 */

}
