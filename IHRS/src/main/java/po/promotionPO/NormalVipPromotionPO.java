package po.promotionPO;

public class NormalVipPromotionPO extends PromotionPO{
	
	private int rankValue;  //等级（信用值计算）
	
	private String businessDistrict;
	
	public NormalVipPromotionPO(double discount,String discountName,int rankValue,String businessDistrict) {
		super(discount, discountName);
		this.rankValue=rankValue;
		this.businessDistrict=businessDistrict;
	}

	public int getRankValue() {
		return rankValue;
	}

	public void setRankValue(int rankValue) {
		this.rankValue = rankValue;
	}

	public String getBusinessDistrict() {
		return businessDistrict;
	}

	public void setBusinessDistrict(String businessDistrict) {
		this.businessDistrict = businessDistrict;
	}

}
