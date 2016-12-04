package vo;

import po.WebSalePO;

public class WebSaleVO extends UserVO{
	
	public WebSaleVO(int id,String webSaleName,String phone){
		super(id, webSaleName, phone);
	}
	
	public WebSaleVO(WebSalePO webSalePO) {
		super(webSalePO.getId(), webSalePO.getUserName(), webSalePO.getPhone());
	}
}
