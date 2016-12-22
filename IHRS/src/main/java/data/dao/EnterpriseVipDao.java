package data.dao;

import java.rmi.RemoteException;

import po.EnterpriseVipPO;

public interface EnterpriseVipDao extends java.rmi.Remote {
	
	/**
	 * @param userId  企业会员编号
	 * @return        企业会员信息
	 * @throws RemoteException
	 */
	public EnterpriseVipPO getEnterpriseVip(int userId) throws RemoteException;
	
	/**
	 * @param enterpriseVipPO  企业会员信息
	 * @return                 是否添加成功
	 * @throws RemoteException
	 */
	public boolean addEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException;
	
	/**
	 * @param enterpriseVipPO  企业会员信息
	 * @return                 是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException;
	
	/**
	 * @param enterpriseVipPO  企业会员信息
	 * @return                 是否删除成功
	 * @throws RemoteException
	 */
	public boolean deleteEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException;
	
}
