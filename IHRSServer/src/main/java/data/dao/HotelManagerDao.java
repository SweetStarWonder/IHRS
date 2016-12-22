package data.dao;

import java.rmi.RemoteException;

import po.HotelManagerPO;

public interface HotelManagerDao extends java.rmi.Remote {
	
	/**
	 * @param hotelManagerId  酒店管理人员编号
	 * @return                对应的酒店管理人员信息
	 * @throws RemoteException
	 */
	public HotelManagerPO getHotelManagerByUser(int hotelManagerId) throws RemoteException;
	
	/**
	 * @param hotelId  酒店编号
	 * @return         对应酒店的酒店工作人员
	 * @throws RemoteException
	 */
	public HotelManagerPO getHotelManagerByHotel(int hotelId) throws RemoteException;
	
	/**
	 * @param hotelManagerPO  酒店管理人员信息
	 * @return                是否添加成功
	 * @throws RemoteException
	 */
	public boolean addHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException;
	
	/**
	 * @param hotelManagerPO  酒店管理人员信息
	 * @return                是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException;
	
}
