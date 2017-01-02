package data.dao_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.WebPromotionDao;
import po.promotionPO.WebPromotionPO;

public class WebPromotionDao_stub implements WebPromotionDao{

	@Override
	public ArrayList<WebPromotionPO> getWebPromotions() throws RemoteException {
		// TODO Auto-generated method stub
		WebPromotionPO webPromotionPO = new WebPromotionPO(0.5, "discountName", "2016/10/01 00:00:00", "2016/10/01 23:59:59");
		ArrayList<WebPromotionPO> arrayList = new ArrayList<>();
		arrayList.add(webPromotionPO);
		return arrayList;
	}

	@Override
	public boolean addWebPromotion(WebPromotionPO webPromotionPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteWebPromotion(WebPromotionPO webPromotionPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
