package data.dataHelper;

import java.util.HashMap;

import po.EnterpriseVipPO;

public interface EnterpriseVipDataHelper {
	
	/**
	 * @return  企业会员信息（左企业会员编号）
	 */
	public HashMap<Integer, EnterpriseVipPO> getEnterpriseVipData();
	
	/**
	 * @param enterpriseVipMap  企业会员信息（左企业会员编号）
	 */
	public void updateEnterpriseVipData(HashMap<Integer, EnterpriseVipPO> enterpriseVipMap);
	
}
