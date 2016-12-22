package data.dataHelper;

import java.util.ArrayList;
import java.util.HashMap;

import po.promotionPO.HotelPromotionPO;

public interface HotelPromotionDataHelper {
	
	/**
	 * @return  酒店所有促销策略（左酒店编号）
	 */
	public HashMap<Integer, ArrayList<HotelPromotionPO>> getHotelPromotionData();
	
	/**
	 * @param hotelPromotions  酒店所有促销策略（左酒店编号）
	 */
	public void updateHotelPromotionData(HashMap<Integer, ArrayList<HotelPromotionPO>> hotelPromotions);

}
