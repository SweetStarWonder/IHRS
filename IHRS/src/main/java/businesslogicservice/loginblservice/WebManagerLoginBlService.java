package businesslogicservice.loginblservice;

import vo.WebManagerVO;

public interface WebManagerLoginBlService {
	
	/**
	 * @param webManagerId    网站管理人员编号
	 * @param webManagerName  网站管理人员名
	 * @param password        网站管理人员密码
	 * @return                网站管理人员登录
	 */
	public WebManagerVO login(int webManagerId,String webManagerName,String password);
	
	/**
	 * @param webManagerVO  网站管理人员信息
	 * @param oldPassword   旧的密码
	 * @param newPassword   需要设置的新的密码
	 * @return              修改密码是否成功
	 */
	public boolean modify(WebManagerVO webManagerVO,String oldPassword,String newPassword);

}
