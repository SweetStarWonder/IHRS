package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.dao.RoomDao;
import data.dataHelper.DataFactory;
import data.dataHelper.RoomDataHelper;
import data.dataHelper.RoomInListDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.ListPO;
import po.RoomPO;

public class RoomDaoImpl extends java.rmi.server.UnicastRemoteObject implements RoomDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2691543892429399161L;
    
	//左酒店编号，右房间号
	private HashMap<Integer, HashMap<Integer, RoomPO>> map;
	
	//左订单编号，右左酒店编号，右右房间号
	private HashMap<Integer, HashMap<Integer, ArrayList<Integer>>> roomInListMap;
	
	private DataFactory dataFactory;
	
	private RoomDataHelper roomDataHelper;
	
	private RoomInListDataHelper roomInListDataHelper;
	
	private static RoomDaoImpl roomDaoImpl;
	
	public static RoomDaoImpl getInstance() throws RemoteException {
		if (roomDaoImpl == null) {
			roomDaoImpl = new RoomDaoImpl();
		}
		return roomDaoImpl;
	}
	
	private RoomDaoImpl() throws RemoteException {
		if ((map == null) && (roomInListMap == null)) {
			dataFactory = new DataFactoryImpl();
			roomDataHelper = dataFactory.getRoomDataHelper();
			roomInListDataHelper = dataFactory.getRoomInListDataHelper();
			map = roomDataHelper.getRoomData();
			roomInListMap = roomInListDataHelper.getRooms();
		}
	}

	public ArrayList<RoomPO> getRoomsByHotel(int hotelId) throws RemoteException {
		ArrayList<RoomPO> rooms = new ArrayList<RoomPO>();
		if (map.containsKey(hotelId)) {
			HashMap<Integer, RoomPO> roomMap = map.get(hotelId);
			Iterator<Integer> iterator = roomMap.keySet().iterator();
			while (iterator.hasNext()) {
				Integer integer = (Integer) iterator.next();
				rooms.add(roomMap.get(integer));
			}	
		}
		return rooms;
	}

	public ArrayList<RoomPO> getRoomByList(int listId) throws RemoteException {
		ArrayList<RoomPO> rooms = new ArrayList<RoomPO>();
//		Iterator<Integer> outIterator = map.keySet().iterator();
//		while (outIterator.hasNext()) {
//			Integer hId = (Integer) outIterator.next();
//			HashMap<Integer, RoomPO> roomMap = map.get(hId);
//			Iterator<Integer> inIterator = roomMap.keySet().iterator();
//			while (inIterator.hasNext()) {
//				Integer num = (Integer) inIterator.next();
//				if (roomMap.get(num).getListId() == listId) {
//					rooms.add(roomMap.get(num));
//				}
//			}
//		}
		HashMap<Integer, ArrayList<Integer>> map1=new HashMap<Integer, ArrayList<Integer>>();
		map1 = roomInListMap.get(listId);
		Iterator<Integer> iterator = map1.keySet().iterator();
		while(iterator.hasNext()){
			Integer hId = (Integer) iterator.next();
			ArrayList<Integer> roomNums = new ArrayList<Integer>();
			roomNums = map1.get(hId);
			for (Integer integer : roomNums) {
				HashMap<Integer,RoomPO> roomMap = map.get(hId);
				Iterator<Integer> it = roomMap.keySet().iterator();
				while(it.hasNext()){
					Integer rId = (Integer) it.next();
					if(rId == integer){
						rooms.add(roomMap.get(integer));
					}
				}
			}
		}
		return rooms;
	}

	public boolean addRoom(RoomPO roomPO) throws RemoteException {
		int hotel = roomPO.getHotelId();
		int num = roomPO.getRoomNum();
		HashMap<Integer, RoomPO> roomMap;
		if (map.containsKey(hotel)) {
			roomMap = map.get(hotel);			
		} else {
			roomMap = new HashMap<Integer, RoomPO>();
		}
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

	@Override
	public boolean updateRoom(ListPO listPO, ArrayList<RoomPO> rooms) throws RemoteException{
		int hotel = listPO.getHotelId();
		int list = listPO.getListId();
		HashMap<Integer, ArrayList<Integer>> intMap = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> r = new ArrayList<Integer>();
		for (RoomPO roomPO : rooms) {
			r.add(roomPO.getRoomNum());
		}
		intMap.put(hotel,r);
		roomInListMap.put(list,intMap);
		roomInListDataHelper.updateRoom(roomInListMap);
		return true;
	}

}

