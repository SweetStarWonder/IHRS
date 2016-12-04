package dataHelperTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.ListDataTxtHelper;
import po.ListPO;
import po.ListStatus;

public class ListDataHelperTest {

	static ListDataTxtHelper List = new ListDataTxtHelper();
	
	@BeforeClass
	public static void testListDataHelper(){
		ListStatus status = ListStatus.ABNORMAL;
		ListPO Listpo = new ListPO(1111,1234,2222,status,"20161001","20161002","20160930",100,true);
		HashMap<Integer,ListPO> map = new HashMap<Integer,ListPO>();
		map.put(1234, Listpo);
		HashMap<Integer,HashMap<Integer,ListPO>> Map = new HashMap<Integer,HashMap<Integer,ListPO>>();
		Map.put(1111, map);
		List.updateListDataByHotel(Map);
	}
	
	
	@Test
	public void testgetListDataByUser(){
		ListPO listpo = List.getListDataByUser().get(2222).get(1111);
		boolean withchild = true;
		ListStatus status = ListStatus.ABNORMAL;
		assertEquals(1234, listpo.getHotelId());
		assertEquals(2222,listpo.getUserId());
		assertEquals(1111,listpo.getListId());
		assertEquals("20161001",listpo.getEntryTime());
		assertEquals("20161002",listpo.getLastTime());
		assertEquals("20160930",listpo.getLastListExecutedTime());
		assertEquals(100,listpo.getPrice());
		assertEquals(status,listpo.getStatus());
		assertEquals(withchild,listpo.isIfHaveChild());
	}
	
	@Test
	public void testgetListDataByHotel(){
		ListPO listpo = List.getListDataByHotel().get(1234).get(1111);
		boolean withchild = true;
		ListStatus status = ListStatus.ABNORMAL;
		assertEquals(1234, listpo.getHotelId());
		assertEquals(2222,listpo.getUserId());
		assertEquals(1111,listpo.getListId());
		assertEquals("20161001",listpo.getEntryTime());
		assertEquals("20161002",listpo.getLastTime());
		assertEquals("20160930",listpo.getLastListExecutedTime());
		assertEquals(100,listpo.getPrice());
		assertEquals(status,listpo.getStatus());
		assertEquals(withchild,listpo.isIfHaveChild());
	}
}
