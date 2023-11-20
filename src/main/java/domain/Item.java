package domain;

import java.util.Date;

public class Item {
	
	private Integer id;
	private String name;
	private Integer amount;
	private Integer locationId;
	private String note;
	private Date registered;
	private Date updated;
	private String locationName;

	public Item(Integer id, String name, Integer amount, Integer locationId, String note, Date registered, Date updated,
			String locationName) {
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.locationId = locationId;
		this.note = note;
		this.registered = registered;
		this.updated = updated;
		this.locationName = locationName;
	}
	public Item() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getRegistered() {
		return registered;
	}
	public void setRegistered(Date registered) {
		this.registered = registered;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	
	
	

}
