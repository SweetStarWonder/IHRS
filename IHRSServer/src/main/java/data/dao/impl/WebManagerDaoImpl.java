package data.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;

import data.dao.WebManagerDao;
import data.dataHelper.DataFactory;
import data.dataHelper.WebManagerDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.WebManagerPO;

public class WebManagerDaoImpl extends java.rmi.server.UnicastRemoteObject implements WebManagerDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8163166858594340183L;

	private HashMap<Integer, WebManagerPO> map;
	
	private DataFactory dataFactory;
	
	private WebManagerDataHelper webManagerDataHelper;
	
	private static WebManagerDaoImpl webManagerDaoImpl;
	
	public static WebManagerDaoImpl getInstance() throws RemoteException {
		if (webManagerDaoImpl == null) {
			webManagerDaoImpl = new WebManagerDaoImpl();
		}
		return webManagerDaoImpl;
	}
	
	private WebManagerDaoImpl() throws RemoteException {
		if (map == null) {
			dataFactory = new DataFactoryImpl();
			webManagerDataHelper = dataFactory.getWebManagerDataHelper();
			map = webManagerDataHelper.getWebManagerData();
		}
	}
	
	public boolean updateWebManager(WebManagerPO webManagerPO) throws RemoteException {
		int id = webManagerPO.getId();
		if (map.containsKey(id)) {
			map.put(id, webManagerPO);
			webManagerDataHelper.updateWebManagerData(map);
			return true;
		} else {
			return false;
		}
	}

	public WebManagerPO getWebManager(int userId) throws RemoteException {
		return map.get(userId);
	}

}

