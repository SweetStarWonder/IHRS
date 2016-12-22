package vo.promotionVO;

import po.promotionPO.PromotionPO;

/**
 * discount      //折扣
 * discountName  //折扣名
 */
public class PromotionVO {
	
	private double discount;
	
	private String discountName;
	
	public PromotionVO(PromotionPO promotionPO){
		this.discount=promotionPO.getDiscount();
		this.discountName=promotionPO.getDiscountName();
	}
	
	public PromotionVO(double discount,String discountName) {
		this.setDiscount(discount);
		this.setDiscountName(discountName);
	}
	
	public double getDiscount() {
		return discount;
	}
	
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public String getDiscountName() {
		return discountName;
	}
	
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	
	
}
