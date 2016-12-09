package data.dataHelper;

import java.util.ArrayList;
import java.util.HashMap;

import po.promotionPO.HotelPromotionPO;

public interface HotelPromotionDataHelper {
	
	public HashMap<Integer, ArrayList<HotelPromotionPO>> getHotelPromotionData();
	
	public void updateHotelPromotionData(HashMap<Integer, ArrayList<HotelPromotionPO>> hotelPromotions);

}
