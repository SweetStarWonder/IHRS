package data.dataHelper;

import java.util.HashMap;

import po.WebManagerPO;

public interface WebManagerDataHelper {
	
	/**
	 * @return  网站管理人员信息（左网站管理人员编号）
	 */
	public HashMap<Integer, WebManagerPO> getWebManagerData();
	
	/**
	 * @param webManagerDataMap  网站管理人员信息（左网站管理人员编号）
	 */
	public void updateWebManagerData(HashMap<Integer, WebManagerPO> webManagerDataMap);
	
}
