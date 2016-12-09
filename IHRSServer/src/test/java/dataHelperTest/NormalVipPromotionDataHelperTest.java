package dataHelperTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.NormalVipPromotionDataTxtHelper;
import po.promotionPO.NormalVipPromotionPO;


public class NormalVipPromotionDataHelperTest {

    static NormalVipPromotionDataTxtHelper NormalVipPromotion = new NormalVipPromotionDataTxtHelper();
	
	@BeforeClass
	public static void tesUpdatetNormalVipPromotionDataHelper(){
		
       
		NormalVipPromotionPO NormalVipPromotionPO = new NormalVipPromotionPO(11.0,"1234",11,"1234");
		ArrayList<NormalVipPromotionPO> list = new ArrayList<NormalVipPromotionPO>(); 
		list.add(NormalVipPromotionPO);
		NormalVipPromotion.updateNormalVipPromotionData(list);
		
	}
	
	@Test
	public void testGetWebPromotionData(){
		
		NormalVipPromotionPO NormalVipPromotionPO = NormalVipPromotion.getNormalVipPromotionData().get(0);
		assertEquals(11.0,NormalVipPromotionPO.getDiscount(),0.0);
		assertEquals("1234",NormalVipPromotionPO.getDiscountName());
		assertEquals(11,NormalVipPromotionPO.getRankValue());
		assertEquals("1234",NormalVipPromotionPO.getBusinessDistrict());
		
	}
}
