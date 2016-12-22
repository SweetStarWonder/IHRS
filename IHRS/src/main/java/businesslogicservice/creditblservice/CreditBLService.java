package businesslogicservice.creditblservice;

import vo.ListVO;

public interface CreditBlService {
	
	/**
	 * @param listVO  订单信息
	 * @return        信用值是否扣除成功（撤销订单）
	 */
	public boolean deductRevokeCredit(ListVO listVO);
	
	/**
	 * @param listVO  订单信息
	 * @return        信用值是否扣除成功（异常订单）
	 */
	public boolean deductAbnormalCredit(ListVO listVO);
	
	/**
	 * @param listVO  订单信息
	 * @return        信用值是否恢复成功（恢复订单）
	 */
	public boolean recoverCredit(ListVO listVO);
	
	/**
	 * @param rechargeNum  充值额度
	 * @return             是否充值成功
	 */
	public boolean rechargeCredit(int rechargeNum);
	
}
