package data.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;

import data.dao.WebSaleDao;
import data.dataHelper.DataFactory;
import data.dataHelper.WebSaleDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.WebSalePO;

public class WebSaleDaoImpl extends java.rmi.server.UnicastRemoteObject implements WebSaleDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7269906067208064984L;

	private HashMap<Integer, WebSalePO> mapById;
	
	private HashMap<String, WebSalePO> mapByName;
	
	private WebSaleDataHelper webSaleDataHelper;
	
	private DataFactory dataFactory;
	
	private static WebSaleDaoImpl webSaleDaoImpl;
	
	public static WebSaleDaoImpl getInstance() throws RemoteException{
		if (webSaleDaoImpl == null) {
			webSaleDaoImpl = new WebSaleDaoImpl();
		}
		return webSaleDaoImpl;
	}
	
	private WebSaleDaoImpl() throws RemoteException {
		if (mapById == null || mapByName == null) {
			dataFactory = new DataFactoryImpl();
			webSaleDataHelper = dataFactory.getWebSaleDataHelper();
			mapById = webSaleDataHelper.getWebSaleDataById();
			mapByName = webSaleDataHelper.getWebSaleDataByName();
		}
	}

	public WebSalePO getWebSale(int userId) throws RemoteException {
		return mapById.get(userId);
	}

	public WebSalePO getWebSale(String userName) throws RemoteException {
		return mapByName.get(userName);
	}

	public boolean addWebSale(WebSalePO webSalePO) throws RemoteException {
		int id = webSalePO.getId();
		String name = webSalePO.getUserName();
		if (mapById.containsKey(id)) {
			return false;
		} else {
			mapById.put(id, webSalePO);
			mapByName.put(name, webSalePO);
			webSaleDataHelper.updateWebSaleDataById(mapById);
			return true;
		}
	}

	public boolean updateWebSale(WebSalePO webSalePO) throws RemoteException {
		int id = webSalePO.getId();
		String name = webSalePO.getUserName();
		if (mapById.containsKey(id)) {
			mapById.put(id, webSalePO);
			mapByName.put(name, webSalePO);
			webSaleDataHelper.updateWebSaleDataById(mapById);
			return true;
		} else {
			return false;
		}
	}

}

