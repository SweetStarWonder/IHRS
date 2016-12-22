package po.promotionPO;

import java.io.Serializable;

/**
 * discount      //折扣
 * discountName  //折扣名
 */
public class PromotionPO implements Serializable {

	private static final long serialVersionUID = 1400133179511364108L;

	
	private double discount;
	
	private String discountName;
	
	public PromotionPO(double discount,String discountName) {
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
