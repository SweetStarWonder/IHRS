package data.dao.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import data.dao.NormalVipPromotionDao;
import data.dataHelper.DataFactory;
import data.dataHelper.NormalVipPromotionDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.promotionPO.NormalVipPromotionPO;

public class NormalVipPromotionDaoImpl extends UnicastRemoteObject implements NormalVipPromotionDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9114712805502578409L;

	private ArrayList<NormalVipPromotionPO> promotionPOs;
	
	private DataFactory dataFactory;
	
	private NormalVipPromotionDataHelper normalVipPromotionDataHelper;
	
	private static NormalVipPromotionDaoImpl normalVipPromotionDaoImpl;
	
	public static NormalVipPromotionDaoImpl getInstance() throws RemoteException{
		if (normalVipPromotionDaoImpl == null) {
			normalVipPromotionDaoImpl = new NormalVipPromotionDaoImpl();
		}
		return normalVipPromotionDaoImpl;
	}
	
	private NormalVipPromotionDaoImpl() throws RemoteException{
		if (promotionPOs == null) {
			dataFactory = new DataFactoryImpl();
			normalVipPromotionDataHelper = dataFactory.getNormalVipPromotionDataHelper();
			promotionPOs = normalVipPromotionDataHelper.getNormalVipPromotionData();
		}
	}

	public ArrayList<NormalVipPromotionPO> getNormalVipPromotions(int rankValue) throws RemoteException {
		ArrayList<NormalVipPromotionPO> rankedPromotions = new ArrayList<NormalVipPromotionPO>();
		for (NormalVipPromotionPO normalVipPromotionPO : promotionPOs) {
			if (normalVipPromotionPO.getRankValue() == rankValue) {
				rankedPromotions.add(normalVipPromotionPO);
			}
		}
		return rankedPromotions;
	}

	public boolean updateNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException {
		boolean update = false;
		int rank = normalVipPromotionPO.getRankValue();
		String businessDistrict = normalVipPromotionPO.getBusinessDistrict();
		ArrayList<NormalVipPromotionPO> normalVipPromotionPOs=promotionPOs;
		for (NormalVipPromotionPO normalVipPromotionPO1 : promotionPOs) {
			if (normalVipPromotionPO1.getRankValue()==rank && normalVipPromotionPO1.getBusinessDistrict()==businessDistrict) {
				normalVipPromotionPOs.remove(normalVipPromotionPO1);
				normalVipPromotionPOs.add(normalVipPromotionPO);
				normalVipPromotionDataHelper.updateNormalVipPromotionData(normalVipPromotionPOs);
				update = true;
				break;
			}
		}
		return update;
	}

	public boolean addNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException {
		boolean add = true;
		int rank = normalVipPromotionPO.getRankValue();
		String businessDistrict = normalVipPromotionPO.getBusinessDistrict();
		for (NormalVipPromotionPO normalVipPromotionPO2 : promotionPOs) {
			if (normalVipPromotionPO2.getRankValue()==rank && normalVipPromotionPO2.getBusinessDistrict()==businessDistrict) {
				add = false;
				break;
			}
		}
		if (add) {
			promotionPOs.add(normalVipPromotionPO);
			normalVipPromotionDataHelper.updateNormalVipPromotionData(promotionPOs);
		}
		return add;
	}

	public boolean deleteNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException {
		if (promotionPOs.contains(normalVipPromotionPO)) {
			promotionPOs.remove(normalVipPromotionPO);
			normalVipPromotionDataHelper.updateNormalVipPromotionData(promotionPOs);
			return true;
		} else {
			return false;
		}
	}

}
