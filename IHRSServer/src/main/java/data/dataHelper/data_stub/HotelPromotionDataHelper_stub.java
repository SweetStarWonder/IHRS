package data.dataHelper.data_stub;

import java.util.ArrayList;
import java.util.HashMap;

import data.dataHelper.HotelPromotionDataHelper;
import po.promotionPO.HotelPromotionPO;
import po.promotionPO.HotelPromotionType;

public class HotelPromotionDataHelper_stub implements HotelPromotionDataHelper{

	@Override
	public HashMap<Integer, ArrayList<HotelPromotionPO>> getHotelPromotionData() {
		// TODO Auto-generated method stub
		ArrayList<HotelPromotionPO> arrayList = new ArrayList<>();
		HotelPromotionPO hotelPromotionPO = new HotelPromotionPO(0.5, "discountName", 2222, HotelPromotionType.BIRTHDAY, "2016/10/01 00:00:00", "2016/10/01 23:59:59");
		arrayList.add(hotelPromotionPO);
		HashMap<Integer, ArrayList<HotelPromotionPO>> hashMap = new HashMap<>();
		hashMap.put(2222, arrayList);
		return hashMap;
	}

	@Override
	public void updateHotelPromotionData(HashMap<Integer, ArrayList<HotelPromotionPO>> hotelPromotions) {
		// TODO Auto-generated method stub
		
	}

}
