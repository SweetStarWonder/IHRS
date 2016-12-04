package data.dao;

import java.rmi.RemoteException;
import java.util.HashMap;

import po.ListPO;

public interface ListDao extends java.rmi.Remote {
	
	public HashMap<Integer,ListPO> getAllLists() throws RemoteException;
	
	public ListPO getList(int listId) throws RemoteException;
	
	public HashMap<Integer,ListPO> getListsByUser(int userId) throws RemoteException;
	
	public HashMap<Integer,ListPO> getListsByHotel(int hotelId) throws RemoteException;
	
	public boolean updateList(ListPO listPO) throws RemoteException;
	
	public boolean addList(ListPO listPO) throws RemoteException;
}
