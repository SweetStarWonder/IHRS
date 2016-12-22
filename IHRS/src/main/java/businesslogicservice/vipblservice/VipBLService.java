package businesslogicservice.vipblservice;

import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.NormalVipVO;

public interface VipBlService {
	
	/**
	 * @param customerVO      客户信息
	 * @param enterpriseName  企业名
	 * @return                客户注册企业会员
	 */
	public EnterpriseVipVO registerEnterpriseVip(CustomerVO customerVO,String enterpriseName);  //注册企业会员
	
	/**
	 * @param customerVO  客户信息
	 * @param birthday    生日（YYYY-MM-DD）
	 * @return            客户注册普通会员
	 */
	public NormalVipVO registerNormalVip(CustomerVO customerVO,String birthday);  //注册普通会员
	
}
