package businesslogicservice.loginblservice;

import vo.CustomerVO;

public interface CustomerLoginBlService {
	
	/**
	 * @param customerId    客户编号
	 * @param customerName  客户名
	 * @param password      客户密码
	 * @return              客户登录
	 */
	public CustomerVO login(int customerId,String customerName,String password);
	
	/**
	 * @param customerVO   客户信息
	 * @param oldPassword  旧的密码
	 * @param newPassword  需要修改的新的密码
	 * @return             密码是否修改成功
	 */
	public boolean modify(CustomerVO customerVO,String oldPassword,String newPassword);  //此包中的所有接口中的modify方法都仅仅修改密码
	
	/**
	 * @param customerName  填写的用户名
	 * @param password      设置的密码
	 * @param phone         客户手机号
	 * @return              客户是否注册成功
	 */
	public boolean register(String customerName,String password,String phone);
	
}
