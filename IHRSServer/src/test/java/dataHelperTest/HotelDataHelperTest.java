package dataHelperTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.HotelDataTxtHelper;
import po.HotelPO;

public class HotelDataHelperTest {

	static HotelDataTxtHelper Hotel = new HotelDataTxtHelper();
	
	@BeforeClass
	public static void testHotelDataHelper(){
		
		ArrayList<String> partners = new ArrayList<String>(); 
		partners.add("asd");
		HotelPO Hotelpo = new HotelPO(1111,partners,"123","123","123",100,"123","123");
		HashMap<Integer, HotelPO> map=new HashMap<Integer, HotelPO>();
		map.put(1111, Hotelpo);
		Hotel.updateHotelData(map);
		
	}
	
	@Test
	public void testgetHotelData(){
		String partners="asd";
		HotelPO hotelPO = Hotel.getHotelData().get(1111);
		assertEquals(1111,hotelPO.getId());
		assertEquals(partners,hotelPO.getPartners().get(0));
		assertEquals("123",hotelPO.getHotelName());
		assertEquals("123",hotelPO.getPosition());
		assertEquals("123",hotelPO.getBusinessDistrict());
		assertEquals(100,hotelPO.getStarRating());
		assertEquals("123",hotelPO.getIntroduction());
		assertEquals("123",hotelPO.getFacility());
		
	}
}
