package data.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;

import data.dao.ListDao;
import data.dataHelper.DataFactory;
import data.dataHelper.ListDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.ListPO;

public class ListDaoImpl extends java.rmi.server.UnicastRemoteObject implements ListDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5795629413152496175L;
	
	private HashMap<Integer, ListPO> allMap;

	private HashMap<Integer, HashMap<Integer, ListPO>> mapByUser;
	
	private HashMap<Integer, HashMap<Integer, ListPO>> mapByHotel;
	
	
	private ListDataHelper listDataHelper;
	
	private DataFactory dataFactory;
	
	private static ListDaoImpl listDaoImpl;
	
	public  static ListDaoImpl getInstance() throws RemoteException {
		if(listDaoImpl == null) {
			listDaoImpl = new ListDaoImpl();
		}
		return listDaoImpl;
	}
	
	private ListDaoImpl() throws RemoteException {
		if(mapByUser == null || mapByHotel == null) {
			dataFactory = new DataFactoryImpl();
			listDataHelper = dataFactory.getListDataHelper();
			mapByHotel = listDataHelper.getListDataByHotel();
			mapByUser = listDataHelper.getListDataByUser();
			
			allMap = new HashMap<Integer, ListPO>();
			Iterator<Integer> outIer = mapByUser.keySet().iterator();
			while (outIer.hasNext()) {
				Integer userId = (Integer) outIer.next();
				HashMap<Integer, ListPO> userLists = mapByUser.get(userId);
				Iterator<Integer> inIterator = userLists.keySet().iterator();
				while (inIterator.hasNext()) {
					Integer listId = (Integer) inIterator.next();
					allMap.put(listId, userLists.get(listId));
				}
			}
		}
	}

	public ListPO getList(int listId) throws RemoteException {
		ListPO listPO = null;
		Iterator<Integer> iterator = mapByUser.keySet().iterator();
		while (iterator.hasNext()) {
			Integer key = (Integer)iterator.next();
			if (mapByUser.get(key).containsKey(listId)) {
				listPO = mapByUser.get(key).get(listId);
				break;
			}
		}
		return listPO;
	}

	public HashMap<Integer, ListPO> getListsByUser(int userId) throws RemoteException {
		return mapByUser.get(userId);
	}

	public HashMap<Integer, ListPO> getListsByHotel(int hotelId) throws RemoteException {
		return mapByHotel.get(hotelId);
	}

	public boolean updateList(ListPO listPO) throws RemoteException {
		int user = listPO.getUserId();
		int hotel = listPO.getHotelId();
		int id = listPO.getListId();
		HashMap<Integer, ListPO> listMapU = mapByUser.get(user);
		HashMap<Integer, ListPO> listMapH = mapByHotel.get(hotel);
		if (listMapU.containsKey(id)) {
			listMapU.put(id, listPO);
			mapByUser.put(user, listMapU);
			listMapH.put(id, listPO);
			mapByHotel.put(hotel, listMapH);
			listDataHelper.updateListDataByUser(mapByUser);
			return true;
		} else {
			return false;
		}
		
	}

	public boolean addList(ListPO listPO) throws RemoteException {
		int user = listPO.getUserId();
		int hotel = listPO.getHotelId();
		int id = listPO.getListId();
		HashMap<Integer, ListPO> listMapU = mapByUser.get(user);
		HashMap<Integer, ListPO> listMapH = mapByHotel.get(hotel);
		if (listMapU.containsKey(id)) {
			return false;
		} else {
			listMapU.put(id, listPO);
			mapByUser.put(user, listMapU);
			listMapH.put(id, listPO);
			mapByHotel.put(hotel, listMapH);
			listDataHelper.updateListDataByUser(mapByUser);
			return true;
		}
	}

	public HashMap<Integer, ListPO> getAllLists() throws RemoteException {
		return this.allMap;
	}

}
