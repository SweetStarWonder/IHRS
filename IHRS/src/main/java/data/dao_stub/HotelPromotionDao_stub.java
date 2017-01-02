package data.dao_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.HotelPromotionDao;
import po.promotionPO.HotelPromotionPO;
import po.promotionPO.HotelPromotionType;

public class HotelPromotionDao_stub implements HotelPromotionDao{

	@Override
	public ArrayList<HotelPromotionPO> getHotelPromotions(int hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		HotelPromotionPO hotelPromotionPO = new HotelPromotionPO(0.5, "discountName", hotelId, HotelPromotionType.BIRTHDAY, "2016/10/01 00:00:00", "2016/10/01 23:59:59");
		ArrayList<HotelPromotionPO> arrayList = new ArrayList<>();
		arrayList.add(hotelPromotionPO);
		return arrayList;
	}

	@Override
	public boolean addHotelPromotion(HotelPromotionPO hotelPromotionPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteHotelPromotion(HotelPromotionPO hotelPromotionPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
