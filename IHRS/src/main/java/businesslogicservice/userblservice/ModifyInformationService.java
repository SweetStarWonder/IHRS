package businesslogicservice.userblservice;

import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public interface ModifyInformationService {
	
	/**
	 * @param customerVO  客户信息
	 * @return            客户维护自己的信息
	 */
	public boolean modifyInformation(CustomerVO customerVO);
	
	/**
	 * @param hotelManagerVO  酒店工作人员信息
	 * @return                酒店工作人员维护自己的信息
	 */
	public boolean modifyInformation(HotelManagerVO hotelManagerVO);
	
	/**
	 * @param webManagerVO  网站管理人员
	 * @return              网站管理人员维护自己的信息
	 */
	public boolean modifyInformation(WebManagerVO webManagerVO);
	
	/**
	 * @param webSaleVO  网站营销人员
	 * @return           网站营销人员维护自己的信息
	 */
	public boolean modifyInformation(WebSaleVO webSaleVO);
	
}
