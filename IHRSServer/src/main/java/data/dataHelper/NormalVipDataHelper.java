package data.dataHelper;

import java.util.HashMap;

import po.NormalVipPO;

public interface NormalVipDataHelper {

	/**
	 * @return  普通会员信息（左普通会员编号）
	 */
	public HashMap<Integer, NormalVipPO> getNormalVipData();	//左边是userId
		
	/**
	 * @param normalVipDataMap  普通会员信息（左普通会员编号）
	 */
	public void updateNormalVipData(HashMap<Integer, NormalVipPO> normalVipDataMap);
		
}
