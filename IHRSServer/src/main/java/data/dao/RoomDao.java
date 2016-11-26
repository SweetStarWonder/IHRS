package data.dao;

import java.util.ArrayList;

import po.RoomPO;

public interface RoomDao {
	
	public ArrayList<RoomPO> getRoomsByHotel(int hotelId);
	
	public ArrayList<RoomPO> getRoomByList(int listId);
	
	public boolean addRoom(RoomPO roomPO);
	
	public boolean updateRoom(RoomPO roomPO);
}
