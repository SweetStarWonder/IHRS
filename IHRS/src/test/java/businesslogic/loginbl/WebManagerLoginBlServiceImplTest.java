package businesslogic.loginbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import po.WebManagerPO;
import rmi.RemoteHelper;
import vo.WebManagerVO;

public class WebManagerLoginBlServiceImplTest {

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
		WebManagerLoginBlServiceImpl webManagerLoginBlServiceImpl = new WebManagerLoginBlServiceImpl();
		assertEquals(00005, webManagerLoginBlServiceImpl.login(00005, "WebManagerName", "WebManagerpassword").getId());
		assertEquals(00005, webManagerLoginBlServiceImpl.login(00005, null, "WebManagerpassword").getId());
		assertEquals(00005, webManagerLoginBlServiceImpl.login(0, "WebManagerName", "WebManagerpassword").getId());
		assertEquals(null, webManagerLoginBlServiceImpl.login(0, null, null));
		assertEquals(null, webManagerLoginBlServiceImpl.login(00004, null, "WebManagerpassword"));
		assertEquals(null, webManagerLoginBlServiceImpl.login(0, "webMangerName", "WebManagerpassword"));
	}

	@Test
	public void testmodify() {
		WebManagerPO webManagerPO = new WebManagerPO(00005, "WebManagerName", "WebManagerphone");
		WebManagerVO webManagerVO = new WebManagerVO(webManagerPO);
		WebManagerLoginBlServiceImpl webManagerLoginBlServiceImpl = new WebManagerLoginBlServiceImpl();
		assertEquals(true,
				webManagerLoginBlServiceImpl.modify(webManagerVO, "WebManagerpassword", "newWebManagerpassword"));
		assertEquals(false,
				webManagerLoginBlServiceImpl.modify(webManagerVO, "WebManagerpassword", "newWebManagerpassword"));
		assertEquals(true,
				webManagerLoginBlServiceImpl.modify(webManagerVO, "newWebManagerpassword", "WebManagerpassword"));
	}
}
