package businesslogic.promotionbl;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.promotionbl.NormalVipPromotionBlServiceImpl;
import rmi.RemoteHelper;
import vo.promotionVO.NormalVipPromotionVO;

public class NormalVipPromotionBlServiceImplTest {


	
	
	
	@BeforeClass
	public static  void linkToServer(){
	    RemoteHelper remoteHelper;
		remoteHelper=RemoteHelper.getInstance();
		try {
			remoteHelper.setCreditChangeDao(Naming.lookup("rmi://localhost:6666/CreditChangeDao"));
			remoteHelper.setCustomerDao(Naming.lookup("rmi://localhost:6666/CustomerDao"));
			remoteHelper.setEnterpriseVipDao(Naming.lookup("rmi://localhost:6666/EnterpriseVipDao"));
			remoteHelper.setEvaluateDao(Naming.lookup("rmi://localhost:6666/EvaluateDao"));
			remoteHelper.setHotelDao(Naming.lookup("rmi://localhost:6666/HotelDao"));
			remoteHelper.setHotelManagerDao(Naming.lookup("rmi://localhost:6666/HotelManagerDao"));
			remoteHelper.setListDao(Naming.lookup("rmi://localhost:6666/ListDao"));
			remoteHelper.setNormalVipDao(Naming.lookup("rmi://localhost:6666/NormalVipDao"));
			remoteHelper.setRoomDao(Naming.lookup("rmi://localhost:6666/RoomDao"));
			remoteHelper.setWebManagerDao(Naming.lookup("rmi://localhost:6666/WebManagerDao"));
			remoteHelper.setWebSaleDao(Naming.lookup("rmi://localhost:6666/WebSaleDao"));
			remoteHelper.setHotelPromotionDao(Naming.lookup("rmi://localhost:6666/HotelPromotionDao"));
			remoteHelper.setWebPromotionDao(Naming.lookup("rmi://localhost:6666/WebPromotionDao"));
			remoteHelper.setNormalVipPromotionDao(Naming.lookup("rmi://localhost:6666/NormalVipPromotionDao"));
			remoteHelper.setAddressDao(Naming.lookup("rmi://localhost:6666/AddressDao"));
			remoteHelper.setRankSystemDao(Naming.lookup("rmi://localhost:6666/RankSystemDao"));
			remoteHelper.setPassword(Naming.lookup("rmi://localhost:6666/PasswordDao"));
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void getNormalVipPromotionsTest(){
		
		ArrayList<NormalVipPromotionVO> list;
		NormalVipPromotionBlServiceImpl NormalVipPromotionBlServiceImpl=new NormalVipPromotionBlServiceImpl();
		list=NormalVipPromotionBlServiceImpl.getNormalVipPromotions(1);
		assertEquals(1.0,list.get(0).getDiscount(),0.0);
		assertEquals("11",list.get(0).getDiscountName());
		assertEquals(1,list.get(0).getRankValue());
		assertEquals("111",list.get(0).getBusinessDistrict());
		
	}
	
	
	
	@Test
	public void addNormalVipPromotionTest(){
		NormalVipPromotionVO normalVipPromotionVO=new NormalVipPromotionVO(1.0,"11",1,"111");
		NormalVipPromotionBlServiceImpl NormalVipPromotionBlServiceImpl=new NormalVipPromotionBlServiceImpl();
		assertEquals(true,NormalVipPromotionBlServiceImpl.addNormalVipPromotion(normalVipPromotionVO));
		
		
		
	}
	

	@Test
	public void updateNormalVipPromotionTest(){
		NormalVipPromotionVO normalVipPromotionVO=new NormalVipPromotionVO(1.0,"11",1,"111");
		NormalVipPromotionBlServiceImpl NormalVipPromotionBlServiceImpl=new NormalVipPromotionBlServiceImpl();
		assertEquals(true,NormalVipPromotionBlServiceImpl.updateNormalVipPromotion(normalVipPromotionVO));
		
		
		
	}
	
	
	
	@Test
	public void deleteNormalVipPromotionTest(){
		NormalVipPromotionVO normalVipPromotionVO=new NormalVipPromotionVO(1.0,"11",1,"111");
		NormalVipPromotionBlServiceImpl NormalVipPromotionBlServiceImpl=new NormalVipPromotionBlServiceImpl();
		assertEquals(true,NormalVipPromotionBlServiceImpl.deleteNormalVipPromotion(normalVipPromotionVO));
		
		
		
	}
	
	@Test
	public void getMinDiscountForNormalVipTest(){
		
		NormalVipPromotionBlServiceImpl NormalVipPromotionBlServiceImpl=new NormalVipPromotionBlServiceImpl();
		assertEquals(1.0,NormalVipPromotionBlServiceImpl.getMinDiscountForNormalVip(11, 1),0.0);
		
		
		
	}
	
	
	
	
	
	
}
