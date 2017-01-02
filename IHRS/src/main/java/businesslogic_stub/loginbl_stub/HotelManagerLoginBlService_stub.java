package businesslogic_stub.loginbl_stub;

import businesslogicservice.loginblservice.HotelManagerLoginBlService;
import vo.HotelManagerVO;

public class HotelManagerLoginBlService_stub implements HotelManagerLoginBlService{

	@Override
	public HotelManagerVO login(int hotelManagerId, String hotelManagerName, String password) {
		// TODO Auto-generated method stub
		return new HotelManagerVO(hotelManagerId, hotelManagerName, "phone", 2222);
	}

	@Override
	public boolean modify(HotelManagerVO hotelManagerVO, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean add(String hotelManagerName, String password, String phone, int hotelId) {
		// TODO Auto-generated method stub
		return true;
	}

}
