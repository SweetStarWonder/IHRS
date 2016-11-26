package data.dataHelper;

import java.util.HashMap;

import po.NormalVipPO;

public interface NormalVipDataHelper {

	public HashMap<Integer, NormalVipPO> getNormalVipData();	//左边是userId
		
	public void updateNormalVipData(HashMap<Integer, NormalVipPO> normalVipDataMap);
		
}
