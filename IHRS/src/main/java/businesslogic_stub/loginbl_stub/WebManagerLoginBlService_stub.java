package businesslogic_stub.loginbl_stub;

import businesslogicservice.loginblservice.WebManagerLoginBlService;
import vo.WebManagerVO;

public class WebManagerLoginBlService_stub implements WebManagerLoginBlService{

	@Override
	public WebManagerVO login(int webManagerId, String webManagerName, String password) {
		// TODO Auto-generated method stub
		return new WebManagerVO(webManagerId, webManagerName, "phone");
	}

	@Override
	public boolean modify(WebManagerVO webManagerVO, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}

}
