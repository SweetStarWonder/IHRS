package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CreditChangePO;

public interface CreditChangeDao extends java.rmi.Remote{
	
	public ArrayList<CreditChangePO> getCreditChange(int userId) throws RemoteException;
	
	public boolean addCreditChange(CreditChangePO creditChangePO) throws RemoteException;
}
