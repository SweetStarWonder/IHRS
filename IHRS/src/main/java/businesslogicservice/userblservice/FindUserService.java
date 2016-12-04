package businesslogicservice.userblservice;

import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.WebSaleVO;

public interface FindUserService {
	
		//查询用户
		public CustomerVO getCustomer(int customerId);
		
		public CustomerVO getCustomer(String customerName);
		
		//查询酒店工作人员
		public HotelManagerVO getHotelManagerByUserId(int hotelManagerId);
		
		public HotelManagerVO getHotelManagerByHotelId(int hotelId);
		
		//查询网站营销人员
		public WebSaleVO getWebSale(int webSaleId);
}
