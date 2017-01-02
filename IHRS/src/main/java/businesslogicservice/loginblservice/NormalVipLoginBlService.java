package businesslogicservice.loginblservice;

import vo.NormalVipVO;

public interface NormalVipLoginBlService {
	
	/**
	 * @param normalVipId    普通会员编号
	 * @param normalVipName  普通会员名
	 * @param password       普通会员密码
	 * @return               普通会员登录
	 */
	public NormalVipVO login(int normalVipId,String normalVipName,String password);
	
	/**
	 * @param normalVipVO  普通会员信息
	 * @param oldPassword  旧的密码
	 * @param newPassword  需要设置的新的密码
	 * @return
	 */
	public boolean modify(NormalVipVO normalVipVO,String oldPassword,String newPassword);
	
}
