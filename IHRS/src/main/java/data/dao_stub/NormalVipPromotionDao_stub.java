package data.dao_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.NormalVipPromotionDao;
import po.promotionPO.NormalVipPromotionPO;

public class NormalVipPromotionDao_stub implements NormalVipPromotionDao{

	@Override
	public ArrayList<NormalVipPromotionPO> getNormalVipPromotions(int rankValue) throws RemoteException {
		// TODO Auto-generated method stub
		NormalVipPromotionPO normalVipPromotionPO = new NormalVipPromotionPO(0.5, "discountName", rankValue, "businessDistrict");
		ArrayList<NormalVipPromotionPO> arrayList = new ArrayList<>();
		arrayList.add(normalVipPromotionPO);
		return arrayList;
	}

	@Override
	public boolean updateNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteNormalVipPromotion(NormalVipPromotionPO normalVipPromotionPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	

}
