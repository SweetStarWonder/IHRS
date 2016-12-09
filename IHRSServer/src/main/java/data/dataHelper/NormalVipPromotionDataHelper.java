package data.dataHelper;

import java.util.ArrayList;

import po.promotionPO.NormalVipPromotionPO;

public interface NormalVipPromotionDataHelper {
	
	public ArrayList<NormalVipPromotionPO> getNormalVipPromotionData();
	
	public void updateNormalVipPromotionData(ArrayList<NormalVipPromotionPO> normalVipPOs);
}
