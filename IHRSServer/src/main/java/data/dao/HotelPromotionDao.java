package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.promotionPO.HotelPromotionPO;

public interface HotelPromotionDao extends java.rmi.Remote {
	
	public ArrayList<HotelPromotionPO> getHotelPromotions(int hotelId) throws RemoteException;
		
	public boolean addHotelPromotion(HotelPromotionPO hotelPromotionPO) throws RemoteException;
	
	public boolean deleteHotelPromotion(HotelPromotionPO hotelPromotionPO) throws RemoteException;
	
}
