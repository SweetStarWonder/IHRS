package data.dao;

import po.HotelManagerPO;

public interface HotelManagerDao {
	public HotelManagerPO getHotelManager(int hotelId);
	
	public boolean addHotelManager(HotelManagerPO hotelManagerPO);
	
	public boolean updateHotelManager(HotelManagerPO hotelManagerPO);
}
