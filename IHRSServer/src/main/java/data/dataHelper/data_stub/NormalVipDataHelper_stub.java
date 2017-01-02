package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.NormalVipDataHelper;
import po.NormalVipPO;

public class NormalVipDataHelper_stub implements NormalVipDataHelper{

	@Override
	public HashMap<Integer, NormalVipPO> getNormalVipData() {
		// TODO Auto-generated method stub
		HashMap<Integer, NormalVipPO> hashMap = new HashMap<>();
		NormalVipPO normalVipPO = new NormalVipPO(00003, "customerName", "phone", 0, "birthday");
		hashMap.put(00003, normalVipPO);
		return hashMap;
	}

	@Override
	public void updateNormalVipData(HashMap<Integer, NormalVipPO> normalVipDataMap) {
		// TODO Auto-generated method stub
		
	}

}
