package dataDaoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dao.impl.HotelManagerDaoImpl;
import po.HotelManagerPO;

public class HotelManagerDaoTest {

	HotelManagerPO hotelManagerPO = new HotelManagerPO(1234,"username","15105198966",1111);
	
	@Test
	public void testupdateHotelManager() throws Exception{
		HotelManagerDaoImpl hotelManager = HotelManagerDaoImpl.getInstance();
		assertEquals(true,hotelManager.updateHotelManager(hotelManagerPO));
	}

	@Test
	public void testgetHotelManagerByUser()throws Exception{
		HotelManagerDaoImpl hotelManager = HotelManagerDaoImpl.getInstance();
		HotelManagerPO hotelmanager = hotelManager.getHotelManagerByUser(1234);
		assertEquals(1234,hotelmanager.getId());
		assertEquals("username",hotelmanager.getUserName());
		assertEquals("15105198966",hotelmanager.getPhone());
		assertEquals(1111,hotelmanager.getHotelId());
	}
	
	@Test
	public void testgetHotelManagerByHotel()throws Exception{
		HotelManagerDaoImpl hotelManager = HotelManagerDaoImpl.getInstance();
		HotelManagerPO hotelmanager = hotelManager.getHotelManagerByHotel(1111);
		assertEquals(1234,hotelmanager.getId());
		assertEquals("username",hotelmanager.getUserName());
		assertEquals("15105198966",hotelmanager.getPhone());
		assertEquals(1111,hotelmanager.getHotelId());
	}
}
