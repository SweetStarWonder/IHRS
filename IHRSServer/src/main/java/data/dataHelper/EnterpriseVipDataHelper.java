package data.dataHelper;

import java.util.HashMap;

import po.EnterpriseVipPO;

public interface EnterpriseVipDataHelper {
	
	public HashMap<Integer, EnterpriseVipPO> getEnterpriseVipData();
	
	public void updateEnterpriseVipData(HashMap<Integer, EnterpriseVipPO> enterpriseVipMap);
	
}
