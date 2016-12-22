package vo;

import po.WebManagerPO;

/**
 * id              网站管理人员编号
 * webManagerName  网站管理人员名
 * phone           手机号
 */
public class WebManagerVO extends UserVO{
	
	public WebManagerVO(int id,String webManagerName,String phone){
		super(id, webManagerName, phone);
	}
	
	public WebManagerVO(WebManagerPO webManagerPO) {
		super(webManagerPO.getId(), webManagerPO.getUserName(), webManagerPO.getPhone());
	}
	
	
}
