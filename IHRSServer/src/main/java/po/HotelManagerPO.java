package po;

public class HotelManagerPO extends UserPO{
	
	private int hotelId;
	
	public HotelManagerPO(int id,String hotelManagerName,String phone,int hotelId){
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
