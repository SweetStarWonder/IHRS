package dataHelperTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.WebPromotionDataTxtHelper;
import po.promotionPO.WebPromotionPO;

public class WebPromotionDataHelperTest {
	
    static WebPromotionDataTxtHelper WebPromotion = new WebPromotionDataTxtHelper();
	
	@BeforeClass
	public static void tesUpdatetWebPromotionDataHelper(){
		
       
        WebPromotionPO WebPromotionpo = new WebPromotionPO(11.0,"1234","1234","1234");
		ArrayList<WebPromotionPO> list = new ArrayList<WebPromotionPO>(); 
		list.add(WebPromotionpo);
		WebPromotion.updateWebPromotionData(list);
		
	}
	
	@Test
	public void testGetWebPromotionData(){
		
		WebPromotionPO WebPromotionPO = WebPromotion.getWebPromotionData().get(0);
		assertEquals(11.0,WebPromotionPO.getDiscount(),0.0);
		assertEquals("1234",WebPromotionPO.getDiscountName());
		assertEquals("1234",WebPromotionPO.getStartTime());
		assertEquals("1234",WebPromotionPO.getEndTime());
		
	}

}
