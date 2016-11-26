package data.dataHelper;

import java.util.HashMap;

import po.WebManagerPO;

public interface WebManagerDataHelper {
	
	public HashMap<Integer, WebManagerPO> getWebManagerData();
	
	public void updateWebManagerData(HashMap<Integer, WebManagerPO> webManagerDataMap);
}
