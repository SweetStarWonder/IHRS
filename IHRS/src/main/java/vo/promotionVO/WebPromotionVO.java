package vo.promotionVO;

import po.promotionPO.PromotionPO;
import po.promotionPO.WebPromotionPO;

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
