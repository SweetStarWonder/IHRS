package businesslogic.hotelbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import po.EvaluatePO;
import po.HotelPO;
import po.RoomStatus;
import rmi.RemoteHelper;
import vo.HotelVO;
import vo.RoomVO;

public class HotelOperationServiceImplTest {

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
	public void testaddHotel() {
		ArrayList<String> partners = new ArrayList<String>();
		partners.add("partners");
		HotelVO hotelVO = new HotelVO(8888, null, null, partners, null, "hotelName", "position", "businessDistrict", 4, "introduction", "facility", 5);
		HotelOperationServiceImpl hotelOperationServiceImpl = new HotelOperationServiceImpl();
		assertEquals(false, hotelOperationServiceImpl.addHotel(hotelVO));
	}

	@Test
	public void testaddRooms(){
		RoomVO roomVO = new RoomVO(8888, 0, 502, 500, RoomStatus.DOUBLE);
		ArrayList<RoomVO> array = new ArrayList<>();
		array.add(roomVO);
		HotelOperationServiceImpl hotelOperationServiceImpl = new HotelOperationServiceImpl();
		assertEquals(hotelOperationServiceImpl.addRooms(array), false);
	}
	
	@Test
	public void testupdateCheckout(){
		RoomVO roomVO = new RoomVO(8888, 0, 502, 500, RoomStatus.SINGLE);
		ArrayList<RoomVO> array = new ArrayList<>();
		array.add(roomVO);
		HotelOperationServiceImpl hotelOperationServiceImpl = new HotelOperationServiceImpl();
		assertEquals(hotelOperationServiceImpl.updateCheckOut(array), true);
	}
	
	@Test
	public void testmodifyHotelInformation(){
		ArrayList<String> partners = new ArrayList<String>();
		partners.add("partners");
		HotelVO hotelVO = new HotelVO(8888, null, null, partners, null, "hotelName", "position", "businessDistrict", 4, "introduction", "facility", 5);
		HotelOperationServiceImpl hotelOperationServiceImpl = new HotelOperationServiceImpl();
		assertEquals(true, hotelOperationServiceImpl.modifyHotelInformation(hotelVO));
	}
	
	@Test
	public void testevaluateHotel(){
		ArrayList<String> partners = new ArrayList<String>();
		partners.add("partners");
		EvaluatePO evaluatePO = new EvaluatePO(8888, "customerName", 5, "content");
		HotelVO hotelVO = new HotelVO(new HotelPO(8888, partners, "hotelName", "position", "businessDistrict", 4, "introduction", "facility"));
		HotelOperationServiceImpl hotelOperationServiceImpl = new HotelOperationServiceImpl();
		
		assertEquals(true, hotelOperationServiceImpl.evaluateHotel(evaluatePO, hotelVO));
	}
}
