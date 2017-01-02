package businesslogic_stub.promotionbl_stub;

import java.util.ArrayList;

import businesslogicservice.promotionblservice.WebPromotionBlService;
import vo.promotionVO.WebPromotionVO;

public class WebPromotionBlService_stub implements WebPromotionBlService{

	@Override
	public ArrayList<WebPromotionVO> getWebPromotions() {
		// TODO Auto-generated method stub
		ArrayList<WebPromotionVO> webPromotionVOs = new ArrayList<>();
		WebPromotionVO webPromotionVO = new WebPromotionVO(0.5, "discountName", "2016/10/01 00:00:00", "2016/10/01 23:59:59");
		webPromotionVOs.add(webPromotionVO);
		return webPromotionVOs;
	}

	@Override
	public boolean addWebPromotion(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public double getMinDiscountInWeb(String timeNow) {
		// TODO Auto-generated method stub
		return 0.5;
	}

}
