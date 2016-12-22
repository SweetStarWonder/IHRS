package dataDaoTest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.impl.WebPromotionDaoImpl;
import po.promotionPO.WebPromotionPO;

public class WebPromotionDaoTest {

	

	WebPromotionPO WebPromotionPO=new WebPromotionPO(1.0,"111","111","111");
	
	@Test
	public void testAddWebPromotion()  throws Exception{
		
		WebPromotionDaoImpl WebPromotion = WebPromotionDaoImpl.getInstance();
		
		assertEquals(true,WebPromotion.addWebPromotion(WebPromotionPO));
		
	}
	
	
	@Test
	public void testGetWebPromotions()throws RemoteException{
		
		WebPromotionDaoImpl WebPromotion = WebPromotionDaoImpl.getInstance();
		ArrayList<WebPromotionPO> list = new ArrayList<WebPromotionPO>(); 
		list=WebPromotion.getWebPromotions();
		WebPromotionPO WebPromotionPO=list.get(0);
		
		assertEquals(1.0,WebPromotionPO.getDiscount(),0.0);
		assertEquals("111",WebPromotionPO.getDiscountName());
		assertEquals("111",WebPromotionPO.getStartTime());
		assertEquals("111",WebPromotionPO.getEndTime());


		
	}
	
	@Test
	public void testDeleteWebPromotion() throws RemoteException{
		
		WebPromotionDaoImpl WebPromotion = WebPromotionDaoImpl.getInstance();
		assertEquals(false,WebPromotion.deleteWebPromotion(WebPromotionPO));
	}
	

}

