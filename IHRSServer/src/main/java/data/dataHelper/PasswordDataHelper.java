package data.dataHelper;

import java.util.HashMap;

import po.PasswordPO;

public interface PasswordDataHelper {
	
	/**
	 * @return  用户密码（左用户编号）
	 */
	public HashMap<Integer,PasswordPO> getPasswordById();
	
	/**
	 * @return  用户密码（左用户名）
	 */
	public HashMap<String,PasswordPO> getPasswordByName();
	
	/**
	 * @param passwordMap  用户密码（左用户编号）
	 */
	public void updatePasswordById(HashMap<Integer,PasswordPO> passwordMap);
	
	/**
	 * @param passwordMap  用户密码（左用户名）
	 */
	public void updatePasswordByName(HashMap<String,PasswordPO> passwordMap);

}
