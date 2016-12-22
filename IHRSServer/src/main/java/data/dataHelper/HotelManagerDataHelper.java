package data.dataHelper;

import java.util.HashMap;

import po.HotelManagerPO;

public interface HotelManagerDataHelper {
	
	/**
	 * @return  酒店工作人员信息（左酒店工作人员编号）
	 */
	public HashMap<Integer, HotelManagerPO> getHotelManagerData();  //左边是hotelId
		
	/**
	 * @param hotelManagerDataMap  酒店工作人员信息（左酒店工作人员编号）
	 */
	public void updateHotelManagerData(HashMap<Integer, HotelManagerPO> hotelManagerDataMap);
	
}
