package dataDaoTest;

import static org.junit.Assert.*;

import org.junit.Test;

import data.dao.impl.RoomDaoImpl;
import po.RoomPO;
import po.RoomStatus;

public class RoomDaoTest {

	RoomPO RoomPO = new RoomPO(111,1234,5,100,RoomStatus.SINGLE);
	
	@Test
	public void testupdateRoom()throws Exception{
		RoomDaoImpl Room = RoomDaoImpl.getInstance();
		assertEquals(true,Room.updateRoom(RoomPO));
	}
	
	@Test
	public void testgetRoom()throws Exception{
		RoomDaoImpl Room = RoomDaoImpl.getInstance();
		RoomPO roomlist = Room.getRoomByList(1234).get(0);
		RoomPO roomhotel = Room.getRoomsByHotel(111).get(0);
		assertEquals(111,roomlist.getHotelId());
		assertEquals(1234,roomlist.getListId());
		assertEquals(5,roomlist.getRoomNum());
		assertEquals(100,roomlist.getPrice());
		assertEquals(RoomStatus.SINGLE,roomlist.getStatus());
		assertEquals(111,roomhotel.getHotelId());
		assertEquals(1234,roomhotel.getListId());
		assertEquals(5,roomhotel.getRoomNum());
		assertEquals(100,roomhotel.getPrice());
		assertEquals(RoomStatus.SINGLE,roomhotel.getStatus());
	}
}
