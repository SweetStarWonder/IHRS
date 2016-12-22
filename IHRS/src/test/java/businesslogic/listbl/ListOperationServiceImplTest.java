package businesslogic.listbl;
import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vo.ListVO;
import vo.RoomVO;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.listbl.ListOperationServiceImpl;
import po.ListStatus;
import po.RoomStatus;
import rmi.RemoteHelper;;
public class ListOperationServiceImplTest {

	ListOperationServiceImpl ListOperationServiceImpl=new ListOperationServiceImpl();
	ListStatus status=ListStatus.ABNORMAL;
	ListVO listVO;
	RoomVO RoomVO=new RoomVO(11,1,111,1111,RoomStatus.DOUBLE);
	 ArrayList<RoomVO> roomvolist=new  ArrayList<RoomVO>();
	 
	
	
	@BeforeClass
	public static  void linkToServer(){
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
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void revokeListTest(){
		roomvolist.add(RoomVO);
		ListVO listVOtest=new ListVO(1,11,111,status,"2016/10/01 11:00:00","2016/10/01 12:00:00","2016/10/01 13:00:00",1111,true,roomvolist);
		assertEquals(1,ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 11:00:00").getListId());
		assertEquals(11,ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 13:00:00").getHotelId());
		assertEquals(111,ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 13:00:00").getUserId());
		assertEquals(ListStatus.REVOKED,ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 13:00:00").getStatus());
		assertEquals("2016/10/01 11:00:00",ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 13:00:00").getEntryTime());
		assertEquals("2016/10/01 12:00:00",ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 13:00:00").getLastTime());
		assertEquals("2016/10/01 13:00:00",ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 13:00:00").getLastListExecutedTime());
		assertEquals(1111,ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 13:00:00").getPrice());
		assertEquals(true,ListOperationServiceImpl.revokeList(listVOtest, "2016/10/01 13:00:00").isIfHaveChild());
		
	}
	
	@Test
	public void updateCheckInTest(){
		roomvolist.add(RoomVO);
		ListVO listVOtest=new ListVO(1,11,111,status,"2016/10/01 11:00:00","2016/10/01 12:00:00","2016/10/01 13:00:00",1111,true,roomvolist);
		assertEquals(1,ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").getListId());
		assertEquals(11,ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").getHotelId());
		assertEquals(111,ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").getUserId());
		assertEquals(ListStatus.EXECUTED,ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").getStatus());
		assertEquals("2016/10/01 13:00:00",ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").getEntryTime());
		assertEquals("2016/10/01 11:00:00",ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").getLastTime());
		assertEquals("2016/10/01 12:00:00",ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").getLastListExecutedTime());
		assertEquals(1111,ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").getPrice());
		assertEquals(true,ListOperationServiceImpl.updateCheckIn(listVOtest, "2016/10/01 13:00:00").isIfHaveChild());
		
	}
	
	@Test
	public void updateCheckOutTest(){
		roomvolist.add(RoomVO);
		ListVO listVOtest=new ListVO(1,11,111,status,"2016/10/01 11:00:00","2016/10/01 12:00:00","2016/10/01 13:00:00",1111,true,roomvolist);
		assertEquals(1,ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").getListId());
		assertEquals(11,ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").getHotelId());
		assertEquals(111,ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").getUserId());
		assertEquals("ABNORMAL",ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").getStatus());
		assertEquals("2016/10/01 10:00:00",ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").getEntryTime());
		assertEquals("2016/10/01 13:00:00",ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").getLastTime());
		assertEquals("2016/10/01 12:00:00",ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").getLastListExecutedTime());
		assertEquals(1111,ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").getPrice());
		assertEquals(true,ListOperationServiceImpl.updateCheckOut(listVOtest, "2016/10/01 13:00:00").isIfHaveChild());
		
	}
	
	@Test
	public void executeListTest(){
		roomvolist.add(RoomVO);
		ListVO listVOtest=new ListVO(1,11,111,status,"2016/10/01 11:00:00","2016/10/01 12:00:00","2016/10/01 13:00:00",1111,true,roomvolist);
		assertEquals(1,ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").getListId());
		assertEquals(11,ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").getHotelId());
		assertEquals(111,ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").getUserId());
		assertEquals("EXECUTED",ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").getStatus());
		assertEquals("2016/10/01 10:00:00",ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").getEntryTime());
		assertEquals("2016/10/01 11:00:00",ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").getLastTime());
		assertEquals("2016/10/01 12:00:00",ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").getLastListExecutedTime());
		assertEquals(1111,ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").getPrice());
		assertEquals(true,ListOperationServiceImpl.executeList(listVOtest, "2016/10/01 13:00:00").isIfHaveChild());
		
	}
	
	@Test
	public void setAbnormalTest(){
		roomvolist.add(RoomVO);
		ListVO listVOtest=new ListVO(1,11,111,status,"2016/10/01 11:00:00","2016/10/01 12:00:00","2016/10/01 13:00:00",1111,true,roomvolist);
		assertEquals(1,ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").getListId());
		assertEquals(11,ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").getHotelId());
		assertEquals(111,ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").getUserId());
		assertEquals("ABNORMAL",ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").getStatus());
		assertEquals("2016/10/01 10:00:00",ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").getEntryTime());
		assertEquals("2016/10/01 11:00:00",ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").getLastTime());
		assertEquals("2016/10/01 12:00:00",ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").getLastListExecutedTime());
		assertEquals(1111,ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").getPrice());
		assertEquals(true,ListOperationServiceImpl.setAbnormal(listVOtest, "2016/10/01 13:00:00").isIfHaveChild());
		
	}
	
	
	@Test
	public void revokeAbnormalList(){
		roomvolist.add(RoomVO);
		ListVO listVOtest=new ListVO(1,11,111,status,"2016/10/01 11:00:00","2016/10/01 12:00:00","2016/10/01 13:00:00",1111,true,roomvolist);
		assertEquals(1,ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).getListId());
		assertEquals(11,ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).getHotelId());
		assertEquals(111,ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).getUserId());
		assertEquals("REVOKED",ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).getStatus());
		assertEquals("2016/10/01 10:00:00",ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).getEntryTime());
		assertEquals("2016/10/01 11:00:00",ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).getLastTime());
		assertEquals("2016/10/01 13:00:00",ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).getLastListExecutedTime());
		assertEquals(1111,ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).getPrice());
		assertEquals(true,ListOperationServiceImpl.revokeAbnormalList(listVOtest, "2016/10/01 13:00:00",true).isIfHaveChild());
		
	}
	

	
	
	
	
	
	
	
	
}
