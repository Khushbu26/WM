package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UEmailDao;
import vo.UEmailVo;

@WebServlet("/UEmailController")
public class UEmailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public UEmailController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

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
		String email = request.getParameter("email");
	
	    UEmailVo uEmailVo=new UEmailVo();
	    uEmailVo.setEmail(email);
	    
	    UEmailDao uEmailDao=new UEmailDao();
	    uEmailDao.insert(uEmailVo);
	    response.sendRedirect("user/u_index.jsp");
		
	}

}
