package businesslogic.creditbl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.creditbl.CreditBlServiceImpl;
import po.CustomerPO;
import po.ListPO;
import po.ListStatus;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.ListVO;

public class CreditBlServiceImplTest {

	@BeforeClass
	public static void before() {
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
	public void testdeductRevokeCredit() {
		CustomerPO customer = new CustomerPO(1234, "username", "phone");
		CustomerVO customerVO = new CustomerVO(customer);
		CreditBlServiceImpl credit = new CreditBlServiceImpl(customerVO, "2016/10/01 23:00:00");
		int listid = 1111;
		int hotelid = 2222;
		int userid = 1234;
		ListStatus status = ListStatus.REVOKED;
		String entrytime = "entrytime";
		String lasttime = "lasttime";
		String lastlist = "lastlist";
		int price = 200;
		boolean ifhavechild = true;
		ListPO listpo = new ListPO(listid, hotelid, userid, status, entrytime, lasttime, lastlist, price, ifhavechild);
		ListVO listvo = new ListVO(listpo);
		assertEquals(credit.deductRevokeCredit(listvo), true);
	}

	@Test
	public void testdeductAbnormalCredit() {
		CustomerPO customer = new CustomerPO(1234, "username", "phone");
		CustomerVO customerVO = new CustomerVO(customer);
		CreditBlServiceImpl credit = new CreditBlServiceImpl(customerVO, "2016/10/01 23:00:01");
		int listid = 1111;
		int hotelid = 2222;
		int userid = 1234;
		ListStatus status = ListStatus.ABNORMAL;
		String entrytime = "entrytime";
		String lasttime = "lasttime";
		String lastlist = "lastlist";
		int price = 200;
		boolean ifhavechild = true;
		ListPO listpo = new ListPO(listid, hotelid, userid, status, entrytime, lasttime, lastlist, price, ifhavechild);
		ListVO listvo = new ListVO(listpo);
		assertEquals(credit.deductAbnormalCredit(listvo), true);
	}

	@Test
	public void testrecoverCredit() {
		CustomerPO customer = new CustomerPO(1234, "username", "phone");
		CustomerVO customerVO = new CustomerVO(customer);
		CreditBlServiceImpl credit = new CreditBlServiceImpl(customerVO, "2016/10/01 23:00:01");
		int listid = 1111;
		int hotelid = 2222;
		int userid = 1234;
		ListStatus status = ListStatus.ABNORMAL;
		String entrytime = "entrytime";
		String lasttime = "lasttime";
		String lastlist = "lastlist";
		int price = 200;
		boolean ifhavechild = true;
		ListPO listpo = new ListPO(listid, hotelid, userid, status, entrytime, lasttime, lastlist, price, ifhavechild);
		ListVO listvo = new ListVO(listpo);
		assertEquals(credit.recoverCredit(listvo), true);
	}

	@Test
	public void testrechargeCredit() {
		CustomerPO customer = new CustomerPO(1234, "username", "phone");
		CustomerVO customerVO = new CustomerVO(customer);
		CreditBlServiceImpl credit = new CreditBlServiceImpl(customerVO, "2016/10/01 23:00:01");
		assertEquals(credit.rechargeCredit(1), true);
	}
}
