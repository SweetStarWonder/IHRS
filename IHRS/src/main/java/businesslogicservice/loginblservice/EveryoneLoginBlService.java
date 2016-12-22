package businesslogicservice.loginblservice;

import vo.UserVO;

public interface EveryoneLoginBlService {
	
	/**
	 * @param userId    用户编号
	 * @param userName  用户名
	 * @param password  用户密码
	 * @return          用户登录（登录只需调用这一个方法）
	 */
	public UserVO login(int userId,String userName,String password);

}
