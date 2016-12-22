package businesslogicservice.listblservice;

import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.ListVO;
import vo.NormalVipVO;

public interface GenerateListService {
	
	/**
	 * @param listVO      订单
	 * @param customerVO  客户
	 * @param timeNow     当前系统时间
	 * @return            是否下单成功
	 */
	public boolean generateList(ListVO listVO ,CustomerVO customerVO,String timeNow);
	
	/**
	 * @param listVO       订单
	 * @param normalVipVO  普通会员
	 * @param timeNow      当前系统时间
	 * @return             是否下单成功
	 */
	public boolean generateList(ListVO listVO,NormalVipVO normalVipVO,String timeNow);
	
	/**
	 * @param listVO           订单
	 * @param enterpriseVipVO  企业会员
	 * @param timeNow          当前系统时间
	 * @return                 是否下单成功
	 */
	public boolean generateList(ListVO listVO,EnterpriseVipVO enterpriseVipVO,String timeNow);
	
}
