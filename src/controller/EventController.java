package controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EventDao;
import dao.WardDao;
import dao.ZoneDao;
import vo.EventVo;
import vo.WardVo;
import vo.ZoneVo;

@WebServlet("/EventController")
public class EventController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EventController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String flag = request.getParameter("flag");
		System.out.println(flag);
		/*
		 * if (flag.equals("load")) { load(request, response); }
		 */
		if (flag.equals("search")) {
			search(request, response);
		}
		if (flag.equals("edit")) {
			edit(request, response);
		}
		if (flag.equals("delete")) {
			delete(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag = request.getParameter("flag");

		System.out.println("Flage name:"+flag);
		
		if (flag.equals("insert")) {
			insert(request, response);
		}
		if (flag.equals("update")) {
			update(request, response);
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EventController-Insert method");
		String eventName = request.getParameter("event_name");
		String eventDes = request.getParameter("event_des");
		String startDate = request.getParameter("start");
		String endDate = request.getParameter("end");
		
		EventVo eventVo = new EventVo();
		eventVo.setEventName(eventName);
		eventVo.setEventDes(eventDes);
		eventVo.setStartDate(startDate);
		eventVo.setEndDate(endDate);

		EventDao eventDao = new EventDao();
		eventDao.insert(eventVo);
		response.sendRedirect("admin/add_events.jsp");

	}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("EventController-Load method");
		EventDao eventDao = new EventDao();
		List<?> ls = eventDao.load();
		HttpSession r = request.getSession();
		r.setAttribute("event", ls);
		response.sendRedirect("admin/search_event.jsp");

	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EventController-search method");
		EventDao eventDao = new EventDao();

		eventDao.search();
		List<?> list = eventDao.search();
		HttpSession r = request.getSession();
		r.setAttribute("event", list);
		response.sendRedirect("admin/search_events.jsp");

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("EventController-Load method");
		int eventId = Integer.parseInt(request.getParameter("id"));
		EventVo eventVo = new EventVo();
		eventVo.setEventId(eventId);

		EventDao eventDao = new EventDao();
		List<?> list = eventDao.edit(eventVo);
		System.out.print("edit size is" + list.size());
		HttpSession r = request.getSession();
		r.setAttribute("editEvent", list);
		response.sendRedirect("admin/edit_event.jsp");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("EventController-update method");
		String eventName = request.getParameter("event_name");
		String eventDes = request.getParameter("event_des");
		String startDate = request.getParameter("start");
		String endDate = request.getParameter("end");
		int eventId=Integer.parseInt(request.getParameter("id"));

		EventVo eventVo = new EventVo();
		
		eventVo.setEventId(eventId);
		eventVo.setEventName(eventName);
		eventVo.setEventDes(eventDes);
		eventVo.setStartDate(startDate);
		eventVo.setEndDate(endDate);
		EventDao eventDao = new EventDao();
		eventDao.update(eventVo);
		search(request,response);

	}

	protected void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int eventId = Integer.parseInt(request.getParameter("id"));

		System.out.println("EventController-Load method");
		EventVo eventVo = new EventVo();
		eventVo.setEventId(eventId);

		EventDao eventDao = new EventDao();
		eventDao.delete(eventVo);

		HttpSession r = request.getSession();

/*		if (!EventDao.delete(eventVo)) {
			r.setAttribute("ErrorMsg", "Plz Delete Child Class First");

		} else {

			r.removeAttribute("ErrorMsg");
		}*/

		search(request, response);

	}
}
