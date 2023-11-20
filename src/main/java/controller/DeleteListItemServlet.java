package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ItemDao;
import domain.Item;

/**
 * Servlet implementation class DeleteListItemServlet
 */
@WebServlet("/deleteList")
public class DeleteListItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Getパラメータの取得	
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);

		try {
			//削除する会員データの取得
			ItemDao itemDao = DaoFactory.createItemDao();
			Item item = itemDao.findById(id);

			//削除ページの表示
			request.setAttribute("item", item);

			request.getRequestDispatcher("/WEB-INF/view/deleteList.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Get パラメータの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		// 削除メソッドの引数用にMember オブジェクトを作成
		Item item = new Item();
		item.setId(id);
		try {
		// データの削除
		ItemDao itemDao = DaoFactory.createItemDao();
		itemDao.delete(item);
		// 削除完了ページの表示
		request.getRequestDispatcher("/WEB-INF/view/deleteListDone.jsp")
		.forward(request, response);
		} catch (Exception e) {
		throw new ServletException(e);
	}

}
}