package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.RoomDataHelper;
import po.RoomPO;
import po.RoomStatus;

public class RoomDataHelper_stub implements RoomDataHelper{

	@Override
	public HashMap<Integer, HashMap<Integer, RoomPO>> getRoomData() {
		// TODO Auto-generated method stub
		HashMap<Integer, RoomPO> hashMap1 = new HashMap<>();
		RoomPO roomPO = new RoomPO(2222, 00002, 503, 500, RoomStatus.DOUBLE);
		hashMap1.put(503, roomPO);
		HashMap<Integer, HashMap<Integer, RoomPO>> hashMap = new HashMap<>();
		hashMap.put(2222, hashMap1);
		return hashMap;
	}

	@Override
	public void updateRoomData(HashMap<Integer, HashMap<Integer, RoomPO>> roomDataMap) {
		// TODO Auto-generated method stub
		
	}

}
