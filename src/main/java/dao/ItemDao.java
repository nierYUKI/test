package dao;

import java.util.List;

import domain.Item;

public interface ItemDao {
	
	//items テーブル内の全ての備品情報を取得する。
	public List<Item>findAll() throws Exception;
	
	//指定したid の備品情報を取得する。
	public Item findById(Integer id)throws Exception;
	
	//指定した備品情報をitems テーブルに追加する。
	public void insert(Item item)throws Exception;
	
	//指定した備品情報をitems テーブル内で更新する。
	public void update(Item item)throws Exception;
	
	//指定した備品情報をitems テーブルから削除する。
	public void delete(Item item)throws Exception;

}
