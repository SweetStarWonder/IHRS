package businesslogic.listbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import po.CustomerPO;
import po.HotelPO;
import rmi.RemoteHelper;
import vo.CustomerVO;

public class GetListsServiceImplTest {

	@BeforeClass
	public static void before(){
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testgetPersonalListsInHotel() {
		GetListsServiceImpl getListsServiceImpl = new GetListsServiceImpl();
		CustomerPO customerPO = new CustomerPO(1234, "customerName", "phone");
		CustomerVO customerVO = new CustomerVO(customerPO);
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner1");
		partners.add("partner2");
		HotelPO hotelPO = new HotelPO(2222, partners, "hotelName", "position", "businessDistrict", 4, "introduction", "facility");
		vo.HotelVO hotelVO = new vo.HotelVO(hotelPO);
		assertEquals(1234, getListsServiceImpl.getPersonalListsInHotel(customerVO, hotelVO).get(1111).getUserId());
	}

	@Test
	public void testgetHotelLists() {
		GetListsServiceImpl getListsServiceImpl = new GetListsServiceImpl();
		int hotelId = 2222;
		assertEquals(1234, getListsServiceImpl.getHotelLists(hotelId).get(1111).getUserId());
	}
	
	@Test
	public void testgetDailyUnexecutedLists(){
		GetListsServiceImpl getListsServiceImpl = new GetListsServiceImpl();
		assertEquals(1234, getListsServiceImpl.getDailyUnexecutedLists().get(1111).getUserId());
	}
}
