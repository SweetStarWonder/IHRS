package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.RoomPO;

public interface RoomDao extends java.rmi.Remote {
	
	public ArrayList<RoomPO> getRoomsByHotel(int hotelId) throws RemoteException;
	
	public ArrayList<RoomPO> getRoomByList(int listId) throws RemoteException;
	
	public boolean addRoom(RoomPO roomPO) throws RemoteException;
	
	public boolean updateRoom(RoomPO roomPO) throws RemoteException;
}
