package data.dao;

import java.util.ArrayList;

import po.HotelPO;
import po.RoomPO;

public interface HotelDao {
	
	public ArrayList<HotelPO> getHotelsByStarRating(String position,String businessDistrict);
	
	public ArrayList<HotelPO> getHotelsByRankValue(String position,String businessDistrict,int lowValue,int highValue);
	
	public ArrayList<HotelPO> getHotelsByName(String position,String businessDistrict,String hotelName);
	
	public ArrayList<HotelPO> getHotelByRoom(String position,String businessDistrict,RoomPO roomPO);
	
	public boolean addHotel(HotelPO hotelPO);
	
	public boolean update(HotelPO hotelPO);
}
