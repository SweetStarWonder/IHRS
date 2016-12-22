package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.NormalVipPO;

public interface NormalVipDao extends java.rmi.Remote {
	
	/**
	 * @param birthday  生日
	 * @return          匹配的所有普通会员
	 * @throws RemoteException
	 */
	public ArrayList<NormalVipPO> getNormaVips(String birthday) throws RemoteException;
	
	/**
	 * @param userId  普通会员编号
	 * @return        对应的普通会员信息
	 * @throws RemoteException
	 */
	public NormalVipPO getNormalVip(int userId) throws RemoteException;
	
	/**
	 * @param normalVipPO  普通会员信息
	 * @return             是否添加成功
	 * @throws RemoteException
	 */
	public boolean addNormalVip(NormalVipPO normalVipPO) throws RemoteException;
	
	/**
	 * @param normalVipPO  普通会员信息
	 * @return             是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateNormalVip(NormalVipPO normalVipPO) throws RemoteException;
	
	/**
	 * @param normalVipPO  普通会员信息
	 * @return             是否删除成功
	 * @throws RemoteException
	 */
	public boolean deleteNormalVip(NormalVipPO normalVipPO) throws RemoteException;
	
}
