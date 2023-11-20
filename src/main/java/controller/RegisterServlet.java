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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		//入力値の取得
		String loginId = request.getParameter("loginId");
		String loginPass = request.getParameter("loginPass");
		String name = request.getParameter("name");
		System.out.println(loginId);
		System.out.println(loginPass);
		System.out.println(name);
		
		//バリデーション
		//DAOを使いDB登録
		UserDao dao = DaoFactory.createUserDao();
		dao.insert(new User(null,loginId,loginPass,name));
		
		response.sendRedirect(request.getContextPath() +"/login" );
		return;
		
	}

}
