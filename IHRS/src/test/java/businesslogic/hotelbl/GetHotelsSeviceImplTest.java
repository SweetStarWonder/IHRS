package businesslogic.hotelbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import po.CustomerPO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.HotelVO;

public class GetHotelsSeviceImplTest {

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
	public void testgetReservedHotels() {
		CustomerPO customerPO = new CustomerPO(1234, "username", "phone");
		CustomerVO customerVO = new CustomerVO(customerPO);
		GetHotelsSeviceImpl getHotelsSeviceImpl = new GetHotelsSeviceImpl(customerVO);
		assertEquals(2222, getHotelsSeviceImpl.getReservedHotels().get(2222).getId());
	}

	@Test
	public void testsearchHotels() {
		CustomerPO customerPO = new CustomerPO(1234, "username", "phone");
		CustomerVO customerVO = new CustomerVO(customerPO);
		GetHotelsSeviceImpl getHotelsSeviceImpl = new GetHotelsSeviceImpl(customerVO);
		HotelVO hotelVO = getHotelsSeviceImpl.searchHotels("position", "businessDistrict", "hotelName", 0, 0, 0, 5, null, 0, 0, true).get(2222);
		assertEquals(2222, hotelVO.getId());
		assertEquals(hotelVO.getBusinessDistrict(), "businessDistrict");
	}
	
}
