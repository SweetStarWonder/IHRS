package data.dao;

import java.rmi.RemoteException;

import po.WebManagerPO;

public interface WebManagerDao extends java.rmi.Remote {
	
	/**
	 * @param userId  网站管理人员编号
	 * @return        获取对应的网站管理人员信息
	 * @throws RemoteException
	 */
	public WebManagerPO getWebManager(int userId) throws RemoteException;
	
	/**
	 * @param webManagerPO  网站管理人员信息
	 * @return              是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateWebManager(WebManagerPO webManagerPO) throws RemoteException;
	
}
