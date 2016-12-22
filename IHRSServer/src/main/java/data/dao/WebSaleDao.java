package data.dao;

import java.rmi.RemoteException;

import po.WebSalePO;

public interface WebSaleDao extends java.rmi.Remote {
	
	/**
	 * @param userId  网站营销人员编号
	 * @return        获取对应的网站营销人员信息
	 * @throws RemoteException
	 */
	public WebSalePO getWebSale(int userId) throws RemoteException;
	
	/**
	 * @param userName  网站营销人员用户名
	 * @return          获取对应的网站营销人员信息
	 * @throws RemoteException
	 */
	public WebSalePO getWebSale(String userName) throws RemoteException;
	
	/**
	 * @param webSalePO  网站营销人员信息
	 * @return           是否添加成功
	 * @throws RemoteException
	 */
	public boolean addWebSale(WebSalePO webSalePO) throws RemoteException;
	
	/**
	 * @param webSalePO  网站营销人员信息
	 * @return           是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateWebSale(WebSalePO webSalePO) throws RemoteException;
	
}
