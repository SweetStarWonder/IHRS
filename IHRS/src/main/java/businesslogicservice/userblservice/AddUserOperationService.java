package businesslogicservice.userblservice;

import vo.HotelManagerVO;
import vo.WebSaleVO;

public interface AddUserOperationService {
	
		/**
		 * @param webSaleVO  网站营销人员信息
		 * @return           添加网站营销人员是否成功
		 */
		public boolean addWebSale(WebSaleVO webSaleVO);
		
		/**
		 * @param hotelManagerVO  酒店管理人员信息
		 * @return                添加酒店工作人员是否成功    
		 */
		public boolean addHotelManager(HotelManagerVO hotelManagerVO);
		
}
