package entity;

public class shop {
	String id;
	String name;
	String address;
	String telephone;
	public shop(String id, String name, String address, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.telephone = telephone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public shop() {
		super();
	}
	
}
