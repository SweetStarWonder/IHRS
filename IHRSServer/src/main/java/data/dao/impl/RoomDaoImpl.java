package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.dao.RoomDao;
import data.dataHelper.DataFactory;
import data.dataHelper.RoomDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.RoomPO;

public class RoomDaoImpl extends java.rmi.server.UnicastRemoteObject implements RoomDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2691543892429399161L;

	private HashMap<Integer, HashMap<Integer, RoomPO>> map;
	
	private DataFactory dataFactory;
	
	private RoomDataHelper roomDataHelper;
	
	private static RoomDaoImpl roomDaoImpl;
	
	public static RoomDaoImpl getInstance() throws RemoteException {
		if (roomDaoImpl == null) {
			roomDaoImpl = new RoomDaoImpl();
		}
		return roomDaoImpl;
	}
	
	private RoomDaoImpl() throws RemoteException {
		if (map == null) {
			dataFactory = new DataFactoryImpl();
			roomDataHelper = dataFactory.getRoomDataHelper();
			map = roomDataHelper.getRoomData();
		}
	}

	public ArrayList<RoomPO> getRoomsByHotel(int hotelId) throws RemoteException {
		ArrayList<RoomPO> rooms = new ArrayList<RoomPO>();
		HashMap<Integer, RoomPO> roomMap = map.get(hotelId);
		Iterator<Integer> iterator = roomMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer integer = (Integer) iterator.next();
			rooms.add(roomMap.get(integer));
		}
		return rooms;
	}

	public ArrayList<RoomPO> getRoomByList(int listId) throws RemoteException {
		ArrayList<RoomPO> rooms = new ArrayList<RoomPO>();
		Iterator<Integer> outIterator = map.keySet().iterator();
		while (outIterator.hasNext()) {
			Integer hId = (Integer) outIterator.next();
			HashMap<Integer, RoomPO> roomMap = map.get(hId);
			Iterator<Integer> inIterator = roomMap.keySet().iterator();
			while (inIterator.hasNext()) {
				Integer num = (Integer) inIterator.next();
				if (roomMap.get(num).getListId() == listId) {
					rooms.add(roomMap.get(num));
				}
			}
		}
		return rooms;
	}

	public boolean addRoom(RoomPO roomPO) throws RemoteException {
		int hotel = roomPO.getHotelId();
		int num = roomPO.getRoomNum();
		HashMap<Integer, RoomPO> roomMap = map.get(hotel);
		if (roomMap.containsKey(num)) {
			return false;
		} else {
			roomMap.put(num, roomPO);
			map.put(hotel, roomMap);
			roomDataHelper.updateRoomData(map);
			return true;
		}
	}

	public boolean updateRoom(RoomPO roomPO) throws RemoteException {
		int hotel = roomPO.getHotelId();
		int num = roomPO.getRoomNum();
		HashMap<Integer, RoomPO> roomMap = map.get(hotel);
		if (roomMap.containsKey(num)) {
			roomMap.put(num, roomPO);
			map.put(hotel, roomMap);
			roomDataHelper.updateRoomData(map);
			return true;
		} else {
			return false;
		}
	}

}

