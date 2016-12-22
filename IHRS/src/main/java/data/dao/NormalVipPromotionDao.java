package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotionPO.NormalVipPromotionPO;

public interface NormalVipPromotionDao extends java.rmi.Remote {
	
	/**
	 * @param rankValue  等级
	 * @return           匹配的所有普通会员促销策略
	 * @throws RemoteException
	 */
	public  ArrayList<NormalVipPromotionPO> getNormalVipPromotions(int rankValue) throws RemoteException;
	
	/**
	 * @param normalVipPromotionPO  普通会员促销策略
	 * @return                      是否修改成功
	 * @throws RemoteException
	 */
	public boolean updateNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException;
	
	/**
	 * @param normalVipPromotionPO  普通会员促销策略
	 * @return                      是否添加成功
	 * @throws RemoteException
	 */
	public boolean addNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException;
	
	/**
	 * @param normalVipPromotionPO  普通会员促销策略
	 * @return                      是否删除成功
	 * @throws RemoteException
	 */
	public boolean deleteNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException;
	
}
