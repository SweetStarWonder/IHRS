package businesslogic_stub.loginbl_stub;

import businesslogicservice.loginblservice.WebSaleLoginBlService;
import vo.WebSaleVO;

public class WebSaleLoginBlService_stub implements WebSaleLoginBlService{

	@Override
	public WebSaleVO login(int webSaleId, String webSaleName, String password) {
		// TODO Auto-generated method stub
		return new WebSaleVO(webSaleId, webSaleName, "phone");
	}

	@Override
	public boolean modify(WebSaleVO webSaleVO, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean add(String webSaleName, String password, String phone) {
		// TODO Auto-generated method stub
		return true;
	}

}
