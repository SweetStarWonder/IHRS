package businesslogic_stub.loginbl_stub;

import businesslogicservice.loginblservice.EveryoneLoginBlService;
import vo.UserVO;

public class EveryoneLoginBlService_stub implements EveryoneLoginBlService{

	@Override
	public UserVO login(int userId, String userName, String password) {
		// TODO Auto-generated method stub
		return new UserVO(userId, userName, "phone");
	}

	@Override
	public boolean modify(int userId, String newUserName) {
		// TODO Auto-generated method stub
		return true;
	}

}
