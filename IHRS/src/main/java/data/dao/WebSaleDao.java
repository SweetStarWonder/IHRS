package data.dao;

import java.rmi.RemoteException;

import po.WebSalePO;

public interface WebSaleDao extends java.rmi.Remote {
	public WebSalePO getWebSale(int userId) throws RemoteException;
	
	public WebSalePO getWebSale(String userName) throws RemoteException;
	
	public boolean addWebSale(WebSalePO webSalePO) throws RemoteException;
	
	public boolean updateWebSale(WebSalePO webSalePO) throws RemoteException;
}
