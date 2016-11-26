package data.dataHelper;

import java.util.HashMap;

import po.HotelManagerPO;

public interface HotelManagerDataHelper {
	
	public HashMap<Integer, HotelManagerPO> getHotelManagerData();
		
	public void updateHotelManagerData(HashMap<Integer, HotelManagerPO> hotelManagerDataMap);
}
