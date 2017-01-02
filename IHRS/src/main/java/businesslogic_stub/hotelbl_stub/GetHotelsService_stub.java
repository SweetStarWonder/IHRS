package businesslogic_stub.hotelbl_stub;

import java.util.ArrayList;
import java.util.HashMap;

import businesslogicservice.hotelblservice.GetHotelsService;
import po.HotelPO;
import po.RoomStatus;
import vo.HotelVO;

public class GetHotelsService_stub implements GetHotelsService{

	@Override
	public HashMap<Integer, HotelVO> getReservedHotels() {
		// TODO Auto-generated method stub
		HashMap<Integer, HotelVO> hashMap = new HashMap<>();
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner");
		HotelPO hotelPO = new HotelPO(2222, partners, "hotelName", "position", "businessDistrict", 5, "introduction", "facility");
		HotelVO hotelVO = new HotelVO(hotelPO);
		hashMap.put(2222, hotelVO);
		return hashMap;
	}

	@Override
	public HashMap<Integer, HotelVO> searchHotels(String address, String businessDistrict, String hotelName,
			int roomNum, int lowValue, int highValue, int starRating, RoomStatus roomStatus, int lowPrice,
			int highPrice, boolean ifReserved) {
		// TODO Auto-generated method stub
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner");
		HotelPO hotelPO = new HotelPO(2222, partners, hotelName, "position", businessDistrict, 5, "introduction", "facility");
		HotelVO hotelVO = new HotelVO(hotelPO);
		HashMap<Integer, HotelVO> hashMap = new HashMap<>();
		hashMap.put(2222, hotelVO);
		return hashMap;
	}

	@Override
	public HotelVO getHotel(int hotelId) {
		// TODO Auto-generated method stub
		return null;
	}

}
