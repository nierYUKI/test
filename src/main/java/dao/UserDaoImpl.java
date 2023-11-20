package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

import domain.User;

public class UserDaoImpl implements UserDao {

	private DataSource ds;

	public UserDaoImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public void insert(User user) {
		//SQLの準備
		String sql = "insert into users VALUES(null,?,?,?)";
		//パスワードをハッシュ化
		String loginPass = user.getLoginPass();
		String hashed = BCrypt.hashpw(user.getLoginPass(), BCrypt.gensalt());
		System.out.println(hashed);

		try (Connection con = ds.getConnection()) {
			//SQLを実行
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, user.getLoginId());
			System.out.println(user.getLoginId());
			
			stmt.setString(2, hashed);
			System.out.println(hashed);
			
			stmt.setString(3, user.getName());
			System.out.println(user.getName());
			stmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("データが入っていない");

		}

	}

	@Override
	public User findByLoginAndPass(String loginId, String loginPass) throws Exception {

		User user = null;
		String sql = "select * from users where login_id = ?";
		try (Connection con = ds.getConnection()) {
			//SQLを実行
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, loginId);
			ResultSet rs = stmt.executeQuery();
//			System.out.println(rs.getString("login_pass"));
			
			//ログインチェック
			if (rs.next()) {
				//System.out.println(rs.getString("login_pass"));

				                    //ユーザーが入力したPW、ハッシュしたPW
				if (BCrypt.checkpw(loginPass, rs.getString("login_pass"))) {
					user = mapToUser(rs);
				}
			}
		} catch (Exception e) {
			throw e;
		}
		return user;
	}

	protected User mapToUser(ResultSet rs) throws Exception {
		User user = new User();
		user.setId((Integer) rs.getObject("id"));
		user.setLoginId(rs.getString("login_id"));
		user.setLoginPass(rs.getString("login_pass"));
		user.setName(rs.getString("name"));
		return user;
	}

}
