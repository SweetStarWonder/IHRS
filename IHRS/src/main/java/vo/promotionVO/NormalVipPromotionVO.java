package vo.promotionVO;

import po.promotionPO.NormalVipPromotionPO;
import po.promotionPO.PromotionPO;

public class NormalVipPromotionVO extends PromotionVO{
	
	private int rankValue;  //等级（信用值计算）
	
	private String businessDistrict;
	
	public NormalVipPromotionVO(double discount,String discountName,int rankValue,String businessDstrict){
		super(discount, discountName);
		this.setRankValue(rankValue);
		this.setBusinessDistrict(businessDstrict);
	}
	
	public NormalVipPromotionVO(NormalVipPromotionPO normalVipPromotionPO){
		super(new PromotionPO(normalVipPromotionPO.getDiscount(), normalVipPromotionPO.getDiscountName()));
		this.rankValue=normalVipPromotionPO.getRankValue();
		this.setBusinessDistrict(normalVipPromotionPO.getBusinessDistrict());
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
