package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotionPO.HotelPromotionPO;

public interface HotelPromotionDao extends java.rmi.Remote {
	
	/**
	 * @param hotelId  酒店编号
	 * @return         对应酒店的所有酒店策略
	 * @throws RemoteException
	 */
	public ArrayList<HotelPromotionPO> getHotelPromotions(int hotelId) throws RemoteException;
		
	/**
	 * @param hotelPromotionPO  酒店促销策略
	 * @return                  是否添加成功
	 * @throws RemoteException
	 */
	public boolean addHotelPromotion(HotelPromotionPO hotelPromotionPO) throws RemoteException;
	
	/**
	 * @param hotelPromotionPO  酒店促销策略
	 * @return                  是否删除成功
	 * @throws RemoteException
	 */
	public boolean deleteHotelPromotion(HotelPromotionPO hotelPromotionPO) throws RemoteException;
	
}
