package vo.promotionVO;

import po.promotionPO.HotelPromotionPO;
import po.promotionPO.HotelPromotionType;
import po.promotionPO.PromotionPO;

/**
 * discount            酒店促销折扣
 * discountName        折扣名
 * hotelId             酒店编号
 * hotelPromotionType  促销类型
 * startTime           促销开始时间（yyyy/MM/dd HH:mm:ss）
 * endTime             促销结束时间
 */
public class HotelPromotionVO extends PromotionVO{
	
	private int hotelId;
	
	private HotelPromotionType hotelPromotionType;
	
	private String startTime;
	
	private String endTime;
	
	public HotelPromotionVO(HotelPromotionPO hotelPromotionPO){
		super(new PromotionPO(hotelPromotionPO.getDiscount(), hotelPromotionPO.getDiscountName()));
		this.hotelId=hotelPromotionPO.getHotelId();
		this.hotelPromotionType=hotelPromotionPO.getHotelPromotionType();
		this.startTime=hotelPromotionPO.getStartTime();
		this.endTime=hotelPromotionPO.getEndTime();
	}

	public HotelPromotionVO(double discount, String discountName,int hotelId,HotelPromotionType hotelPromotionType,
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

	
}
