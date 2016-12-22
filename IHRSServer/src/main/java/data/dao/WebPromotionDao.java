package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotionPO.WebPromotionPO;

public interface WebPromotionDao extends java.rmi.Remote {
	
	/**
	 * @return  获取所有网站促销策略
	 * @throws RemoteException
	 */
	public ArrayList<WebPromotionPO> getWebPromotions() throws RemoteException;
	
	/**
	 * @param webPromotionPO  网站促销策略
	 * @return                是否添加成功
	 * @throws RemoteException
	 */
	public boolean addWebPromotion(WebPromotionPO webPromotionPO) throws RemoteException;
	
	/**
	 * @param webPromotionPO  网站促销策略
	 * @return                是否删除成功
	 * @throws RemoteException
	 */
	public boolean deleteWebPromotion(WebPromotionPO webPromotionPO) throws RemoteException;
	
}
