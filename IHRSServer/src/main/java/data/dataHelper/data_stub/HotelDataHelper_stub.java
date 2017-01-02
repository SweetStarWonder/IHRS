package data.dataHelper.data_stub;

import java.util.ArrayList;
import java.util.HashMap;

import data.dataHelper.HotelDataHelper;
import po.HotelPO;

public class HotelDataHelper_stub implements HotelDataHelper{

	@Override
	public HashMap<Integer, HotelPO> getHotelData() {
		// TODO Auto-generated method stub
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner");
		HotelPO hotelPO = new HotelPO(2222, partners, "hotelName", "position", "businessDistrict", 5, "introduction", "facility");
		HashMap<Integer, HotelPO> hashMap = new HashMap<>();
		hashMap.put(2222, hotelPO);
		return hashMap;
	}

	@Override
	public void updateHotelData(HashMap<Integer, HotelPO> hotelDataMap) {
		// TODO Auto-generated method stub
		
	}

}
