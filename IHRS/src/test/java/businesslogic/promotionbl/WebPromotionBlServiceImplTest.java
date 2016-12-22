package businesslogic.promotionbl;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.promotionbl.WebPromotionBlServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;

import rmi.RemoteHelper;
import vo.promotionVO.WebPromotionVO;

public class WebPromotionBlServiceImplTest {

	
	WebPromotionBlServiceImpl WebPromotionBlServiceImpl=new WebPromotionBlServiceImpl();
	WebPromotionVO webPromotionVO=new WebPromotionVO(1.0,"1","11","111");
	
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
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	
	@Test
	public void getWebPromotionsTest(){
		ArrayList<WebPromotionVO> list=new ArrayList<WebPromotionVO>();
		list=WebPromotionBlServiceImpl.getWebPromotions();
		WebPromotionVO WebPromotionVO=list.get(0);

		assertEquals(1.0,WebPromotionVO.getDiscount(),0.0);
		assertEquals("1",WebPromotionVO.getDiscountName());
		assertEquals("11",WebPromotionVO.getStartTime());
		assertEquals("111",WebPromotionVO.getEndTime());
	}
	
	@Test
	public void addWebPromoitonTest(){
		assertEquals(true,WebPromotionBlServiceImpl.addWebPromotion(webPromotionVO));
	}
	
	@Test
	public void deleteWebPromoitonTest(){
		assertEquals(true,WebPromotionBlServiceImpl.deleteWebPromotion(webPromotionVO));
	}
	
	@Test 
	public void getMinDiscountInWebTest(){
		assertEquals(1.0,WebPromotionBlServiceImpl.getMinDiscountInWeb("1111"),0.0);
	}
	
}
