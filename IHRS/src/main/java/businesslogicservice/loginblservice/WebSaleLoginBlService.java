package businesslogicservice.loginblservice;

import vo.WebSaleVO;

public interface WebSaleLoginBlService {
	
	/**
	 * @param webSaleId    网站营销人员编号
	 * @param webSaleName  网站营销人员名
	 * @param password     网站营销人员密码
	 * @return             网站营销人员登录
	 */
	public WebSaleVO login(int webSaleId,String webSaleName,String password);
	
	/**
	 * @param webSaleVO    网站营销人员信息
	 * @param oldPassword  旧的密码
	 * @param newPassword  需要设置的新的密码
	 * @return             修改密码是否成功
	 */
	public boolean modify(WebSaleVO webSaleVO,String oldPassword,String newPassword);
	
}
