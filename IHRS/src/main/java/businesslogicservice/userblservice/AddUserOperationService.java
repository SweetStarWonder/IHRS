package businesslogicservice.userblservice;

import vo.HotelManagerVO;
import vo.WebSaleVO;

public interface AddUserOperationService {
	
		//添加酒店；添加酒店工作人员（需先添加酒店）
		public boolean addWebSale(WebSaleVO webSaleVO);
		
		public boolean addHotelManager(HotelManagerVO hotelManagerVO);
}
