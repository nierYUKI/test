package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import domain.Item;

public class ItemDaoImpl implements ItemDao {
	private DataSource ds;
	public ItemDaoImpl(DataSource ds) {
		this.ds = ds;
		
	}
	
	@Override
	public List<Item> findAll() throws Exception {
		List<Item>ItemList = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			String sql = "SELECT *, locations.name AS location_name FROM items"
			    + " JOIN locations ON items.location_id = locations.id"
			    + " ORDER BY items.id";
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				ItemList.add(mapToItem(rs));
			}
		}catch(Exception e) {
			throw e;
		}
		
		return ItemList;
	}

	@Override
	public Item findById(Integer id) throws Exception {
		//データ 1件分を取得する
		Item item = new Item();
		
		try(Connection con = ds.getConnection()){
			String sql = "select *, locations.name AS location_name from items"
									+ " join locations on items.location_id = locations.id"
									+ " where items.id =?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1,id,Types.INTEGER);
			ResultSet rs = stmt.executeQuery();
			if(rs.next() == true) {
				item = mapToItem(rs);
			}
		}catch(Exception e) {
			throw e;
		}
		
		return item;
	}

	@Override
	public void insert(Item item) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = " insert into items "
					+ "(name, amount,location_id,note,registered) "
					+ "values(?,?,?,?,now())";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,item.getName());
			stmt.setObject(2,item.getAmount(),Types.INTEGER);
			stmt.setInt(3, item.getLocationId());
			stmt.setString(4, item.getNote());
//			stmt.setObject(5, item.getRegistered(),Types.INTEGER);
			stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public void update(Item item) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "update items set name=?, "
					+ " amount=?,"
					+ " location_id=?,"
					+ " note=?,"
					+ " where id=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, item.getName());
			stmt.setObject(2, item.getAmount(),Types.INTEGER);
			stmt.setInt(3, item.getLocationId());
			stmt.setString(4, item.getNote());
			stmt.setObject(5, item.getId(),Types.INTEGER);
			stmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}
		
	}

	@Override
	public void delete(Item item) throws Exception {
		try(Connection con = ds.getConnection()){
			String sql = "delete from items where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setObject(1, item.getId(), Types.INTEGER);
			stmt.executeUpdate();
		}catch (Exception e) {
			throw e;
		}
		
	}
	/*
	 * ResultSetからItemオブジェクトへの変換
	 */
	private Item mapToItem(ResultSet rs)throws Exception{
		Integer id = (Integer)rs.getObject("id");
		String name = rs.getString("name");
		Integer amount = (Integer)rs.getObject("amount");
		Integer locationId = (Integer)rs.getObject("Id");
		String  note = rs.getString("note");
		Date registered = rs.getTimestamp("registered");
		Date updated = rs.getTimestamp("updated");
		String locationName = rs.getString("locations.Name");
		
		
		return new Item(id,name,amount,locationId,note,registered,updated,locationName);
		
		
		
		
		
	}
}
