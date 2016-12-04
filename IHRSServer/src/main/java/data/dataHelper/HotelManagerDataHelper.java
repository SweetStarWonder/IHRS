package data.dataHelper;

import java.util.HashMap;

import po.HotelManagerPO;

public interface HotelManagerDataHelper {
	
	public HashMap<Integer, HotelManagerPO> getHotelManagerData();  //左边是hotelId
		
	public void updateHotelManagerData(HashMap<Integer, HotelManagerPO> hotelManagerDataMap);
}
