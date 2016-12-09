package data.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;

import data.dao.EnterpriseVipDao;
import data.dataHelper.DataFactory;
import data.dataHelper.EnterpriseVipDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.EnterpriseVipPO;

public class EnterpriseVipDaoImpl extends java.rmi.server.UnicastRemoteObject implements EnterpriseVipDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8241559497563310298L;

	private HashMap<Integer,EnterpriseVipPO> map;
	
	private EnterpriseVipDataHelper enterpriseVipDataHelper;
	
	private DataFactory dataFactory;
	
	private static EnterpriseVipDaoImpl enterpriseVipDaoImpl;

	public static EnterpriseVipDaoImpl getInstance() throws RemoteException{
		if(enterpriseVipDaoImpl==null){
			enterpriseVipDaoImpl=new EnterpriseVipDaoImpl();
		}
		return enterpriseVipDaoImpl;
	}
	private EnterpriseVipDaoImpl() throws RemoteException {
		if(map==null){
			dataFactory=new DataFactoryImpl();
			enterpriseVipDataHelper=dataFactory.getEnterpriseVipDataHelper();
			map=enterpriseVipDataHelper.getEnterpriseVipData();
		}
	}

	public EnterpriseVipPO getEnterpriseVip(int userId) throws RemoteException {
		if (map.containsKey(userId)) {
			EnterpriseVipPO enterpriseVipPO=map.get(userId);
			return enterpriseVipPO;			
		} else {
			return null;
		}
	}

	public boolean addEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
		int id=enterpriseVipPO.getId();
		if(!map.containsKey(id)){
			map.put(id,enterpriseVipPO);
			enterpriseVipDataHelper.updateEnterpriseVipData(map);
			return true;
		}
		return false;
	}

	public boolean updateEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
		int id=enterpriseVipPO.getId();
		if(map.containsKey(id)){
			map.put(id,enterpriseVipPO);
			enterpriseVipDataHelper.updateEnterpriseVipData(map);
			return true;
		}
		return false;
	}

	public boolean deleteEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
		int id=enterpriseVipPO.getId();
		if (map.containsKey(id)) {
			map.remove(id);
			enterpriseVipDataHelper.updateEnterpriseVipData(map);
			return true;
		}
		return false;
	}

}
