package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.promotionVO.HotelPromotionVO;

public interface HotelPromotionBlService {
	
	/**
	 * @param hotelId  酒店编号
	 * @return         获取对应酒店的所有促销策略
	 */
	public ArrayList<HotelPromotionVO> getHotelPromotions(int hotelId);
	
	/**
	 * @param hotelPromotionVO  酒店促销策略信息
	 * @return                  添加酒店促销策略是否成功
	 */
	public boolean addHotelPromotion(HotelPromotionVO hotelPromotionVO);
	
	/**
	 * @param hotelPromotionVO  酒店促销策略信息
	 * @return                  删除酒店促销策略是否成功
	 */
	public boolean deleteHotelPromotion(HotelPromotionVO hotelPromotionVO);
	
	/**
	 * @param hotelId      酒店编号
	 * @param timeNow      系统当前时间
	 * @param isThreeMore  是否预定三间或以上
	 * @return             获取客户促销策略最小折扣
	 */
	public double getMinDiscountForCustomer(int hotelId,String timeNow,boolean isThreeMore);
	
	/**
	 * @param hotelId      酒店编号
	 * @param timeNow      系统当前时间
	 * @param isThreeMore  是否预定三间或以上
	 * @return             获取企业会员促销策略最小折扣
	 */
	public double getMinDiscountForEnterPriseVip(int hotelId,String timeNow,boolean isThreeMore);
	
	/**
	 * @param hotelId      酒店编号
	 * @param timeNow      系统当前时间
	 * @param isThreeMore  是否预定三间或以上
	 * @param isBirthday   是否是普通会员生日
	 * @return             获取普通会员促销策略最小折扣
	 */
	public double getMinDiscountForNormalVip(int hotelId,String timeNow,boolean isThreeMore,boolean isBirthday);
	
}
