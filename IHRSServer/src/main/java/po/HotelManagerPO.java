package po;

/**
 * id                酒店管理人员编号
 * hotelManagerName  用户名
 * phone             手机号
 * hotelId           所在酒店编号
 */
public class HotelManagerPO extends UserPO{

	private static final long serialVersionUID = -4230667772067726163L;
	
	
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
	
	@Override
	public boolean equals(Object o) {
        HotelManagerPO hotelManagerPO = (HotelManagerPO) o;
		return (hotelManagerPO.getId()==getId() && hotelManagerPO.getHotelId()==hotelId);
    }
}
