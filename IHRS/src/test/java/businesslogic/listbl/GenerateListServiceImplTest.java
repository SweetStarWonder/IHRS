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
import po.EnterpriseVipPO;
import po.ListStatus;
import po.NormalVipPO;
import po.RoomPO;
import po.RoomStatus;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.ListVO;
import vo.NormalVipVO;
import vo.RoomVO;

public class GenerateListServiceImplTest {

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
	public void testgenerateList1(){
		//ListPO listPO = new ListPO(1111, 2222, 1234, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 10:00:00", "2016/10/01 10:00:01", 500, true);
		RoomPO roomPO = new RoomPO(2222, 1111, 503, 500, RoomStatus.TRIPLE);
		RoomVO roomVO = new RoomVO(roomPO);
		ArrayList<RoomVO> roomVOs = new ArrayList<>();
		roomVOs.add(roomVO);
		ListVO listVO = new ListVO(1111, 2222, 1234, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 10:00:00", "2016/10/01 10:00:01", 500, true,roomVOs);
		CustomerPO customerPO = new CustomerPO(1234, "customerName", "phone");
		CustomerVO customerVO = new CustomerVO(customerPO);
		GenerateListServiceImpl generateListServiceImpl = new GenerateListServiceImpl();
		String timeNow = "2016/10/02 08:00:00";
		assertEquals(true, generateListServiceImpl.generateList(listVO, customerVO, timeNow));
	}

	@Test
	public void testgenerateList2(){
		RoomPO roomPO = new RoomPO(2222, 1111, 503, 500, RoomStatus.TRIPLE);
		RoomVO roomVO = new RoomVO(roomPO);
		ArrayList<RoomVO> roomVOs = new ArrayList<>();
		roomVOs.add(roomVO);
		ListVO listVO = new ListVO(1111, 2222, 1234, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 10:00:00", "2016/10/01 10:00:01", 500, true,roomVOs);
		NormalVipPO normalVipPO = new NormalVipPO(1234, "customerName", "phone", 0, "birthday");
		NormalVipVO normalVipVO = new NormalVipVO(normalVipPO);
		GenerateListServiceImpl generateListServiceImpl = new GenerateListServiceImpl();
		String timeNow = "2016/10/02 08:00:00";
		assertEquals(true, generateListServiceImpl.generateList(listVO, normalVipVO, timeNow));
	}
	
	@Test
	public void testgenerateList3(){
		RoomPO roomPO = new RoomPO(2222, 1111, 503, 500, RoomStatus.TRIPLE);
		RoomVO roomVO = new RoomVO(roomPO);
		ArrayList<RoomVO> roomVOs = new ArrayList<>();
		roomVOs.add(roomVO);
		ListVO listVO = new ListVO(1111, 2222, 1234, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 10:00:00", "2016/10/01 10:00:01", 500, true,roomVOs);
		EnterpriseVipPO enterpriseVipPO = new EnterpriseVipPO(1234, "customerName", "phone", "enterpriseName", 0);
		EnterpriseVipVO enterpriseVipVO = new EnterpriseVipVO(enterpriseVipPO);
		GenerateListServiceImpl generateListServiceImpl = new GenerateListServiceImpl();
		String timeNow = "2016/10/02 08:00:00";
		assertEquals(true, generateListServiceImpl.generateList(listVO, enterpriseVipVO, timeNow));
	}
}
