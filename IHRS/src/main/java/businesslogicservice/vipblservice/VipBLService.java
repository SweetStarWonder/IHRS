package businesslogicservice.vipblservice;

import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.NormalVipVO;

public interface VipBlService {
	
	public EnterpriseVipVO registerEnterpriseVip(CustomerVO customerVO,String enterpriseName);  //注册企业会员
	
	public NormalVipVO registerNormalVip(CustomerVO customerVO,String birthday);  //注册普通会员
	
}
