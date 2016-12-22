package data.dataHelper;

import java.util.ArrayList;

import po.promotionPO.WebPromotionPO;

public interface WebPromotionDataHelper {
	
	/**
	 * @return  网站所有促销策略
	 */
	public ArrayList<WebPromotionPO> getWebPromotionData();
	
	/**
	 * @param webPromotionPOs  网站所有促销策略
	 */
	public void updateWebPromotionData(ArrayList<WebPromotionPO> webPromotionPOs);
	
}
