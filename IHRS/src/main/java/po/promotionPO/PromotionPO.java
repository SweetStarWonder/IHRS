package po.promotionPO;

public class PromotionPO {
	
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
