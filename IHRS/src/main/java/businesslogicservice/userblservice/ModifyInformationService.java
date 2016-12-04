package businesslogicservice.userblservice;

import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public interface ModifyInformationService {
	
	//每个角色修改各自的信息
	public boolean modifyInformation(CustomerVO customerVO);
	
	public boolean modifyInformation(HotelManagerVO hotelManagerVO);
	
	public boolean modifyInformation(WebManagerVO webManagerVO);
	
	public boolean modifyInformation(WebSaleVO webSaleVO);
	
}
