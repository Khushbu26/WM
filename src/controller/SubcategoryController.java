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
import dao.SubcategoryDao;
import vo.CategoryVo;
import vo.SubcategoryVo;

/**
 * Servlet implementation class SubcategoryController
 */
@WebServlet("/SubcategoryController")
public class SubcategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubcategoryController() {
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
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String subcategoryName =request.getParameter("subcat");
		String subcategoryDes =request.getParameter("subcat_des");
		System.out.println(subcategoryName + subcategoryDes);
		int i = Integer.parseInt(request.getParameter("categoryId"));
		
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setCategoryId(i);
		
		SubcategoryVo subcategoryVo=new SubcategoryVo();
		subcategoryVo.setSubcategoryName(subcategoryName);
		subcategoryVo.setSubcategoryDes(subcategoryDes);
		subcategoryVo.setCatRef(categoryVo);
		
		SubcategoryDao subcategoryDao=new SubcategoryDao();
		subcategoryDao.insert(subcategoryVo);
		search(request, response);
		
}

	protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			CategoryDao categoryDao = new CategoryDao();
			List<?> ls =categoryDao.load();
			HttpSession r= request.getSession();
			r.setAttribute("category", ls);
			response.sendRedirect("admin/add_subcategory.jsp");
			
			
			
		}
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		SubcategoryDao subcategoryDao=new SubcategoryDao();	
		subcategoryDao.search();
		List<?> list =subcategoryDao.search();
		HttpSession r= request.getSession();
		r.setAttribute("subcategory", list);
		response.sendRedirect("admin/search_subcategory.jsp");
		
		
		
	}
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{	
		
		int subcategoryId =Integer.parseInt(request.getParameter("id"));
		SubcategoryVo subcategoryVo=new SubcategoryVo();
		subcategoryVo.setSubcategoryId(subcategoryId);
		
		SubcategoryDao subcategoryDao=new SubcategoryDao();
		CategoryDao categoryDao = new CategoryDao();
		List<?> ls =categoryDao.load();
		
		List<?> list =subcategoryDao.edit(subcategoryVo);
		System.out.print("edit size is"+list.size());
		HttpSession r= request.getSession();
		r.setAttribute("editsubcategory", list);
		r.setAttribute("category", ls);
		response.sendRedirect("admin/edit_subcategory.jsp");
	}

	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		System.out.println("11111111111");
		String subcategoryName =request.getParameter("subcat");
		String subcategoryDes =request.getParameter("subcat_des");
		int ed=Integer.parseInt(request.getParameter("id"));
		int pd=Integer.parseInt(request.getParameter("categoryId"));
		System.out.println("Data:"+subcategoryDes +""+ subcategoryName+""+ed+pd);
		//System.out.println("11111111111");
		

		CategoryVo categoryVo=new CategoryVo();
		SubcategoryVo subcategoryVo=new SubcategoryVo();
		subcategoryVo.setSubcategoryName(subcategoryName);
		subcategoryVo.setSubcategoryDes(subcategoryDes);
		subcategoryVo.setSubcategoryId(ed);
		categoryVo.setCategoryId(pd);	
		subcategoryVo.setCatRef(categoryVo);
		
		SubcategoryDao subcategoryDao=new SubcategoryDao();
		subcategoryDao.update(subcategoryVo);
		search(request, response);
		
	}
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		int subcategoryId =Integer.parseInt(request.getParameter("id"));
		System.out.println(subcategoryId);
		SubcategoryVo subcategoryVo=new SubcategoryVo();
		
		subcategoryVo.setSubcategoryId(subcategoryId);
		
		SubcategoryDao subcategoryDao=new SubcategoryDao();
		subcategoryDao.delete(subcategoryVo);
			
		search(request, response);

	}

	
}
