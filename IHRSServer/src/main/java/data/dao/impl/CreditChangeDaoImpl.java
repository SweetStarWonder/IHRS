package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import data.dao.CreditChangeDao;
import data.dataHelper.CreditChangeDataHelper;
import data.dataHelper.DataFactory;
import data.dataHelper.impl.DataFactoryImpl;
import po.CreditChangePO;

public class CreditChangeDaoImpl extends java.rmi.server.UnicastRemoteObject implements CreditChangeDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6238329739406926309L;

	private HashMap<Integer,ArrayList<CreditChangePO>> map;
	
	private CreditChangeDataHelper creditChangeDataHelper;
	
	private DataFactory dataFactory;
	
	private static CreditChangeDaoImpl creditChangeDaoImpl;
	
	public static CreditChangeDaoImpl getInstance() throws RemoteException{
		if(creditChangeDaoImpl == null){
			creditChangeDaoImpl = new CreditChangeDaoImpl();
		}
		return creditChangeDaoImpl;
	}
	
	private CreditChangeDaoImpl() throws RemoteException {
		if(map == null){
			dataFactory = new DataFactoryImpl();
			creditChangeDataHelper = dataFactory.getCreditChangeDataHelper();
			map = creditChangeDataHelper.getCreditChangeData();
		}
	}

	public ArrayList<CreditChangePO> getCreditChange(int userId) throws RemoteException {
		if(map.containsKey(userId)) {
			ArrayList<CreditChangePO> creditChange=map.get(userId);
			return creditChange;
		} else {
			return new ArrayList<CreditChangePO>();
		}
	}

	public boolean addCreditChange(CreditChangePO creditChangePO) throws RemoteException {
		ArrayList<CreditChangePO> creditChanges;
		int userId=creditChangePO.getUserId();
		if (map.containsKey(userId)) {
			creditChanges = map.get(userId);
		} else {
			creditChanges = new ArrayList<CreditChangePO>();
		}
		creditChanges.add(creditChangePO);
		map.put(userId,creditChanges);
		creditChangeDataHelper.updateCreditChangeData(map);
		return true;
	}
}