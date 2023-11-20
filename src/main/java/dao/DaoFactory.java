package dao;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DaoFactory {
 public static ItemDao createItemDao() {
	 return new ItemDaoImpl(getDataSource());
 }
 
 //DB接続のメソッド
 private static DataSource getDataSource() {
		DataSource ds = null;
		try {
			InitialContext ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/inventory_db");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	return ds;
 }

 //LocationDao インターフェースを実装したクラスのインスタンスを返す。
 public static LocationDao createLocationDao() {
	 return new LocationDaoImpl(getDataSource());
	 
 }
 
 
	public static UserDao createUserDao() {
		return new UserDaoImpl(getDataSource());
		
	}
 
}
