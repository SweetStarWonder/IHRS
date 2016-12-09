package po.promotionPO;

public class HotelPromotionPO extends PromotionPO{
	
	private int hotelId;

	private HotelPromotionType hotelPromotionType;

	public HotelPromotionPO(double discount, String discountName, int hotelId, HotelPromotionType hotelPromotionType) {
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
