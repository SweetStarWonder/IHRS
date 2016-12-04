package dataDaoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dao.impl.ListDaoImpl;
import po.ListPO;
import po.ListStatus;

public class ListDaoTest {
	
	ListPO listPO = new ListPO(1111,1234,2222,ListStatus.ABNORMAL,"20161001","20161002","20160930",100,true);
	
	@Test
	public void testupdateList()throws Exception{
		ListDaoImpl List = ListDaoImpl.getInstance();
		assertEquals(true,List.updateList(listPO));
	}
	
	@Test
	public void testgetList()throws Exception{
		ListDaoImpl List = ListDaoImpl.getInstance();
		ListPO list = List.getList(1111);
		assertEquals(1111,list.getListId());
		assertEquals(1234,list.getHotelId());
		assertEquals(2222,list.getUserId());
		assertEquals(ListStatus.ABNORMAL,list.getStatus());
		assertEquals("20161001",list.getEntryTime());
		assertEquals("20161002",list.getLastTime());
		assertEquals("20160930",list.getLastListExecutedTime());
		assertEquals(100,list.getPrice());
		assertEquals(true,list.isIfHaveChild());
	}
	
	@Test
	public void testgetListhotel()throws Exception{
		ListDaoImpl List = ListDaoImpl.getInstance();
		ListPO list = List.getListsByHotel(1234).get(1111);
		assertEquals(1111,list.getListId());
		assertEquals(1234,list.getHotelId());
		assertEquals(2222,list.getUserId());
		assertEquals(ListStatus.ABNORMAL,list.getStatus());
		assertEquals("20161001",list.getEntryTime());
		assertEquals("20161002",list.getLastTime());
		assertEquals("20160930",list.getLastListExecutedTime());
		assertEquals(100,list.getPrice());
		assertEquals(true,list.isIfHaveChild());
	}
	
	@Test
	public void testgetListuser()throws Exception{
		ListDaoImpl List = ListDaoImpl.getInstance();
		ListPO list = List.getListsByUser(2222).get(1111);
		assertEquals(1111,list.getListId());
		assertEquals(1234,list.getHotelId());
		assertEquals(2222,list.getUserId());
		assertEquals(ListStatus.ABNORMAL,list.getStatus());
		assertEquals("20161001",list.getEntryTime());
		assertEquals("20161002",list.getLastTime());
		assertEquals("20160930",list.getLastListExecutedTime());
		assertEquals(100,list.getPrice());
		assertEquals(true,list.isIfHaveChild());
	}
	
	@Test
	public void testgetAllList()throws Exception{
		ListDaoImpl List = ListDaoImpl.getInstance();
		ListPO list = List.getAllLists().get(1111);
		assertEquals(1111,list.getListId());
		assertEquals(1234,list.getHotelId());
		assertEquals(2222,list.getUserId());
		assertEquals(ListStatus.ABNORMAL,list.getStatus());
		assertEquals("20161001",list.getEntryTime());
		assertEquals("20161002",list.getLastTime());
		assertEquals("20160930",list.getLastListExecutedTime());
		assertEquals(100,list.getPrice());
		assertEquals(true,list.isIfHaveChild());
	}
}
