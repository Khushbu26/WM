package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CategoryDao;
import dao.ZoneDao;
import vo.CategoryVo;
import vo.ZoneVo;

/**
 * Servlet implementation class Zone_Controller
 */
@WebServlet("/CategoryController")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategoryController() {
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

	private void insert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub

		String categoryName = request.getParameter("category");
		String categoryDes = request.getParameter("categoryDes");
		System.out.println(categoryName + categoryDes);
		CategoryVo categoryVo = new CategoryVo();

		categoryVo.setCategoryName(categoryName);
		categoryVo.setCategoryDes(categoryDes);
		System.out.println("after vo");
		CategoryDao categoryDao = new CategoryDao();
		CategoryDao.insert(categoryVo);
		response.sendRedirect("admin/add_category.jsp");
		System.out.println("after dao");
	}

	protected void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in category search");
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.search();
		List list = categoryDao.search();
		HttpSession r = request.getSession();
		r.setAttribute("category", list);
		response.sendRedirect("admin/search_category.jsp");

	}

	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int categoryId = Integer.parseInt(request.getParameter("id"));
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setCategoryId(categoryId);
		System.out.println("in edit method");
		CategoryDao categoryDao = new CategoryDao();

		List<?> list = categoryDao.edit(categoryVo);
		HttpSession r = request.getSession();
		r.setAttribute("editcategory", list);
		response.sendRedirect("admin/editcategory.jsp");
		System.out.println("end of edit method");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in update method");

		String categoryName = request.getParameter("category");
		String categoryDes = request.getParameter("category_des");
		int ed = Integer.parseInt(request.getParameter("id"));
		System.out.println("Data: " + categoryDes + "" + categoryName + "" + ed);

		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setCategoryName(categoryName);
		categoryVo.setCategoryDes(categoryDes);
		categoryVo.setCategoryId(ed);

		CategoryDao categoryDao = new CategoryDao();
		categoryDao.update(categoryVo);
		response.sendRedirect("admin/add_category.jsp");
		System.out.println("end of update method");

	}
	
	  protected void delete(HttpServletRequest request, HttpServletResponse
	  response) throws ServletException, IOException {
		  
		  int categoryId=Integer.parseInt(request.getParameter("id"));
	  
		  System.out.println(categoryId);
		  
		  CategoryVo categoryVo=new CategoryVo();
		  categoryVo.setCategoryId(categoryId);
	  
		  CategoryDao categoryDao=new CategoryDao(); //category_DAO.delete(category_VO);
	  
		  HttpSession r= request.getSession();
	  
	  
		  if(!categoryDao.delete(categoryVo)) { r.setAttribute("ErrorMsg",
				  "Plz Delete Child Class First");
	  
		  } else{
	  
			  r.removeAttribute("ErrorMsg"); }
	  
		  search(request, response);
	  
	  	}
	 

	}
