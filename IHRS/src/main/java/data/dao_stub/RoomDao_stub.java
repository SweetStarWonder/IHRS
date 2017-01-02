package data.dao_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.RoomDao;
import po.ListPO;
import po.RoomPO;
import po.RoomStatus;

public class RoomDao_stub implements RoomDao{

	@Override
	public ArrayList<RoomPO> getRoomsByHotel(int hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<RoomPO> arrayList = new ArrayList<>();
		RoomPO roomPO = new RoomPO(hotelId, 00002, 503, 500, RoomStatus.DOUBLE);
		arrayList.add(roomPO);
		return arrayList;
	}

	@Override
	public ArrayList<RoomPO> getRoomByList(int listId) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<RoomPO> arrayList = new ArrayList<>();
		RoomPO roomPO = new RoomPO(2222, listId, 503, 500, RoomStatus.DOUBLE);
		arrayList.add(roomPO);
		return arrayList;
	}

	@Override
	public boolean addRoom(RoomPO roomPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateRoom(RoomPO roomPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateRoom(ListPO listPO, ArrayList<RoomPO> rooms) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
