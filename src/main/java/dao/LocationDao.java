package dao;

import java.util.List;

import domain.Location;

public interface LocationDao {
	
	//locations テーブル内の全ての場所情報を取得する。
	public List<Location> findAll()
			throws Exception;
	
	//指定したid の場所情報を取得する。
	public Location findById(Integer id)
			throws Exception;
	
	//指定した場所情報をlocations テーブルに追加する。
	public void insert(Location location)
			throws Exception;
	
	//指定した場所情報をlocations テーブル内で更新する。
	public void update(Location location)
			throws Exception;
	
	//指定した場所情報をlocations テーブルから削除する。
	public void delete(Location location)
			throws Exception;

}
