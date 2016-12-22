package vo.promotionVO;

import po.promotionPO.PromotionPO;
import po.promotionPO.WebPromotionPO;


/**
 * discount      网站促销折扣
 * discountName  折扣名
 * startTime     开始时间（yyyy/MM/dd HH:mm:ss）
 * endTime       结束时间
 */
public class WebPromotionVO extends PromotionVO {
	
	private String startTime;
	
	private String endTime;
	
	public WebPromotionVO(double discount,String discountName,String startTime,String endTime){
		super(discount,discountName);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
	}
	
	public WebPromotionVO(WebPromotionPO webPromotionPO){
		super(new PromotionPO(webPromotionPO.getDiscount(),webPromotionPO.getDiscountName()));
		this.startTime=webPromotionPO.getStartTime();
		this.endTime=webPromotionPO.getEndTime();
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	
}
