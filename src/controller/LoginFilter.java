package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.LoginDao;
import vo.LoginVo;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/*")
public class LoginFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public LoginFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		System.out.println("In filter");
		String uri = ((HttpServletRequest) request).getRequestURI();
		HttpSession session = ((HttpServletRequest) request).getSession();
		RequestDispatcher requestDispatcher;
		// String logout = request.getParameter("logout");
		String flag = request.getParameter("flag");

		System.out.println("flag = " + flag);
		if (uri.contains("login") || uri.contains("/css") || uri.contains("/js") || uri.contains("user/images")
				|| uri.contains("/img") || uri.contains("/fonts") || uri.contains("/font") || uri.contains("c_reg.jsp")
				|| uri.contains("/admin/u_reg.jsp") 
				|| uri.contains("fileupload.jsp") || uri.contains("controller")) {

			System.out.println("inside reg");

			// requestDispatcher =
			// request.getRequestDispatcher("/user/register.jsp");
			// requestDispatcher.forward(request,response);

			chain.doFilter(request, response);

		} else if (flag != null && flag.equals("logout")) {
			// session.removeAttribute("userID");
			System.out.println("logout in else if");
			session.invalidate();
			System.out.println("after session invalidates");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);

		}

		else if (request.getParameter("flag") != null && request.getParameter("flag").equals("login")) {

			String userName = request.getParameter("userName");
			String userPassword = request.getParameter("userPassword");
			System.out.println(userName + "" + userPassword);

			LoginVo loginVo = new LoginVo();
			loginVo.setUserName(userName);
			loginVo.setUserPassword(userPassword);
			// loginVo.setUserType(userType);

			LoginDao loginDao = new LoginDao();
			List<?> list = loginDao.authentication(loginVo);

			if (list != null && list.size() >= 1) {

				Iterator<?> itr = list.iterator();
				LoginVo user = (LoginVo) itr.next();

				int y = (Integer) user.getUserId();
				/*
				 * HttpSession r= ((HttpServletRequest) request).getSession();
				 */
				session.setAttribute("userId", y);

				String type = user.getUserType();
				System.out.println(type);
				session.setAttribute("usertype", type);
				System.out.println(y);

				if (type.equals("admin")) {

					requestDispatcher = request.getRequestDispatcher("/admin/index.jsp");
					requestDispatcher.forward(request, response);
				} else if (type.equals("Govt_staff")) {

					requestDispatcher = request.getRequestDispatcher("/admin/g_index.jsp");
					requestDispatcher.forward(request, response);
				}else if (type.equals("company")) {

					requestDispatcher = request.getRequestDispatcher("/admin/c_index.jsp");
					requestDispatcher.forward(request, response);
				}else if (type.equals("user"))

				{
					//((HttpServletResponse)response).sendRedirect("user/u_index.jsp");
					
					requestDispatcher = request
							.getRequestDispatcher("/user/u_index.jsp");
					requestDispatcher.forward(request, response);
				}

			}
		
		}
		else if (session.getAttribute("userID") != null) {
			String h = (String) session.getAttribute("usertype");
			System.out.println("type = = = " + h);

			if (h != null && h.equals("admin")) {

				System.out.println("admin_chain");
				chain.doFilter(request, response);
			}
			else if (h != 	null && h.equals("Govt_staff")) {
				System.out.println("Govt_Staff_chain");				
				chain.doFilter(request, response);
			}
			else if (h != null && h.equals("company")) {
				System.out.println("company_chain");				
				chain.doFilter(request, response);
			}
			else {
				System.out.println("chain");
				/*RequestDispatcher rd = request
						.getRequestDispatcher("/admin/s_index.jsp");
				rd.forward(request, response);*/
				chain.doFilter(request, response);
			}
		}else {
			RequestDispatcher rd = request
					.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);

			}
		}

	

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
