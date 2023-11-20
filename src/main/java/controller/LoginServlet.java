package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.UserDao;
import domain.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		try {
			String loginId = request.getParameter("loginId");
			String loginPass = request.getParameter("loginPass");
			System.out.println(loginId);
			System.out.println(loginPass);
			UserDao userDao = DaoFactory.createUserDao();
			User user = userDao.findByLoginAndPass(loginId, loginPass);
			if(user != null) {
        request.getSession().setAttribute("userName", user.getName());
        response.sendRedirect("listItem");
				
				return;
		}else {
			request.setAttribute("error", "ログインIDまたはパスワードが間違えています");
			request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
			
		}
//			
//			HttpSession session = request.getSession();
//			session.setAttribute("user", user);
//			response.sendRedirect(request.getContextPath() + "/listItem");
			
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}
}


