package entity;

public class Administrator {
	private String password; //√‹¬Î
	private String id;  //’Àªß
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Administrator(String password, String id) {
		super();
		this.password = password;
		this.id = id;
	}
	public Administrator() {
		super();
	}
	
}
