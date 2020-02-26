package entity;

public class client {
	private String id;
	private String name;
	private double point;
	private String telephone;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public client(String id, String name, double point, String telephone) {
		super();
		this.id = id;
		this.name = name;
		this.point = point;
		this.telephone = telephone;
	}
	public client() {
		super();
	}
	
}
