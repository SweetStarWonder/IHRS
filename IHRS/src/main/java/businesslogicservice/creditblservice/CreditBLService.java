package businesslogicservice.creditblservice;

import vo.ListVO;

public interface CreditBlService {
	
	public boolean deductRevokeCredit(ListVO listVO);  //扣除信用值（撤销）
	
	public boolean deductAbnormalCredit(ListVO listVO);  //扣除信用值（异常）
	
	public boolean recoverCredit(ListVO listVO);  //恢复订单时恢复信用值
	
	public boolean rechargeCredit(int rechargeNum);  //用户信用充值
}
