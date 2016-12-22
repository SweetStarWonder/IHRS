package data.dao;

import java.rmi.RemoteException;
import java.util.HashMap;

import po.ListPO;

public interface ListDao extends java.rmi.Remote {
	
	/**
	 * @return  获取客户所有订单（左客户编号）
	 * @throws RemoteException
	 */
	public HashMap<Integer,ListPO> getAllLists() throws RemoteException;
	
	/**
	 * @param listId  订单编号
	 * @return        获取对应的订单
	 * @throws RemoteException
	 */
	public ListPO getList(int listId) throws RemoteException;
	
	/**
	 * @param userId  客户编号
	 * @return        获取对应的订单（左客户编号）
	 * @throws RemoteException
	 */
	public HashMap<Integer,ListPO> getListsByUser(int userId) throws RemoteException;
	
	/**
	 * @param hotelId  酒店编号
	 * @return         获取对应的订单（左酒店编号）
	 * @throws RemoteException
	 */
	public HashMap<Integer,ListPO> getListsByHotel(int hotelId) throws RemoteException;
	
	/**
	 * @param listPO  订单信息
	 * @return        是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateList(ListPO listPO) throws RemoteException;
	
	/**
	 * @param listPO  订单信息
	 * @return        是否添加成功
	 * @throws RemoteException
	 */
	public boolean addList(ListPO listPO) throws RemoteException;
	
}
