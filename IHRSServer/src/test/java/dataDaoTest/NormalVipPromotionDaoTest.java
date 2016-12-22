package dataDaoTest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.impl.NormalVipPromotionDaoImpl;
import po.promotionPO.NormalVipPromotionPO;

public class NormalVipPromotionDaoTest {

	

	
	NormalVipPromotionPO NormalVipPromotionPO=new NormalVipPromotionPO(1.0,"111",111,"111");
	
	@Test
	public void testAddNormalVipPromotion()  throws Exception{
		
		NormalVipPromotionDaoImpl NormalVipPromotion = NormalVipPromotionDaoImpl.getInstance();
		
		assertEquals(true,NormalVipPromotion.addNormalVipPromotion(NormalVipPromotionPO));
		
	}
	
	@Test
	public void testUpdateNormalVipPromotion()  throws Exception{
		
		NormalVipPromotionDaoImpl NormalVipPromotion = NormalVipPromotionDaoImpl.getInstance();
		
		assertEquals(false,NormalVipPromotion.updateNormalVipPromotion(NormalVipPromotionPO));
		
	}
	
	@Test
	public void testGetNormalVipPromotions()throws RemoteException{
		
		NormalVipPromotionDaoImpl NormalVipPromotion = NormalVipPromotionDaoImpl.getInstance();
		ArrayList<NormalVipPromotionPO> list = new ArrayList<NormalVipPromotionPO>(); 
		list=NormalVipPromotion.getNormalVipPromotions(111);
		NormalVipPromotionPO NormalVipPromotionPOtest=list.get(0);
		
		assertEquals(1.0,NormalVipPromotionPOtest.getDiscount(),0.0);
		assertEquals("111",NormalVipPromotionPOtest.getDiscountName());
		assertEquals(111,NormalVipPromotionPOtest.getRankValue());
		assertEquals("111",NormalVipPromotionPOtest.getBusinessDistrict());


		
	}
	
	@Test
	public void testDeleteNormalVipPromotion() throws RemoteException{
		
		NormalVipPromotionDaoImpl NormalVipPromotion = NormalVipPromotionDaoImpl.getInstance();
		assertEquals(false,NormalVipPromotion.deleteNormalVipPromotion(NormalVipPromotionPO));
	}
	
	
	

}

