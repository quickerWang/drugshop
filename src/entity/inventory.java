package entity;

public class inventory {
	private String shop_id;
	private String drug_id;
	int num;
	public String getShop_id() {
		return shop_id;
	}
	public void setShop_id(String shop_id) {
		this.shop_id = shop_id;
	}
	public String getDrug_id() {
		return drug_id;
	}
	public void setDrug_id(String drug_id) {
		this.drug_id = drug_id;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public inventory(String shop_id, String drug_id, int num) {
		super();
		this.shop_id = shop_id;
		this.drug_id = drug_id;
		this.num = num;
	}
	public inventory() {
		super();
	}
	
	
}
