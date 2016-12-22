package po;

import java.io.Serializable;

/**
 * id        用户编号
 * userName  用户名
 * phone     手机号
 */
public class UserPO implements Serializable {

	private static final long serialVersionUID = 4533717957936619567L;
	
	
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
	
	@Override
	public boolean equals(Object o) {
		UserPO userPO = (UserPO) o;
		return (userPO.getId() == id);
    }
}
