package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotionPO.NormalVipPromotionPO;

public interface NormalVipPromotionDao extends java.rmi.Remote {
	
	public  ArrayList<NormalVipPromotionPO> getNormalVipPromotions(int rankValue) throws RemoteException;
	
	public boolean updateNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException;
	
	public boolean addNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException;
	
	public boolean deleteNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException;
	
}
