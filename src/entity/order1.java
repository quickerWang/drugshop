package entity;

import java.util.Date;

public class order1 {
	private String id;
	private Date time;
	private String client_id;
	private String shop_id;
	private String clerk_id;
	private double sum;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getClient_id() {
		return client_id;
	}
	public void setClient_id(String client_id) {
		this.client_id = client_id;
	}
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getClerk_id() {
		return clerk_id;
	}
	public void setClerk_id(String clerk_id) {
		this.clerk_id = clerk_id;
	}
	public double getSum() {
		return sum;
	}
	public void setSum(double sum) {
		this.sum = sum;
	}
	public order1(String id, Date time, String client_id, String shop_id, String clerk_id, double sum) {
		super();
		this.id = id;
		this.time = time;
		this.client_id = client_id;
		this.shop_id = shop_id;
		this.clerk_id = clerk_id;
		this.sum = sum;
	}
	public order1() {
		super();
	}
	
}
