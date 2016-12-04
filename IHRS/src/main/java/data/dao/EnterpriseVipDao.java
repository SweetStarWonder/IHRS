package data.dao;

import java.rmi.RemoteException;

import po.EnterpriseVipPO;

public interface EnterpriseVipDao extends java.rmi.Remote {
	public EnterpriseVipPO getEnterpriseVip(int userId) throws RemoteException;
	
	public boolean addEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException;
	
	public boolean updateEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException;
	
	public boolean deleteEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException;
}
