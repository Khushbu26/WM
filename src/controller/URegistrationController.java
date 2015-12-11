package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.URegistrationDao;
import vo.URegistrationVo;

/**
 * Servlet implementation class URegistrationController
 */
@WebServlet("/URegistrationController")
public class URegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public URegistrationController() {
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
		String flag = request.getParameter("flag");
		System.out.println(flag);
		if (flag.equals("insert")) {
			insert(request, response);
		}		
	}

	protected void insert(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String name= request.getParameter("name");
		long number=Long.parseLong(request.getParameter("number"));
		int pin=Integer.parseInt(request.getParameter("pin"));
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		String city= request.getParameter("city");
		
		URegistrationVo uRegistrationVo = new URegistrationVo();
		uRegistrationVo.setName(name);
		uRegistrationVo.setNumber(number);
		uRegistrationVo.setEmail(email);
		uRegistrationVo.setPassword(password);
		uRegistrationVo.setCity(city);
		uRegistrationVo.setPin(pin);
		
		URegistrationDao uRegistrationDao = new URegistrationDao();
		uRegistrationDao.insert(uRegistrationVo);
		
	}

}
