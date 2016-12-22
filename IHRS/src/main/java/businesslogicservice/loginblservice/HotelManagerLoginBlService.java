package businesslogicservice.loginblservice;

import vo.HotelManagerVO;

public interface HotelManagerLoginBlService {
	
	/**
	 * @param hotelManagerId    酒店工作人员编号
	 * @param hotelManagerName  酒店工作人员名
	 * @param password          酒店工作人员密码
	 * @return                  酒店工作人员登录
	 */
	public HotelManagerVO login(int hotelManagerId,String hotelManagerName,String password);
	
	/**
	 * @param hotelManagerVO  酒店工作人员信息
	 * @param oldPassword     旧的密码
	 * @param newPassword     需要设置的新的密码
	 * @return                修改密码是否成功
	 */
	public boolean modify(HotelManagerVO hotelManagerVO,String oldPassword,String newPassword);
	
}