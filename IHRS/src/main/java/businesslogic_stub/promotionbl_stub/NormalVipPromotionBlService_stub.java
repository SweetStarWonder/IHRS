package businesslogic_stub.promotionbl_stub;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.NormalVipPromotionBlService;
import vo.promotionVO.NormalVipPromotionVO;

public class NormalVipPromotionBlService_stub implements NormalVipPromotionBlService{

	@Override
	public ArrayList<NormalVipPromotionVO> getNormalVipPromotions(int rankValue) {
		// TODO Auto-generated method stub
		ArrayList<NormalVipPromotionVO> normalVipPromotionVOs = new ArrayList<>();
		NormalVipPromotionVO normalVipPromotionVO = new NormalVipPromotionVO(0.5, "discountName", 5, "businessDstrict");
		normalVipPromotionVOs.add(normalVipPromotionVO);
		return normalVipPromotionVOs;
	}

	@Override
	public boolean updateNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public double getMinDiscountForNormalVip(int hotelId, int rankValue) {
		// TODO Auto-generated method stub
		return 0.5;
	}

}
