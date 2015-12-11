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
import dao.UContactDao;
import vo.AreaVo;
import vo.UComplaintVo;
import vo.UContactVo;

	/**
	 * Servlet implementation class U_Complaint_Controller
	 */
	@WebServlet("/UContactController")
	public class UContactController  extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public UContactController() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String flag = request.getParameter("flag");
			System.out.println(flag);

			/*if (flag.equals("load")) {
				load(request, response);
			}*/
			/*if (flag.equals("search2")) {
				search2(request, response);
			}
			if (flag.equals("search3")) {
				search3(request, response);
			}*/
		}

		/*protected void load(HttpServletRequest request, HttpServletResponse response) throws IOException  {
			// TODO Auto-generated method stub
		AreaDao k = new AreaDao();
		List<?> ls2 = k.load();
		HttpSession r = request.getSession();
		r.setAttribute("areaName", ls2);
		response.sendRedirect("user/post_complaint.jsp");

		}*/

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			String flag = request.getParameter("flag");
			System.out.println(flag);
			if (flag.equals("insert")) {
				insert(request, response);
			}
		}

		protected void insert(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {
			String contactName = request.getParameter("name");
			String contactEmail = request.getParameter("email");
			String contactSubject = request.getParameter("subject");
			String contactMessage = request.getParameter("message");

		/*	HttpSession r = request.getSession();*/
			
			
			
			System.out.println(contactName + contactEmail+contactSubject+contactMessage);

			UContactVo uContactVo = new UContactVo();
			
			uContactVo.setContactName(contactName);
			uContactVo.setContactEmail(contactEmail);
			uContactVo.setContactSubject(contactSubject);
			uContactVo.setContactMessage(contactMessage);
			

			UContactDao uContactDao = new UContactDao();
			uContactDao.insert(uContactVo);
			response.sendRedirect("user/u_contact.jsp");

		}

		/*protected void search(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			U_Complaint_DAO u_Complaint_DAO = new U_Complaint_DAO();
			u_Complaint_DAO.search();

			List list = u_Complaint_DAO.search();
			HttpSession r = request.getSession();
			r.setAttribute("complaint", list);
			response.sendRedirect("admin/search_complaint.jsp");

		}*/

		/*protected void search2(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			U_Complaint_DAO u_Complaint_DAO = new U_Complaint_DAO();
			u_Complaint_DAO.search();
			List list = u_Complaint_DAO.search();
			HttpSession r = request.getSession();
			r.setAttribute("complaint", list);
			response.sendRedirect("admin/search_complaint2.jsp");

		}*/

		/*protected void search3(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			U_Complaint_DAO u_Complaint_DAO = new U_Complaint_DAO();
			u_Complaint_DAO.search();
			List list = u_Complaint_DAO.search();
			HttpSession r = request.getSession();
			r.setAttribute("complaint", list);
			response.sendRedirect("admin/search_complaint3.jsp");


	}*/
	
}


