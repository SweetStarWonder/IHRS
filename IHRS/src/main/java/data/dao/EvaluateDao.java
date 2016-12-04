package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.EvaluatePO;

public interface EvaluateDao extends java.rmi.Remote {
	public ArrayList<EvaluatePO> getEvaluates(int hotelId) throws RemoteException;
	
	public boolean addEvaluate(EvaluatePO evaluatePO) throws RemoteException;
}
