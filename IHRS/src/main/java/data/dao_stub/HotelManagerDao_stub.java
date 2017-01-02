package data.dao_stub;

import java.rmi.RemoteException;

import data.dao.HotelManagerDao;
import po.HotelManagerPO;

public class HotelManagerDao_stub implements HotelManagerDao{

	@Override
	public HotelManagerPO getHotelManagerByUser(int hotelManagerId) throws RemoteException {
		// TODO Auto-generated method stub
		return new HotelManagerPO(hotelManagerId, "hotelManagerName", "phone", 2222);
	}

	@Override
	public HotelManagerPO getHotelManagerByHotel(int hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		return new HotelManagerPO(00003, "hotelManagerName", "phone", hotelId);
	}

	@Override
	public boolean addHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
