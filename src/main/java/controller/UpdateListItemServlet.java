package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoFactory;
import dao.ItemDao;
import dao.LocationDao;
import domain.Item;
import domain.Location;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/updateItem")
public class UpdateListItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//Getパラメータの取得
		String strId = request.getParameter("id");
		Integer id = Integer.parseInt(strId);
		System.out.println("あほ");
		Integer locationId = Integer.parseInt(request.getParameter("locationId"));
		
		//データの更新

//		String name = request.getParameter("name");
//		String amount = request.getParameter("amount");
//		Integer locationId = Integer.parseInt(request.getParameter("locationId"));
		
//		String note = request.getParameter("note");
		

		
		try {
			//編集する会員データの取得
			ItemDao itemDao = DaoFactory.createItemDao();
			Item item = itemDao.findById(id);
			//編集ページの表示
			request.setAttribute("name", item.getName());
			request.setAttribute("amount", item.getAmount());
			
			//更新ページ内の場所が表示しないのでロケーション「場所」の情報を取得している処理
			LocationDao locationDao = DaoFactory.createLocationDao();
			List<Location>locationList = locationDao.findAll();
			request.setAttribute("locationList", locationList);
			
			request.setAttribute("locationId", item.getLocationId());
			System.out.println(locationId);
			request.setAttribute("note", item.getNote());
			request.getRequestDispatcher("/WEB-INF/view/updateItem.jsp").forward(request, response);
		}catch(Exception e) {
			throw new ServletException(e);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	// データの追加
		try {
				ItemDao itemDao = DaoFactory.createItemDao();
				// 完了ページへフォワード
				request.getRequestDispatcher("/WEB-INF/view/addItemDone.jsp").forward(request, response);
			} catch (Exception e) {
				throw new ServletException(e);
			}
		}


	}


