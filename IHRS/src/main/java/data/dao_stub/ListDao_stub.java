package data.dao_stub;

import java.rmi.RemoteException;
import java.util.HashMap;

import data.dao.ListDao;
import po.ListPO;
import po.ListStatus;

public class ListDao_stub implements ListDao{

	@Override
	public HashMap<Integer, ListPO> getAllLists() throws RemoteException {
		// TODO Auto-generated method stub
		ListPO listPO = new ListPO(00002, 2222, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true);
		HashMap<Integer, ListPO> hashMap = new HashMap<>();
		hashMap.put(00002, listPO);
		return hashMap;
}

	@Override
	public ListPO getList(int listId) throws RemoteException {
		// TODO Auto-generated method stub
		return new ListPO(listId, 2222, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true);
	}

	@Override
	public HashMap<Integer, ListPO> getListsByUser(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		ListPO listPO = new ListPO(00002, 2222, userId, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true);
		HashMap<Integer, ListPO> hashMap = new HashMap<>();
		hashMap.put(userId, listPO);
		return hashMap;
	}

	@Override
	public HashMap<Integer, ListPO> getListsByHotel(int hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		ListPO listPO = new ListPO(00002, hotelId, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true);
		HashMap<Integer, ListPO> hashMap = new HashMap<>();
		hashMap.put(hotelId, listPO);
		return hashMap;
	}

	@Override
	public boolean updateList(ListPO listPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addList(ListPO listPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
