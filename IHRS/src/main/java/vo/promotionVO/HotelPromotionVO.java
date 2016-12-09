package vo.promotionVO;

import po.promotionPO.HotelPromotionPO;
import po.promotionPO.HotelPromotionType;
import po.promotionPO.PromotionPO;

public class HotelPromotionVO extends PromotionVO{
	
	private int hotelId;
	
	private HotelPromotionType hotelPromotionType;
	
	public HotelPromotionVO(HotelPromotionPO hotelPromotionPO){
		super(new PromotionPO(hotelPromotionPO.getDiscount(), hotelPromotionPO.getDiscountName()));
		this.hotelId=hotelPromotionPO.getHotelId();
		this.hotelPromotionType=hotelPromotionPO.getHotelPromotionType();
	}

	public HotelPromotionVO(double discount, String discountName,int hotelId,HotelPromotionType hotelPromotionType) {
		super(discount, discountName);
		this.setHotelId(hotelId);
		this.setHotelPromotionType(hotelPromotionType);
	}
	
	public HotelPromotionType getHotelPromotionType() {
		return hotelPromotionType;
	}

	public void setHotelPromotionType(HotelPromotionType hotelPromotionType) {
		this.hotelPromotionType = hotelPromotionType;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

}
