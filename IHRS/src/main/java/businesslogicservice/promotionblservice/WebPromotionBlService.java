package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.promotionVO.WebPromotionVO;

public interface WebPromotionBlService {
	
	/**
	 * @return  获取网站所有促销策略
	 */
	public ArrayList<WebPromotionVO> getWebPromotions();
	
	/**
	 * @param webPromotionVO  网站促销策略信息
	 * @return                添加网站促销策略是否成功
	 */
	public boolean addWebPromotion(WebPromotionVO webPromotionVO);
	
	/**
	 * @param webPromotionVO  网站促销策略信息
	 * @return                删除网站促销策略是否成功
	 */
	public boolean deleteWebPromotion(WebPromotionVO webPromotionVO);
	
	/**
	 * @param timeNow  系统当前时间
	 * @return         获取网站促销策略最小折扣
	 */
	public double getMinDiscountInWeb(String timeNow);
	
}
