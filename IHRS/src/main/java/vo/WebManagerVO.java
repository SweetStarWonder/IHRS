package vo;

import po.WebManagerPO;

public class WebManagerVO extends UserVO{
	
	public WebManagerVO(int id,String webManagerName,String phone){
		super(id, webManagerName, phone);
	}
	
	public WebManagerVO(WebManagerPO webManagerPO) {
		super(webManagerPO.getId(), webManagerPO.getUserName(), webManagerPO.getPhone());
	}
}
