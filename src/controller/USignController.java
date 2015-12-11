package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.USignDao;
import vo.USignVo;

/**
 * Servlet implementation class USignController
 */
@WebServlet("/USignController")
public class USignController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public USignController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if (flag.equals("insert")) {
			insert(request, response);
		}
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String f = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String mobileNo = request.getParameter("mobile");
		String email = request.getParameter("email");
		String setpws = request.getParameter("pass");
		String city = request.getParameter("city");
		int pincode =Integer.parseInt( request.getParameter("pincode"));
		
		System.out.println(f+lastName+mobileNo+email+email+setpws+city+pincode);
		
		USignVo uSignVo=new USignVo();
		uSignVo.setfName(f);
		//uSignVo.setFirstName(firstName);
		uSignVo.setlName(lastName);
		uSignVo.setMoNo(mobileNo);
		uSignVo.setEmail(email);
		uSignVo.setPassword(setpws);
		uSignVo.setCity(city);
		uSignVo.setPin(pincode);
		
		USignDao uSignDao=new USignDao();
		uSignDao.insert(uSignVo);
		
		response.sendRedirect("user/sign_in.jsp");
		
		

	}

}
