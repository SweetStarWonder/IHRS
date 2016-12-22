package vo;

import po.WebSalePO;

/**
 * id              网站营销人员编号
 * webManagerName  网站营销人员名
 * phone           手机号
 */
public class WebSaleVO extends UserVO{
	
	public WebSaleVO(int id,String webSaleName,String phone){
		super(id, webSaleName, phone);
	}
	
	public WebSaleVO(WebSalePO webSalePO) {
		super(webSalePO.getId(), webSalePO.getUserName(), webSalePO.getPhone());
	}
	
	
}
