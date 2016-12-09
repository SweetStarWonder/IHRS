package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import data.dao.HotelPromotionDao;
import data.dataHelper.DataFactory;
import data.dataHelper.HotelPromotionDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.promotionPO.HotelPromotionPO;

public class HotelPromotionDaoImpl extends java.rmi.server.UnicastRemoteObject implements HotelPromotionDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5677320944712104257L;

	private HashMap<Integer, ArrayList<HotelPromotionPO>> map;
	
	private HotelPromotionDataHelper hotelPromotionDataHelper;
	
	private DataFactory dataFactory;
	
	private static HotelPromotionDaoImpl hotelPromotionDaoImpl;
	
	public static HotelPromotionDaoImpl getInstance() throws RemoteException{
		if(hotelPromotionDaoImpl == null) {
			hotelPromotionDaoImpl = new HotelPromotionDaoImpl();
		}
		return hotelPromotionDaoImpl;
	}
	
	private HotelPromotionDaoImpl() throws RemoteException{
		if (map == null) {
			dataFactory = new DataFactoryImpl();
			hotelPromotionDataHelper = dataFactory.getHotelPromotionDataHelper();
			map = hotelPromotionDataHelper.getHotelPromotionData();
		}
	}

	public ArrayList<HotelPromotionPO> getHotelPromotions(int hotelId) throws RemoteException {
		ArrayList<HotelPromotionPO> promotionPOs;
		if (map.containsKey(hotelId)) {
			promotionPOs = map.get(hotelId);
		} else {
			promotionPOs = new ArrayList<HotelPromotionPO>();
		}
		return promotionPOs;
	}

	public boolean addHotelPromotion(HotelPromotionPO hotelPromotionPO) throws RemoteException {
		int hotelId = hotelPromotionPO.getHotelId();
		ArrayList<HotelPromotionPO> promotionPOs;
		if (map.containsKey(hotelId)) {
			promotionPOs = map.get(hotelId);
		} else {
			promotionPOs = new ArrayList<HotelPromotionPO>();
		}
		promotionPOs.add(hotelPromotionPO);
		map.put(hotelId, promotionPOs);
		hotelPromotionDataHelper.updateHotelPromotionData(map);
		return true;
	}

	public boolean deleteHotelPromotion(HotelPromotionPO hotelPromotionPO) throws RemoteException {
		int hotelId = hotelPromotionPO.getHotelId();
		ArrayList<HotelPromotionPO> promotionPOs;
		if(map.containsKey(hotelId)) {
			promotionPOs = map.get(hotelId);
			if (promotionPOs.contains(hotelPromotionPO)) {
				promotionPOs.remove(hotelPromotionPO);
				map.put(hotelId, promotionPOs);
				hotelPromotionDataHelper.updateHotelPromotionData(map);
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
}
