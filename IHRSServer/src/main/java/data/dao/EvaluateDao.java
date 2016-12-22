package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.EvaluatePO;

public interface EvaluateDao extends java.rmi.Remote {
	
	/**
	 * @param hotelId  酒店编号
	 * @return         酒店所有评价
	 * @throws RemoteException
	 */
	public ArrayList<EvaluatePO> getEvaluates(int hotelId) throws RemoteException;
	
	/**
	 * @param evaluatePO  评价信息
	 * @return            是否添加成功
	 * @throws RemoteException
	 */
	public boolean addEvaluate(EvaluatePO evaluatePO) throws RemoteException;
	
}
