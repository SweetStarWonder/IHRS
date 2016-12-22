package data.dao;

import java.rmi.RemoteException;

import po.CustomerPO;

public interface CustomerDao extends java.rmi.Remote{
	
	/**
	 * @param userId  客户编号
	 * @return        客户信息
	 * @throws RemoteException
	 */
	public CustomerPO getCustomer(int userId) throws RemoteException;
	
	/**
	 * @param userName  客户名
	 * @return          客户信息
	 * @throws RemoteException
	 */
	public CustomerPO getCustomer(String userName) throws RemoteException;
	
	/**
	 * @param customerPO  客户信息
	 * @return            是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateCustomer(CustomerPO customerPO) throws RemoteException;
	
	/**
	 * @param customerPO  客户信息
	 * @return            是否添加成功
	 * @throws RemoteException
	 */
	public boolean addCustomer(CustomerPO customerPO) throws RemoteException;
	
}
