package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.WebPromotionDao;
import data.dataHelper.DataFactory;
import data.dataHelper.WebPromotionDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.promotionPO.WebPromotionPO;

public class WebPromotionDaoImpl extends java.rmi.server.UnicastRemoteObject implements WebPromotionDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private ArrayList<WebPromotionPO> webPromotionPOs;
	
	private WebPromotionDataHelper webPromotionDataHelper;
	
	private DataFactory dataFactory;
	
	private static WebPromotionDaoImpl webPromotionDaoImpl;
	
	public static WebPromotionDaoImpl getInstance() throws RemoteException{
		if(webPromotionDaoImpl==null){
			webPromotionDaoImpl=new WebPromotionDaoImpl();
		}
		return webPromotionDaoImpl;
	}

	private WebPromotionDaoImpl() throws RemoteException{
		if(webPromotionPOs==null){
			dataFactory=new DataFactoryImpl();
			webPromotionDataHelper=dataFactory.getWebPromotionDataHelper();
			webPromotionPOs=webPromotionDataHelper.getWebPromotionData();
		}
	}

	public ArrayList<WebPromotionPO> getWebPromotions() throws RemoteException {
		return webPromotionPOs;
	}

	public boolean addWebPromotion(WebPromotionPO webPromotionPO) throws RemoteException {
		if(!webPromotionPOs.contains(webPromotionPO)){
			webPromotionPOs.add(webPromotionPO);
			webPromotionDataHelper.updateWebPromotionData(webPromotionPOs);
			return true;
		}
		return false;
	}

	public boolean deleteWebPromotion(WebPromotionPO webPromotionPO) throws RemoteException {
		if(webPromotionPOs.contains(webPromotionPO)){
			webPromotionPOs.remove(webPromotionPO);
			webPromotionDataHelper.updateWebPromotionData(webPromotionPOs);
			return true;
		}
		return false;
	}

}
