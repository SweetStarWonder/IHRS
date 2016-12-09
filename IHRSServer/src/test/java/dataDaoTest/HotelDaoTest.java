package dataDaoTest;

import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import data.dao.impl.HotelDaoImpl;
import po.HotelPO;

public class HotelDaoTest {
    
	

	@Test
	
	public void testAddHotel () throws Exception{
		ArrayList<String> partners = new ArrayList<String>();
		String str1 = "partners1";
		String str2 = "partners2";
		partners.add(str1);
		partners.add(str2);
		HotelPO HotelPO=new HotelPO(111,partners,"111","111","111",111,"111","111");
		HotelDaoImpl Hotel=HotelDaoImpl.getInstance();
		assertEquals(false,Hotel.addHotel(HotelPO));
		
	}
	
	@Test
	public void testUpdateEnterpriseVip() throws Exception{
		
		ArrayList<String> partners = new ArrayList<String>();
		String str1 = "partners1";
		String str2 = "partners2";
		partners.add(str1);
		partners.add(str2);
		HotelPO HotelPO=new HotelPO(111,partners,"111","111","111",111,"111","111");
		HotelDaoImpl Hotel=HotelDaoImpl.getInstance();
		assertEquals(true,Hotel.update(HotelPO));
		
	}
	

	@Test
	public void testGetHotelByStarRating()throws RemoteException{
		
		ArrayList<String> partners = new ArrayList<String>();
		String str1 = "partners1";
		String str2 = "partners2";
		partners.add(str1);
		partners.add(str2);
		
		HotelDaoImpl Hotel=HotelDaoImpl.getInstance();
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		list=Hotel.getHotelsByStarRating("111","111",111);
		
		assertEquals(111,list.get(0).getId());
		assertEquals(partners,list.get(0).getPartners());
		assertEquals("111",list.get(0).getHotelName());
		assertEquals("111",list.get(0).getPosition());
		assertEquals("111",list.get(0).getBusinessDistrict());
		assertEquals(111,list.get(0).getStarRating());
		assertEquals("111",list.get(0).getIntroduction());
		assertEquals("111",list.get(0).getFacility());
	
		
	}
	
	@Test
	public void testGetHotelByRankValue()throws RemoteException{
		
		ArrayList<String> partners = new ArrayList<String>();
		String str1 = "partners1";
		String str2 = "partners2";
		partners.add(str1);
		partners.add(str2);
		
		HotelDaoImpl Hotel=HotelDaoImpl.getInstance();
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		list=Hotel.getHotelsByRankValue("111","111",111,111);
		
		assertEquals(111,list.get(0).getId());
		assertEquals(partners,list.get(0).getPartners());
		assertEquals("111",list.get(0).getHotelName());
		assertEquals("111",list.get(0).getPosition());
		assertEquals("111",list.get(0).getBusinessDistrict());
		assertEquals(111,list.get(0).getStarRating());
		assertEquals("111",list.get(0).getIntroduction());
		assertEquals("111",list.get(0).getFacility());
	
		
	}
	@Test
	public void testGetHotelByName()throws RemoteException{

		ArrayList<String> partners = new ArrayList<String>();
		String str1 = "partners1";
		String str2 = "partners2";
		partners.add(str1);
		partners.add(str2);
		
		HotelDaoImpl Hotel=HotelDaoImpl.getInstance();
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		list=Hotel.getHotelsByName("111","111","111");
		
		assertEquals(111,list.get(0).getId());
		assertEquals(partners,list.get(0).getPartners());
		assertEquals("111",list.get(0).getHotelName());
		assertEquals("111",list.get(0).getPosition());
		assertEquals("111",list.get(0).getBusinessDistrict());
		assertEquals(111,list.get(0).getStarRating());
		assertEquals("111",list.get(0).getIntroduction());
		assertEquals("111",list.get(0).getFacility());
	
		
	}
	@Test
	public void testGetHotelByRoom()throws RemoteException{
		
		ArrayList<String> partners = new ArrayList<String>();
		String str1 = "partners1";
		String str2 = "partners2";
		partners.add(str1);
		partners.add(str2);
		
		HotelDaoImpl Hotel=HotelDaoImpl.getInstance();
		ArrayList<HotelPO> list = new ArrayList<HotelPO>();
		list=Hotel.getHotelByRoom("111","111",1);
		
		assertEquals(111,list.get(0).getId());
		assertEquals(partners,list.get(0).getPartners());
		assertEquals("111",list.get(0).getHotelName());
		assertEquals("111",list.get(0).getPosition());
		assertEquals("111",list.get(0).getBusinessDistrict());
		assertEquals(111,list.get(0).getStarRating());
		assertEquals("111",list.get(0).getIntroduction());
		assertEquals("111",list.get(0).getFacility());
	
		
	}
	
}
