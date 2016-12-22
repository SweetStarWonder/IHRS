package data.dataHelper;

import java.util.ArrayList;

import po.promotionPO.NormalVipPromotionPO;

public interface NormalVipPromotionDataHelper {
	
	/**
	 * @return  普通会员所有促销策略
	 */
	public ArrayList<NormalVipPromotionPO> getNormalVipPromotionData();
	
	/**
	 * @param normalVipPOs  普通会员所有促销策略
	 */
	public void updateNormalVipPromotionData(ArrayList<NormalVipPromotionPO> normalVipPOs);
	
}
