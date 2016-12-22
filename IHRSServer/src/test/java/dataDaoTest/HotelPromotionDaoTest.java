package dataDaoTest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.impl.HotelPromotionDaoImpl;
import po.promotionPO.HotelPromotionPO;
import po.promotionPO.HotelPromotionType;

public class HotelPromotionDaoTest {

	


		HotelPromotionType type=HotelPromotionType.BIRTHDAY;
		HotelPromotionPO HotelPromotionPO=new HotelPromotionPO(1.0,"111",111,type,"1","11");
		
		@Test
		public void testAddHotelPromotion()  throws Exception{
			
			HotelPromotionDaoImpl HotelPromotion = HotelPromotionDaoImpl.getInstance();
			
			assertEquals(true,HotelPromotion.addHotelPromotion(HotelPromotionPO));
			
		}
		
		
		@Test
		public void testGetHotelPromotions()throws RemoteException{
			
			HotelPromotionDaoImpl HotelPromotion = HotelPromotionDaoImpl.getInstance();
			ArrayList<HotelPromotionPO> list = new ArrayList<HotelPromotionPO>(); 
			list=HotelPromotion.getHotelPromotions(111);
			HotelPromotionPO HotelPromotionPOtest=list.get(0);
			
			assertEquals(1.0,HotelPromotionPOtest.getDiscount(),0.0);
			assertEquals("111",HotelPromotionPOtest.getDiscountName());
			assertEquals(111,HotelPromotionPOtest.getHotelId());
			assertEquals(type,HotelPromotionPOtest.getHotelPromotionType());
			assertEquals("1",HotelPromotionPOtest.getStartTime());
			assertEquals("11",HotelPromotionPOtest.getEndTime());


			
		}
		
		@Test
		public void testDeleteHotelPromotion() throws RemoteException{
			
			HotelPromotionDaoImpl HotelPromotion = HotelPromotionDaoImpl.getInstance();
			assertEquals(false,HotelPromotion.deleteHotelPromotion(HotelPromotionPO));
		}
}
