package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import domain.Location;

public class LocationDaoImpl implements LocationDao {
	
	private DataSource ds;
	public LocationDaoImpl(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public List<Location> findAll() throws Exception {
		List<Location>locationList = new ArrayList<>();
		try(Connection con = ds.getConnection()){
			String sql = "select * from locations";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				locationList.add(mapTolocationList(rs));
			}
			
		}
		return locationList;
	}
	@Override
	public Location findById(Integer id) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	@Override
	public void insert(Location location) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void update(Location location) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public void delete(Location location) throws Exception {
		// TODO 自動生成されたメソッド・スタブ
	}
	
	private Location mapTolocationList(ResultSet rs)throws Exception{
		Integer id = (Integer)rs.getObject("id");
		String name = rs.getString("name");
		
		return new Location(id,name);
	
	}

}
