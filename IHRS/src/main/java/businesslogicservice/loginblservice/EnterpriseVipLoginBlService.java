package businesslogicservice.loginblservice;

import vo.EnterpriseVipVO;

public interface EnterpriseVipLoginBlService {
	
	/**
	 * @param enterpriseVipId    企业会员编号
	 * @param enterpriseVipName  企业会员名
	 * @param password           企业会员密码
	 * @return                   企业会员登录
	 */
	public EnterpriseVipVO login(int enterpriseVipId,String enterpriseVipName,String password);
	
	/**
	 * @param enterpriseVipVO  企业会员信息
	 * @param oldPassword      旧的密码
	 * @param newPassword      需要修改的额新的密码
	 * @return                 密码是否修改成功
	 */
	public boolean modify(EnterpriseVipVO enterpriseVipVO,String oldPassword,String newPassword);

}
