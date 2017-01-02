package businesslogicservice.userblservice;

import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.HotelManagerVO;
import vo.NormalVipVO;
import vo.WebSaleVO;

public interface FindUserService {
	
		/**
		 * @param customerId  客户编号
		 * @return            根据编号获取客户信息
		 */
		public CustomerVO getCustomer(int customerId);
		
		/**
		 * @param customerName  客户名
		 * @return              根据客户名回去客户信息
		 */
		public CustomerVO getCustomer(String customerName);
		
		/**
		 * @param hotelManagerId  酒店工作人员编号
		 * @return                根据编号获取酒店工作人员信息
		 */
		public HotelManagerVO getHotelManagerByUserId(int hotelManagerId);
		
		/**
		 * @param hotelId  酒店编号
		 * @return         根据编号获取酒店工作人员信息
		 */
		public HotelManagerVO getHotelManagerByHotelId(int hotelId);
		
		/**
		 * @param webSaleId  网站营销人员编号
		 * @return           根据编号获取网站营销人员信息
		 */
		public WebSaleVO getWebSale(int webSaleId);
		
		/**
		 * @param normalVipId  普通会员编号
		 * @return             根据编号获取普通会员信息
		 */
		public NormalVipVO getNormalVip(int normalVipId);
		
		/**
		 * @param enterpriseVipId  企业会员编号
		 * @return                 根据编号获取企业会员信息
		 */
		public EnterpriseVipVO getEnterpriseVipVO(int enterpriseVipId);
		
}
