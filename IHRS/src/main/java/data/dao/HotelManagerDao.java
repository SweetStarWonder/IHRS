package data.dao;

import java.rmi.RemoteException;

import po.HotelManagerPO;

public interface HotelManagerDao extends java.rmi.Remote {
	
	public HotelManagerPO getHotelManagerByUser(int hotelManagerId) throws RemoteException;
	
	public HotelManagerPO getHotelManagerByHotel(int hotelId) throws RemoteException;
	
	public boolean addHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException;
	
	public boolean updateHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException;
}
