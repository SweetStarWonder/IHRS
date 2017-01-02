package businesslogic.vipbl;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import vo.EnterpriseVipVO;
import vo.NormalVipVO;
import vo.CustomerVO;
import rmi.RemoteHelper;
import businesslogic.vipbl.VipBlServiceImpl;;

public class VipBlServiceImplTest {

	VipBlServiceImpl VipBlServiceImpl = new VipBlServiceImpl();
	EnterpriseVipVO EnterpriseVipVO;
	NormalVipVO NormalVipVO;
	CustomerVO CustomerVO = new CustomerVO(1, "1", "11");

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

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void registerEnterpriseVipTest() {
		EnterpriseVipVO = VipBlServiceImpl.registerEnterpriseVip(CustomerVO, "111");
		assertEquals(1, EnterpriseVipVO.getId());
		assertEquals("1", EnterpriseVipVO.getUserName());
		assertEquals("11", EnterpriseVipVO.getPhone());
		assertEquals("111", EnterpriseVipVO.getEnterpriseName());
		assertEquals(0, EnterpriseVipVO.getBonus());
	}

	@Test
	public void registerNormalVipTest() {
		NormalVipVO = VipBlServiceImpl.registerNormalVip(CustomerVO, "1111");
		assertEquals(1, NormalVipVO.getId());
		assertEquals("1", NormalVipVO.getUserName());
		assertEquals("11", NormalVipVO.getPhone());
		assertEquals(0, NormalVipVO.getBonus());
		assertEquals("1111", NormalVipVO.getBirthday());

	}

}
