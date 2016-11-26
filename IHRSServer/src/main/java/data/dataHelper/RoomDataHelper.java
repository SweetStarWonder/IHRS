package data.dataHelper;

import java.util.HashMap;

import po.RoomPO;

public interface RoomDataHelper {

	public HashMap<Integer, HashMap<Integer, RoomPO>> getRoomData();	//左边的integer是hotelId, 右边的Integer是roomNumber
		
	public void updateRoomData(HashMap<Integer, HashMap<Integer, RoomPO>> roomDataMap);
}
