package businesslogic.loginbl;

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

public class CustomerLoginBlServiceImplTest {

	
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
	public void testlogin1() {
		CustomerLoginBlServiceImpl customerLoginBlServiceImpl = new CustomerLoginBlServiceImpl();
		CustomerPO customerPO = new CustomerPO(00001, "userName", "userphone");
		CustomerVO customerVO = new CustomerVO(customerPO);
		assertEquals(customerLoginBlServiceImpl.login(00001, "userName", "userpassword").getPhone(), customerVO.getPhone());
		assertEquals(customerLoginBlServiceImpl.login(0, "userName", "userpassword").getPhone(), customerVO.getPhone());
		assertEquals(customerLoginBlServiceImpl.login(00001, null, "userpassword").getPhone(), customerVO.getPhone());
		assertEquals(customerLoginBlServiceImpl.login(00001, null, "userpassword1"), null);
		assertEquals(customerLoginBlServiceImpl.login(12354, null, "userpassword"), null);
		assertEquals(customerLoginBlServiceImpl.login(0, "userName1", "userpassword"), null);
		assertEquals(customerLoginBlServiceImpl.login(0, "userName", "userpassword1"), null);
	}

	@Test
	public void testmodify(){
		CustomerPO customerPO = new CustomerPO(00001, "userName", "userphone");
		CustomerVO customerVO = new CustomerVO(customerPO);
		CustomerLoginBlServiceImpl customerLoginBlServiceImpl = new CustomerLoginBlServiceImpl();
		assertEquals(customerLoginBlServiceImpl.modify(customerVO, "userpassword", "newuserpassword"), true);
		assertEquals(customerLoginBlServiceImpl.modify(customerVO, "userpassword", "newuserpassword"), false);
		assertEquals(customerLoginBlServiceImpl.modify(customerVO, "newuserpassword", "userpassword"), true);
	}
	
	@Test
	public void testregister(){
		CustomerLoginBlServiceImpl customerLoginBlServiceImpl = new CustomerLoginBlServiceImpl();
		assertEquals(customerLoginBlServiceImpl.register("customerName", "customerpassword", "userphone"), false);
		assertEquals(customerLoginBlServiceImpl.register("userName", "userpassword", "userphone"), false);
	}
}
