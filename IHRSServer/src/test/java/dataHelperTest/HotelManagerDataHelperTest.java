package dataHelperTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.HotelManagerDataTxtHelper;
import po.HotelManagerPO;

public class HotelManagerDataHelperTest {

	static HotelManagerDataTxtHelper HotelManager = new HotelManagerDataTxtHelper();
	
	@BeforeClass
	public static void testHotelManagerDataHelper(){
		HotelManagerPO HotelManagerpo = new HotelManagerPO(1234,"username","15105198966",1111);
		HashMap<Integer,HotelManagerPO> map = new HashMap<Integer,HotelManagerPO>();
		map.put(1234, HotelManagerpo);
		HotelManager.updateHotelManagerData(map);
	}
	
	@Test
	public void testgetHotelManagerDataById(){
		HotelManagerPO hotelmanagerpo = HotelManager.getHotelManagerData().get(1234);
		assertEquals(1111, hotelmanagerpo.getHotelId());
		assertEquals("username",hotelmanagerpo.getUserName());
		assertEquals("15105198966",hotelmanagerpo.getPhone());
		assertEquals(1234,hotelmanagerpo.getId());
	}
}
