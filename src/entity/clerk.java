package entity;

public class clerk {
	String id;
	String shop_id;
	String name;
	String password;
	public String getPassword() {
		return id;
	}
	public void setPassword(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public clerk(String id, String shop_id, String name,String password) {
		super();
		this.id = id;
		this.shop_id = shop_id;
		this.name = name;
	}
	public clerk() {
		super();
	}
	
}
