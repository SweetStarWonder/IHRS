package businesslogic.userbl;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import vo.WebSaleVO;
import vo.HotelManagerVO;
import vo.CustomerVO;
import rmi.RemoteHelper;
import businesslogic.userbl.FindUserServiceImpl;;
public class FindUserServiceImplTest {

	
	FindUserServiceImpl FindUserServiceImpl=new FindUserServiceImpl();
	CustomerVO CustomerVO;
	HotelManagerVO HotelManagerVO;
	WebSaleVO WebSaleVO;
	CustomerVO CustomerVOTest=new CustomerVO(1,"1","11");
	HotelManagerVO HotelManagerVOTest=new HotelManagerVO(1,"1","11",11);
	WebSaleVO WebSaleVOTest=new WebSaleVO(1,"1","11");

	
	
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
	public void getCustomerTestByIdTest(){
		assertEquals(1,FindUserServiceImpl.getCustomer(1).getId());
		assertEquals("1",FindUserServiceImpl.getCustomer(1).getUserName());
		assertEquals("11",FindUserServiceImpl.getCustomer(1).getPhone());
	}
	
	
	@Test
	public void getCustomerTestByNameTest(){
		assertEquals(1,FindUserServiceImpl.getCustomer("1").getId());
		assertEquals("1",FindUserServiceImpl.getCustomer("1").getUserName());
		assertEquals("11",FindUserServiceImpl.getCustomer("1").getPhone());
	}
	
	@Test
	public void getHotelManagerByUserIdTest(){
		assertEquals(1,FindUserServiceImpl.getHotelManagerByUserId(1).getId());
		assertEquals("1",FindUserServiceImpl.getHotelManagerByUserId(1).getUserName());
		assertEquals("11",FindUserServiceImpl.getHotelManagerByUserId(1).getPhone());
		assertEquals(11,FindUserServiceImpl.getHotelManagerByUserId(1).getHotelId());
	}
	
	@Test
	public void getHotelManagerByUserHotelIdTest(){
		assertEquals(1,FindUserServiceImpl.getHotelManagerByHotelId(11).getId());
		assertEquals("1",FindUserServiceImpl.getHotelManagerByHotelId(11).getUserName());
		assertEquals("11",FindUserServiceImpl.getHotelManagerByHotelId(11).getPhone());
		assertEquals(11,FindUserServiceImpl.getHotelManagerByHotelId(11).getHotelId());
	}
	
	@Test 
	public void getWebSaleTest(){
		assertEquals(1,FindUserServiceImpl.getWebSale(1).getId());
		assertEquals("1",FindUserServiceImpl.getWebSale(1).getUserName());
		assertEquals("1",FindUserServiceImpl.getWebSale(1).getPhone());

	}
	
	
	
	
}
