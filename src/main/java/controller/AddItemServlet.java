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
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/addItem")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			LocationDao locationDao = DaoFactory.createLocationDao();
			List<Location>locationList = locationDao.findAll();
			request.setAttribute("locationList", locationList);
			request.getRequestDispatcher("/WEB-INF/view/addItem.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け防止
		request.setCharacterEncoding("UTF-8");
		
		//データの追加
		String name = request.getParameter("name");
		String amount = request.getParameter("amount");
		Integer locationId = Integer.parseInt(request.getParameter("locationId"));
		String note = request.getParameter("note");
		Item item = new Item();
		
		//バリデーションチェック
		//エラーメッセージを格納する変数
		String errorName = null;
		String erroramount = null;
		
		if(name.isBlank()) {
			System.out.println("品名が未入力です");
			errorName += "品名が未入力です";
		}else if(name.length() > 50) {
			System.out.println("品名は50文字以内で入力してください");
			errorName += "品名が未入力です";
		}
		
		//個数チェック
	
			if(amount.isBlank()) {
				System.out.println("個数が未入力です");
				erroramount += "個数が未入力です";
			}else{
				try {
					int amountInt = Integer.parseInt(amount);
					if(amountInt < 0) {
						System.out.println("個数は正の整数で入力してください。");
						erroramount += "個数は正の整数で入力してください。";
						
					}
				}catch (NumberFormatException e) {
					System.out.println("個数は整数で入力してください。");
					erroramount += "個数は整数で入力してください。";
				}
			}
			
			//バリデーションエラーがある場合
			if(errorName !=null || erroramount !=null) {
				//フォーム入力値再表示用
				request.setAttribute("name", name);
				request.setAttribute("amount", amount);
				request.setAttribute("locationId", locationId);
				request.setAttribute("note", note);
				
				//エラーメッセージ表示用
				request.setAttribute("errorName", errorName);
				request.setAttribute("erroramount", erroramount);
				
				doGet(request,response);
				return;
				
			}else {
				
			// バリデーションに成功した場合、データベースにデータを挿入
			
			try {
		item.setName(name);
		item.setAmount(Integer.parseInt(amount));
		item.setLocationId(locationId);
		item.setNote(note);
		
		ItemDao itemDao = DaoFactory.createItemDao();
		itemDao.insert(item);
		
		request.getRequestDispatcher("/WEB-INF/view/addItemDone.jsp").forward(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
		
		
	}

}
}
