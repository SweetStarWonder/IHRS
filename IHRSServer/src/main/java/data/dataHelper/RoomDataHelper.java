package data.dataHelper;

import java.util.HashMap;

import po.RoomPO;

public interface RoomDataHelper {

	/**
	 * @return  酒店所有房间信息（左酒店编号，右房间编号）
	 */
	public HashMap<Integer, HashMap<Integer, RoomPO>> getRoomData();
		
	/**
	 * @param roomDataMap  酒店所有房间信息（左酒店编号，右房间编号）
	 */
	public void updateRoomData(HashMap<Integer, HashMap<Integer, RoomPO>> roomDataMap);
	
}
