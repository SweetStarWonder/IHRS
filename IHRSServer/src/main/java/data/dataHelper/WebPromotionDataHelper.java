package data.dataHelper;

import java.util.ArrayList;

import po.promotionPO.WebPromotionPO;

public interface WebPromotionDataHelper {
	
	public ArrayList<WebPromotionPO> getWebPromotionData();
	
	public void updateWebPromotionData(ArrayList<WebPromotionPO> webPromotionPOs);
}
