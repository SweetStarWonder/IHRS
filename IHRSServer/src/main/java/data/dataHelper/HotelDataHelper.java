package data.dataHelper;

import java.util.HashMap;

import po.HotelPO;

public interface HotelDataHelper {

	public HashMap<Integer, HotelPO> getHotelData();
	
	public void updateHotelData(HashMap<Integer, HotelPO> hotelDataMap);
}
