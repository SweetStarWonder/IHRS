package businesslogic.userbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.userbl.ModifyInformationServiceImpl;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public class ModifyInformationServiceImplTest {

	ModifyInformationServiceImpl ModifyInformationServiceImpl = new ModifyInformationServiceImpl();
	CustomerVO CustomerVO;
	HotelManagerVO HotelManagerVO;
	WebSaleVO WebSaleVO;
	WebManagerVO WebManagerVO;
	CustomerVO CustomerVOTest = new CustomerVO(1, "1", "11");
	HotelManagerVO HotelManagerVOTest = new HotelManagerVO(1, "1", "11", 11);
	WebSaleVO WebSaleVOTest = new WebSaleVO(1, "1", "11");
	WebManagerVO WebManagerVOTest = new WebManagerVO(1, "1", "11");

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
	public void modifyInformationforCustomerTest() {

		assertEquals(true, ModifyInformationServiceImpl.modifyInformation(CustomerVOTest));
	}

	@Test
	public void modifyInformationforHotelManagerTest() {
		assertEquals(true, ModifyInformationServiceImpl.modifyInformation(HotelManagerVOTest));
	}

	@Test
	public void modifyInformationforWebManagerTest() {
		assertEquals(true, ModifyInformationServiceImpl.modifyInformation(WebManagerVOTest));
	}

	@Test
	public void modifyInformationforWebSaleTest() {
		assertEquals(true, ModifyInformationServiceImpl.modifyInformation(WebSaleVOTest));
	}

}
