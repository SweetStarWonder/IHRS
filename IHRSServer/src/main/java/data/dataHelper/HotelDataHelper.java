package data.dataHelper;

import java.util.HashMap;

import po.HotelPO;

public interface HotelDataHelper {

	/**
	 * @return  酒店信息（左酒店编号）
	 */
	public HashMap<Integer, HotelPO> getHotelData();
	
	/**
	 * @param hotelDataMap  酒店信息（左酒店编号）
	 */
	public void updateHotelData(HashMap<Integer, HotelPO> hotelDataMap);
	
}
