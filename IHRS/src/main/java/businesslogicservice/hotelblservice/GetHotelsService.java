package businesslogicservice.hotelblservice;

import java.util.HashMap;

import po.RoomStatus;
import vo.HotelVO;

public interface GetHotelsService {
	
	public HashMap<Integer,HotelVO> getReservedHotels();  //获取已预订酒店列表
	
	public HashMap<Integer,HotelVO> searchHotels(String address,String businessDistrict,String hotelName,int roomNum,
			int lowValue,int highValue,int starRating,RoomStatus roomStatus,int lowPrice,int highPrice,boolean ifReserved);  //按类搜索酒店，获取酒店列表
	
}
