package po;

public class UserPO {
	
	private int id;
	private String userName;
	private String phone;
	
	public UserPO(int id,String userName,String phone){
		this.id=id;
		this.userName=userName;
		this.phone=phone;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
