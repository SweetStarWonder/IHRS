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
	
	/**
	 * @param hotelManagerName  需要添加的酒店工作人员名
	 * @param password          为添加的酒店工作人员设置密码
	 * @param phone             手机
	 * @param hotelId           所在酒店名
	 * @return                  是否添加成功
	 */
	public boolean add(String hotelManagerName,String password,String phone,int hotelId);
	
}
