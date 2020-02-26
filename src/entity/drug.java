package entity;

public class drug {
	private String id;
	private String name;
	private String norms;  //¹æ¸ñ
	private DrugType type;
	private double price;
	private String factory_id;
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
	public String getNorms() {
		return norms;
	}
	public void setNorms(String norms) {
		this.norms = norms;
	}
	public DrugType getType() {
		return type;
	}
	public void setType(DrugType type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getFactory_id() {
		return factory_id;
	}
	public void setFactory_id(String factory_id) {
		this.factory_id = factory_id;
	}
	public drug(String id, String name, String norms, DrugType type, double price, String factory_id) {
		super();
		this.id = id;
		this.name = name;
		this.norms = norms;
		this.type = type;
		this.price = price;
		this.factory_id = factory_id;
	}
	public drug() {
		super();
	}
	
	
	
}
