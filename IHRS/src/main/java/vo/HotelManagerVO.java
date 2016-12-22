package vo;

import po.HotelManagerPO;

/**
 * id                酒店管理人员编号
 * hotelManagerName  用户名
 * phone             手机号
 * hotelId           所在酒店编号
 */
public class HotelManagerVO extends UserVO{
	
	private int hotelId;
	
	public HotelManagerVO(int id,String hotelManagerName,String phone,int hotelId){
		super(id, hotelManagerName, phone);
		this.setHotelId(hotelId);
	}
	
	public HotelManagerVO(HotelManagerPO hotelManagerPO) {
		super(hotelManagerPO.getId(), hotelManagerPO.getUserName(), hotelManagerPO.getPhone());
		this.hotelId = hotelManagerPO.getHotelId();
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	
}
