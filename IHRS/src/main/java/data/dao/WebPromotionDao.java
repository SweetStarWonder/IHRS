package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotionPO.WebPromotionPO;

public interface WebPromotionDao extends java.rmi.Remote {
	
	public ArrayList<WebPromotionPO> getWebPromotions() throws RemoteException;
	
	public boolean addWebPromotion(WebPromotionPO webPromotionPO) throws RemoteException;
	
	public boolean deleteWebPromotion(WebPromotionPO webPromotionPO) throws RemoteException;
	
}
