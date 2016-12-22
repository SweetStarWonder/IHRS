package po.promotionPO;

/**
 * discount            酒店促销折扣
 * discountName        折扣名
 * hotelId             酒店编号
 * hotelPromotionType  促销类型
 * startTime           促销开始时间（yyyy/MM/dd HH:mm:ss）
 * endTime             促销结束时间
 */
public class HotelPromotionPO extends PromotionPO {

	private static final long serialVersionUID = 7670571459179896221L;

	
	private int hotelId;

	private HotelPromotionType hotelPromotionType;
	
	private String startTime;
	
	private String endTime;

	public HotelPromotionPO(double discount, String discountName, int hotelId, HotelPromotionType hotelPromotionType,
			String startTime,String endTime) {
		super(discount, discountName);
		this.setHotelId(hotelId);
		this.setHotelPromotionType(hotelPromotionType);
		this.setStartTime(startTime);
		this.setEndTime(endTime);
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
		HotelPromotionPO hotelPromotionPO = (HotelPromotionPO) o;
		return (hotelPromotionPO.getHotelId()==hotelId && hotelPromotionPO.getHotelPromotionType().equals(hotelPromotionType)
				&& hotelPromotionPO.getStartTime().equals(startTime) && hotelPromotionPO.getEndTime().equals(endTime));
	}
	
}
