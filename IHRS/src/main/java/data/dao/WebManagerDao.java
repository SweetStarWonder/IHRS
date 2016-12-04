package data.dao;

import java.rmi.RemoteException;

import po.WebManagerPO;

public interface WebManagerDao extends java.rmi.Remote {
	
	public WebManagerPO getWebManager(int userId) throws RemoteException;
	
	public boolean updateWebManager(WebManagerPO webManagerPO) throws RemoteException;
}
