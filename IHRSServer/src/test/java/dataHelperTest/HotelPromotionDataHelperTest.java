package dataHelperTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.HotelPromotionDataTxtHelper;
import po.promotionPO.HotelPromotionPO;
import po.promotionPO.HotelPromotionType;

public class HotelPromotionDataHelperTest {

    static HotelPromotionDataTxtHelper HotelPromotion = new HotelPromotionDataTxtHelper();
	
	@BeforeClass
	public static void testUpdateHotelPromotionDataHelper(){
		
        HotelPromotionType HotelPromotionType=po.promotionPO.HotelPromotionType.BIRTHDAY;
        HotelPromotionPO HotelPromotionPO = new HotelPromotionPO(11.0,"123",123,HotelPromotionType,"1","11");
		ArrayList<HotelPromotionPO> list = new ArrayList<HotelPromotionPO>(); 
		HashMap<Integer, ArrayList<HotelPromotionPO>> map=new HashMap<Integer, ArrayList<HotelPromotionPO>>();
		list.add(HotelPromotionPO);
		map.put(123, list);
		HotelPromotion.updateHotelPromotionData(map);
		
	}
	
	@Test
	public void testgetCreditChangeData(){
		HotelPromotionPO HotelPromotionPO = HotelPromotion.getHotelPromotionData().get(123).get(0);
		HotelPromotionType HotelPromotionType=po.promotionPO.HotelPromotionType.BIRTHDAY;
		
		assertEquals(11.0,HotelPromotionPO.getDiscount(),0.0);
		assertEquals("123",HotelPromotionPO.getDiscountName());
		assertEquals(123,HotelPromotionPO.getHotelId());
		assertEquals(HotelPromotionType,HotelPromotionPO.getHotelPromotionType());
		assertEquals("1",HotelPromotionPO.getStartTime());
		assertEquals("11",HotelPromotionPO.getEndTime());
		
		
		
		
	}
}
