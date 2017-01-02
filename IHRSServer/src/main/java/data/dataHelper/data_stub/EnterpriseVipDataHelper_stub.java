package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.EnterpriseVipDataHelper;
import po.EnterpriseVipPO;

public class EnterpriseVipDataHelper_stub implements EnterpriseVipDataHelper{

	@Override
	public HashMap<Integer, EnterpriseVipPO> getEnterpriseVipData() {
		// TODO Auto-generated method stub
		EnterpriseVipPO enterpriseVipPO = new EnterpriseVipPO(00004, "customerName", "phone", "enterpriseName", 0);
		HashMap<Integer, EnterpriseVipPO> hashMap = new HashMap<>();
		hashMap.put(00004, enterpriseVipPO);
		return hashMap;
	}

	@Override
	public void updateEnterpriseVipData(HashMap<Integer, EnterpriseVipPO> enterpriseVipMap) {
		// TODO Auto-generated method stub
		
	}

}
