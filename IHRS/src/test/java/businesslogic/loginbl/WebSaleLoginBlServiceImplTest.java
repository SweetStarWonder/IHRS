package businesslogic.loginbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import po.WebSalePO;
import rmi.RemoteHelper;
import vo.WebSaleVO;

public class WebSaleLoginBlServiceImplTest {

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
		WebSaleLoginBlServiceImpl webSaleLoginBlServiceImpl = new WebSaleLoginBlServiceImpl();
		assertEquals(00006, webSaleLoginBlServiceImpl.login(00006, "WebSaleName", "WebSalepassword").getId());
		assertEquals(00006, webSaleLoginBlServiceImpl.login(00006, null, "WebSalepassword").getId());
		assertEquals(00006, webSaleLoginBlServiceImpl.login(0, "WebSaleName", "WebSalepassword").getId());
		assertEquals(null, webSaleLoginBlServiceImpl.login(0, null, null));
		assertEquals(null, webSaleLoginBlServiceImpl.login(0, "WebSaleName", "WebSalepassword1"));
		assertEquals(null, webSaleLoginBlServiceImpl.login(00006, null, "WebSalepassword1"));
		assertEquals(null, webSaleLoginBlServiceImpl.login(0, "WebSaleName", null));

	}

	@Test
	public void testmodify() {
		WebSalePO webSalePO = new WebSalePO(00006, "WebSaleName", "WebSalephone");
		WebSaleVO webSaleVO = new WebSaleVO(webSalePO);
		WebSaleLoginBlServiceImpl webSaleLoginBlServiceImpl = new WebSaleLoginBlServiceImpl();
		assertEquals(true, webSaleLoginBlServiceImpl.modify(webSaleVO, "WebSalepassword", "newWebSalepassword"));
		assertEquals(false, webSaleLoginBlServiceImpl.modify(webSaleVO, "WebSalepassword", "newWebSalepassword"));
		assertEquals(true, webSaleLoginBlServiceImpl.modify(webSaleVO, "newWebSalepassword", "WebSalepassword"));
	}
}
