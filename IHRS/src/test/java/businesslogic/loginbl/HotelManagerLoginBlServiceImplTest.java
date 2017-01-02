package businesslogic.loginbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import po.HotelManagerPO;
import rmi.RemoteHelper;
import vo.HotelManagerVO;

public class HotelManagerLoginBlServiceImplTest {

	@BeforeClass
	public static void linkToServer() {
		RemoteHelper remoteHelper;
		remoteHelper = RemoteHelper.getInstance();
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
		HotelManagerLoginBlServiceImpl hotelManagerLoginBlServiceImpl = new HotelManagerLoginBlServiceImpl();
		assertEquals(00003,
				hotelManagerLoginBlServiceImpl.login(00003, "HotelManagerName", "HotelManagerpassword").getId());
		assertEquals(00003,
				hotelManagerLoginBlServiceImpl.login(0, "HotelManagerName", "HotelManagerpassword").getId());
		assertEquals(00003, hotelManagerLoginBlServiceImpl.login(00003, null, "HotelManagerpassword").getId());
	}

	@Test
	public void testmodify() {
		HotelManagerLoginBlServiceImpl hotelManagerLoginBlServiceImpl = new HotelManagerLoginBlServiceImpl();
		HotelManagerPO hotelManagerPO = new HotelManagerPO(00003, "HotelManagerName", "HotelManagerphone", 2222);
		HotelManagerVO hotelManagerVO = new HotelManagerVO(hotelManagerPO);
		assertEquals(true, hotelManagerLoginBlServiceImpl.modify(hotelManagerVO, "HotelManagerpassword",
				"newHotelManagerPassword"));
		assertEquals(false, hotelManagerLoginBlServiceImpl.modify(hotelManagerVO, "HotelManagerpassword",
				"newHotelManagerPassword"));
		assertEquals(true, hotelManagerLoginBlServiceImpl.modify(hotelManagerVO, "newHotelManagerPassword",
				"HotelManagerpassword"));
	}
}
