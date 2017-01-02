package businesslogic.loginbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import po.CustomerPO;
import po.EnterpriseVipPO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;

public class EnterpriseVipLoginBlServiceImplTest {

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
		EnterpriseVipLoginBlServiceImpl enterpriseVipLoginBlServiceImpl = new EnterpriseVipLoginBlServiceImpl();
		assertEquals(null, enterpriseVipLoginBlServiceImpl.login(00002, "EnterpriseVipName", "EnterpriseVippassword1"));
		assertEquals(null, enterpriseVipLoginBlServiceImpl.login(0, "EnterpriseVipName", "EnterpriseVippassword1"));
		assertEquals(00002, enterpriseVipLoginBlServiceImpl.login(00002, null, "EnterpriseVippassword").getId());
		assertEquals(00002,
				enterpriseVipLoginBlServiceImpl.login(0, "EnterpriseVipName", "EnterpriseVippassword").getId());
		assertEquals(00002,
				enterpriseVipLoginBlServiceImpl.login(00002, "EnterpriseVipName", "EnterpriseVippassword").getId());
	}

	@Test
	public void testmodify() {
		EnterpriseVipLoginBlServiceImpl enterpriseVipLoginBlServiceImpl = new EnterpriseVipLoginBlServiceImpl();
		EnterpriseVipPO enterpriseVipPO = new EnterpriseVipPO(00002, "EnterpriseVipName", "EnterpriseVipphone",
				"EnterpriseVipName", 0);
		EnterpriseVipVO enterpriseVipVO = new EnterpriseVipVO(enterpriseVipPO);
		assertEquals(true, enterpriseVipLoginBlServiceImpl.modify(enterpriseVipVO, "EnterpriseVippassword",
				"newEnterpriseVippassword"));
		assertEquals(false, enterpriseVipLoginBlServiceImpl.modify(enterpriseVipVO, "EnterpriseVippassword",
				"newEnterpriseVippassword"));
		assertEquals(true, enterpriseVipLoginBlServiceImpl.modify(enterpriseVipVO, "newEnterpriseVippassword",
				"EnterpriseVippassword"));
		assertEquals(false, enterpriseVipLoginBlServiceImpl.modify(enterpriseVipVO, "EnterpriseVippassword1",
				"EnterpriseVippassword"));
	}

	@Test
	public void testupgrade() {
		EnterpriseVipLoginBlServiceImpl enterpriseVipLoginBlServiceImpl = new EnterpriseVipLoginBlServiceImpl();
		CustomerPO customerPO = new CustomerPO(00002, "EnterpriseVipName", "EnterpriseVipphone");
		CustomerVO customerVO = new CustomerVO(customerPO);
		assertEquals("EnterpriseVipName",
				enterpriseVipLoginBlServiceImpl.upgrade(customerVO, "EnterpriseVipName").getEnterpriseName());
	}
}
