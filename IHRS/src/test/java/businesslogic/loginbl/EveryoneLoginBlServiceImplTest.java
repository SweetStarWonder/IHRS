package businesslogic.loginbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import rmi.RemoteHelper;

public class EveryoneLoginBlServiceImplTest {

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
	public void testlogin() {
		EveryoneLoginBlServiceImpl everyoneLoginBlServiceImpl = new EveryoneLoginBlServiceImpl();
		assertEquals(00001, everyoneLoginBlServiceImpl.login(00001, "userName", "userpassword").getId());
		assertEquals(00002, everyoneLoginBlServiceImpl.login(00002, "EnterpriseVipName", "EnterpriseVippassword").getId());
		assertEquals(00003, everyoneLoginBlServiceImpl.login(00003, "HotelManagerName", "HotelManagerpassword").getId());
		assertEquals(00004, everyoneLoginBlServiceImpl.login(00004, "NormalVipName", "NormalVippassword").getId());
		assertEquals(00005, everyoneLoginBlServiceImpl.login(00005, "WebManagerName", "WebManagerpassword").getId());
		assertEquals(00006, everyoneLoginBlServiceImpl.login(00006, "WebSaleName", "WebSalepassword").getId());
		assertEquals(00001, everyoneLoginBlServiceImpl.login(0, "userName", "userpassword").getId());
		assertEquals(00001, everyoneLoginBlServiceImpl.login(00001, null, "userpassword").getId());
		assertEquals(00001, everyoneLoginBlServiceImpl.login(00001, null, "userpassword").getId());
		assertEquals(null, everyoneLoginBlServiceImpl.login(0, null, "userpassword"));
		assertEquals(null, everyoneLoginBlServiceImpl.login(00001, null, "userpassword1"));
		assertEquals(null, everyoneLoginBlServiceImpl.login(00002, null, "userpassword"));
	}

}
