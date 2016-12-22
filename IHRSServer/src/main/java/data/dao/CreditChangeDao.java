package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditChangePO;

public interface CreditChangeDao extends java.rmi.Remote{
	
	/**
	 * @param userId  客户编号
	 * @return        客户所有信用变化
	 * @throws RemoteException
	 */
	public ArrayList<CreditChangePO> getCreditChange(int userId) throws RemoteException;
	
	/**
	 * @param creditChangePO  信用变化记录
	 * @return                是否添加成功
	 * @throws RemoteException
	 */
	public boolean addCreditChange(CreditChangePO creditChangePO) throws RemoteException;
	
}
