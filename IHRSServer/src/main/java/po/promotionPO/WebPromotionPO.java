package po.promotionPO;

public class WebPromotionPO extends PromotionPO {
	
	private String startTime;
	
	private String endTime;
	
	public WebPromotionPO(double discount,String discountName,String startTime,String endTime){
		super(discount,discountName);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
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
