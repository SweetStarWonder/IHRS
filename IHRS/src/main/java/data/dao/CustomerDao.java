package data.dao;

import java.rmi.RemoteException;

import po.CustomerPO;

public interface CustomerDao extends java.rmi.Remote{
	
	public CustomerPO getCustomer(int userId) throws RemoteException;
	
	public CustomerPO getCustomer(String userName) throws RemoteException;
	
	public boolean updateCustomer(CustomerPO customerPO) throws RemoteException;
	
	public boolean addCustomer(CustomerPO customerPO) throws RemoteException;
}
