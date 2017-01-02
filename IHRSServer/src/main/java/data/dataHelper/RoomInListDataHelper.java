package data.dataHelper;

import java.util.ArrayList;
import java.util.HashMap;

public interface RoomInListDataHelper {
	
	/**
	 * @return  根据对订单编号获取房间（左订单编号，右左酒店编号，右右房间号）
	 */
	public HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> getRooms();
	
	/**
	 * @param roomMap  更新房间信息
	 */
	public void updateRoom(HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> roomMap);
	
}
