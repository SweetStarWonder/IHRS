package businesslogic.loginbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import po.CustomerPO;
import po.NormalVipPO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.NormalVipVO;

public class NormalVipLoginBlServiceImplTest {

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
		NormalVipLoginBlServiceImpl normalVipLoginBlServiceImpl = new NormalVipLoginBlServiceImpl();
		assertEquals(00004, normalVipLoginBlServiceImpl.login(00004, "NormalVipName", "NormalVippassword").getId());
		assertEquals(00004, normalVipLoginBlServiceImpl.login(0, "NormalVipName", "NormalVippassword").getId());
		assertEquals(00004, normalVipLoginBlServiceImpl.login(00004, null, "NormalVippassword").getId());
		assertEquals(null, normalVipLoginBlServiceImpl.login(00004, "NormalVipName1", "NormalVippassword"));
		assertEquals(null, normalVipLoginBlServiceImpl.login(0, null, "NormalVippassword"));
		assertEquals(null, normalVipLoginBlServiceImpl.login(00004, "NormalVipName", "NormalVippassword1"));
	}

	@Test
	public void testmodify() {
		NormalVipPO normalVipPO = new NormalVipPO(00004, "NormalVipName", "NormalVipphone", 0, "birthday");
		NormalVipVO normalVipVO = new NormalVipVO(normalVipPO);
		NormalVipLoginBlServiceImpl normalVipLoginBlServiceImpl = new NormalVipLoginBlServiceImpl();
		assertEquals(true,
				normalVipLoginBlServiceImpl.modify(normalVipVO, "NormalVippassword", "newNormalVippassword"));
		assertEquals(false,
				normalVipLoginBlServiceImpl.modify(normalVipVO, "NormalVippassword", "newNormalVippassword"));
		assertEquals(true,
				normalVipLoginBlServiceImpl.modify(normalVipVO, "newNormalVippassword", "NormalVippassword"));
	}

	@Test
	public void testupgrade() {
		CustomerPO customerPO1 = new CustomerPO(00001, "userName", "userphone");
		CustomerVO customerVO1 = new CustomerVO(customerPO1);
		CustomerPO customerPO2 = new CustomerPO(00004, "NormalVipName", "NormalVipphone");
		CustomerVO customerVO2 = new CustomerVO(customerPO2);
		NormalVipLoginBlServiceImpl normalVipLoginBlServiceImpl = new NormalVipLoginBlServiceImpl();
		assertEquals(00001, normalVipLoginBlServiceImpl.upgrade(customerVO1, "birthday").getId());
		assertEquals(00004, normalVipLoginBlServiceImpl.upgrade(customerVO2, "birthday").getId());
		// assertEquals(null, normalVipLoginBlServiceImpl.upgrade(customerVO3,
		// "birthday"));
	}
}
