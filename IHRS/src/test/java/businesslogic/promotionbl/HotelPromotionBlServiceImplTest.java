package businesslogic.promotionbl;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import businesslogic.promotionbl.HotelPromotionBlServiceImpl;
import po.promotionPO.HotelPromotionType;
import rmi.RemoteHelper;
import vo.promotionVO.HotelPromotionVO;

public class HotelPromotionBlServiceImplTest {

	HotelPromotionType type = HotelPromotionType.BIRTHDAY;
	HotelPromotionVO HotelPromotionVO = new HotelPromotionVO(1.0, "1", 11, type, "11", "111");

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
	public void getHotelPromotionTest() {
		ArrayList<HotelPromotionVO> HotelPromotionVOlist = new ArrayList<HotelPromotionVO>();
		HotelPromotionVOlist.add(HotelPromotionVO);
		HotelPromotionBlServiceImpl HotelPromotionBlServiceImpl = new HotelPromotionBlServiceImpl();
		ArrayList<HotelPromotionVO> HotelPromotionVOlistTest = HotelPromotionBlServiceImpl.getHotelPromotions(11);
		HotelPromotionVO HotelPromotionVOtest = HotelPromotionVOlistTest.get(0);

		assertEquals(1.0, HotelPromotionVOtest.getDiscount(), 0.0);
		assertEquals("1", HotelPromotionVOtest.getDiscountName());
		assertEquals(11, HotelPromotionVOtest.getHotelId());
		assertEquals(type, HotelPromotionVOtest.getHotelPromotionType());
		assertEquals("11", HotelPromotionVOtest.getStartTime());
		assertEquals("111", HotelPromotionVOtest.getEndTime());
	}

	@Test
	public void addHotelPromotionTest() {

		HotelPromotionBlServiceImpl HotelPromotionBlServiceImpl = new HotelPromotionBlServiceImpl();
		assertEquals(true, HotelPromotionBlServiceImpl.addHotelPromotion(HotelPromotionVO));
	}

	@Test
	public void deleteHotelPromotionTest() {

		HotelPromotionBlServiceImpl HotelPromotionBlServiceImpl = new HotelPromotionBlServiceImpl();
		assertEquals(false, HotelPromotionBlServiceImpl.deleteHotelPromotion(HotelPromotionVO));
	}

	@Test
	public void getMinDiscountForCustomerTest() {
		HotelPromotionBlServiceImpl HotelPromotionBlServiceImpl = new HotelPromotionBlServiceImpl();
		assertEquals(1.0, HotelPromotionBlServiceImpl.getMinDiscountForCustomer(11, "11", true), 0.0);

	}

	@Test
	public void getMinDiscountForEnterPriseVipTest() {
		HotelPromotionBlServiceImpl HotelPromotionBlServiceImpl = new HotelPromotionBlServiceImpl();
		assertEquals(1.0, HotelPromotionBlServiceImpl.getMinDiscountForEnterPriseVip(11, "11", true), 0.0);
	}

	@Test
	public void getMinDiscountForNormalVipTest() {
		HotelPromotionBlServiceImpl HotelPromotionBlServiceImpl = new HotelPromotionBlServiceImpl();
		assertEquals(1.0, HotelPromotionBlServiceImpl.getMinDiscountForNormalVip(11, "11", true, true), 0.0);
	}

}
