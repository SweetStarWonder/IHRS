package businesslogicservice.userblservice;

import java.util.ArrayList;

import vo.ResultMessage;
import vo.UserVO;

public interface UserBLService {
	public ResultMessage login(String userid,String password);
	public boolean modify(UserVO user);
	public ArrayList<UserVO> search(String userid);
	public UserVO getUser(String userid);
}
