package businesslogicservice.promotionblservice;

import java.util.ArrayList;

import vo.promotionVO.NormalVipPromotionVO;

public interface NormalVipPromotionBlService {
	
	/**
	 * @param rankValue  普通会员等级制度
	 * @return           根据等级制度获取所有普通会员促销策略
	 */
	public ArrayList<NormalVipPromotionVO> getNormalVipPromotions(int rankValue);
	
	/**
	 * @param normalVipPromotionVO  普通会员促销策略信息
	 * @return                      修改普通会员促销策略是否成功
	 */
	public boolean updateNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO);
	
	/**
	 * @param normalVipPromotionVO  普通会员促销策略信息
	 * @return                      添加普通会员促销策略是否成功
	 */
	public boolean addNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO);

	/**
	 * @param normalVipPromotionVO  普通会员促销策略信息
	 * @return                      删除普通促销策略是否成功
	 */
	public boolean deleteNormalVipPromotion(NormalVipPromotionVO normalVipPromotionVO);
	
	/**
	 * @param hotelId    酒店编号
	 * @param rankValue  等级
	 * @return           获取普通会员促销策略最小折扣
	 */
	public double getMinDiscountForNormalVip(int hotelId,int rankValue);
	
}
