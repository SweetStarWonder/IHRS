package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.HotelManagerDataHelper;
import po.HotelManagerPO;

public class HotelManagerDataHelper_stub implements HotelManagerDataHelper{

	@Override
	public HashMap<Integer, HotelManagerPO> getHotelManagerData() {
		// TODO Auto-generated method stub
		HashMap<Integer, HotelManagerPO> hashMap = new HashMap<>();
		HotelManagerPO hotelManagerPO = new HotelManagerPO(00003, "hotelManagerName", "phone", 2222);
		hashMap.put(2222, hotelManagerPO);
		return hashMap;
	}

	@Override
	public void updateHotelManagerData(HashMap<Integer, HotelManagerPO> hotelManagerDataMap) {
		// TODO Auto-generated method stub
		
	}

}
