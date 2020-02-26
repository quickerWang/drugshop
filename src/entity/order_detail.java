package entity;

public class order_detail {
	String id;
	String order_id;
	String drug_id;
	int number;   //药品件数
	double price;  //金额
	double discount; //优惠
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(String drug_id) {
		this.drug_id = drug_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public order_detail(String id, String order_id, String drug_id, int number, double price, double discount) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.drug_id = drug_id;
		this.number = number;
		this.price = price;
		this.discount = discount;
	}
	public order_detail() {
		super();
	}
	
}
