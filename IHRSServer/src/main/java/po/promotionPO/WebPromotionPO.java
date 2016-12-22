package po.promotionPO;

/**
 * discount      网站促销折扣
 * discountName  折扣名
 * startTime     开始时间（yyyy/MM/dd HH:mm:ss）
 * endTime       结束时间
 */
public class WebPromotionPO extends PromotionPO{

	private static final long serialVersionUID = 1513025785369912803L;

	
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

	@Override
	public boolean equals(Object o) {
		WebPromotionPO webPromotionPO = (WebPromotionPO) o;
        return (webPromotionPO.getStartTime().equals(startTime) && webPromotionPO.getEndTime().equals(endTime));
    }
}
