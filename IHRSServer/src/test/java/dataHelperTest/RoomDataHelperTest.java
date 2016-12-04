package dataHelperTest;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.Test;

import data.dataHelper.impl.RoomDataTxtHelper;
import po.RoomPO;
import po.RoomStatus;

public class RoomDataHelperTest {

	static RoomDataTxtHelper Room = new RoomDataTxtHelper();
	
	@BeforeClass
	public static void testRoomDataHelper(){
		RoomStatus status = RoomStatus.SINGLE;
		RoomPO Roompo = new RoomPO(1111,1234,5,100,status);
		HashMap<Integer,RoomPO> map = new HashMap<Integer,RoomPO>();
		map.put(5, Roompo);
		HashMap<Integer,HashMap<Integer,RoomPO>> Map = new HashMap<Integer,HashMap<Integer,RoomPO>>();
		Map.put(1111, map);
		Room.updateRoomData(Map);
	}

	
	@Test
	public void testgetRoomData(){
		RoomPO roompo = Room.getRoomData().get(1111).get(5);
		RoomStatus status = RoomStatus.SINGLE;
		assertEquals(1111,roompo.getHotelId());
		assertEquals(1234,roompo.getListId());
		assertEquals(5,roompo.getRoomNum());
		assertEquals(100,roompo.getPrice());
		assertEquals(status,roompo.getStatus());
	}

}
