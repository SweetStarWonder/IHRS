package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.WebManagerDataHelper;
import po.WebManagerPO;

public class WebManagerDataHelper_stub implements WebManagerDataHelper{

	@Override
	public HashMap<Integer, WebManagerPO> getWebManagerData() {
		// TODO Auto-generated method stub
		HashMap<Integer, WebManagerPO> hashMap = new HashMap<>();
		WebManagerPO webManagerPO = new WebManagerPO(00004, "webManagerName", "phone");
		hashMap.put(00004, webManagerPO);
		return hashMap;
	}

	@Override
	public void updateWebManagerData(HashMap<Integer, WebManagerPO> webManagerDataMap) {
		// TODO Auto-generated method stub
		
	}

}
