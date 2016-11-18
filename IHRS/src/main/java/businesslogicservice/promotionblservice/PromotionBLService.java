package businesslogicservice.promotionblservice;

import po.PromotionPO;
import vo.HotelVO;
import vo.PromotionVO;

public interface PromotionBLService {
	public PromotionVO getPromotion(HotelVO hotel);
	public boolean create(PromotionPO promotion);
	public boolean modify(PromotionPO promotion);
}
