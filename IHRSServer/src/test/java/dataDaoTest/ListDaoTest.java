package dataDaoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dao.impl.ListDaoImpl;
import po.ListPO;
import po.ListStatus;

public class ListDaoTest {
	
	ListPO listPO = new ListPO(1111,2222,1234,ListStatus.ABNORMAL,"2016/10/01 08:00:00","2016/10/01 10:00:00","2016/09/01 08:00:00",100,true);
	
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
		assertEquals(2222,list.getHotelId());
		assertEquals(1234,list.getUserId());
		assertEquals(ListStatus.ABNORMAL,list.getStatus());
		assertEquals("2016/10/01 08:00:00",list.getEntryTime());
		assertEquals("2016/10/01 10:00:00",list.getLastTime());
		assertEquals("2016/09/01 08:00:00",list.getLastListExecutedTime());
		assertEquals(100,list.getPrice());
		assertEquals(true,list.isIfHaveChild());
	}
	
	@Test
	public void testgetListhotel()throws Exception{
		ListDaoImpl List = ListDaoImpl.getInstance();
		ListPO list = List.getListsByHotel(2222).get(1111);
		assertEquals(1111,list.getListId());
		assertEquals(2222,list.getHotelId());
		assertEquals(1234,list.getUserId());
		assertEquals(ListStatus.ABNORMAL,list.getStatus());
		assertEquals("2016/10/01 08:00:00",list.getEntryTime());
		assertEquals("2016/10/01 10:00:00",list.getLastTime());
		assertEquals("2016/09/01 08:00:00",list.getLastListExecutedTime());
		assertEquals(100,list.getPrice());
		assertEquals(true,list.isIfHaveChild());
	}
	
	@Test
	public void testgetListuser()throws Exception{
		ListDaoImpl List = ListDaoImpl.getInstance();
		ListPO list = List.getListsByUser(1234).get(1111);
		assertEquals(1111,list.getListId());
		assertEquals(2222,list.getHotelId());
		assertEquals(1234,list.getUserId());
		assertEquals(ListStatus.ABNORMAL,list.getStatus());
		assertEquals("2016/10/01 08:00:00",list.getEntryTime());
		assertEquals("2016/10/01 10:00:00",list.getLastTime());
		assertEquals("2016/09/01 08:00:00",list.getLastListExecutedTime());
		assertEquals(100,list.getPrice());
		assertEquals(true,list.isIfHaveChild());
	}
	
	@Test
	public void testgetAllList()throws Exception{
		ListDaoImpl List = ListDaoImpl.getInstance();
		ListPO list = List.getAllLists().get(1111);
		assertEquals(1111,list.getListId());
		assertEquals(2222,list.getHotelId());
		assertEquals(1234,list.getUserId());
		assertEquals(ListStatus.ABNORMAL,list.getStatus());
		assertEquals("2016/10/01 08:00:00",list.getEntryTime());
		assertEquals("2016/10/01 10:00:00",list.getLastTime());
		assertEquals("2016/09/01 08:00:00",list.getLastListExecutedTime());
		assertEquals(100,list.getPrice());
		assertEquals(true,list.isIfHaveChild());
	}
}
