package vo;

public class HotelManagerVO extends UserVO{
	
	private int hotelId;
	
	public HotelManagerVO(int id,String hotelManagerName,String phone,int hotelId){
		super(id, hotelManagerName, phone);
		this.setHotelId(hotelId);
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
}
