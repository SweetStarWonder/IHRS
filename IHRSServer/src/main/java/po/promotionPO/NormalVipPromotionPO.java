package po.promotionPO;

/**
 * discount          普通会员促销折扣
 * discountName      折扣名
 * rankValue         等级（信用值计算）
 * businessDistrict  商圈
 */
public class NormalVipPromotionPO extends PromotionPO{

	private static final long serialVersionUID = 7216193191162797613L;

	
	private int rankValue;
	
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

	@Override
	public boolean equals(Object o) {
        NormalVipPromotionPO normalVipPromotionPO = (NormalVipPromotionPO) o;
		
		return (normalVipPromotionPO.getBusinessDistrict().equals(businessDistrict) && normalVipPromotionPO.getRankValue() == rankValue);
    }
	
}
