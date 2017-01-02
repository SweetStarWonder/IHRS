package businesslogic_stub.promotionbl_stub;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.HotelPromotionBlService;
import po.promotionPO.HotelPromotionType;
import vo.promotionVO.HotelPromotionVO;

public class HotelPromotionBlService_stub implements HotelPromotionBlService{

	@Override
	public ArrayList<HotelPromotionVO> getHotelPromotions(int hotelId) {
		// TODO Auto-generated method stub
		ArrayList<HotelPromotionVO> hotelPromotionVOs = new ArrayList<>();
		HotelPromotionVO hotelPromotionVO = new HotelPromotionVO(0.5, "discoutName", 2222, HotelPromotionType.BIRTHDAY, "2016/10/01 00:00:00", "2016/10/01 23:59:59");
		hotelPromotionVOs.add(hotelPromotionVO);
		return hotelPromotionVOs;
	}

	@Override
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteHotelPromotion(HotelPromotionVO hotelPromotionVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public double getMinDiscountForCustomer(int hotelId, String timeNow, boolean isThreeMore) {
		// TODO Auto-generated method stub
		return 0.5;
	}

	@Override
	public double getMinDiscountForEnterPriseVip(int hotelId, String timeNow, boolean isThreeMore) {
		// TODO Auto-generated method stub
		return 0.5;
	}

	@Override
	public double getMinDiscountForNormalVip(int hotelId, String timeNow, boolean isThreeMore, boolean isBirthday) {
		// TODO Auto-generated method stub
		return 0.5;
	}

}
