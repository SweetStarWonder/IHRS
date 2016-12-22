package data.dataHelper;

import java.util.HashMap;

import po.WebSalePO;

public interface WebSaleDataHelper {
	
	/**
	 * @return  网站营销人员信息（左网站营销人员编号）
	 */
	public HashMap<Integer, WebSalePO> getWebSaleDataById();
	
	/**
	 * @return  网站营销人员信息（左网站营销人员名）
	 */
	public HashMap<String, WebSalePO> getWebSaleDataByName();
	
	/**
	 * @param webSaleDataMap  网站营销人员信息（左网站营销人员编号）
	 */
	public void updateWebSaleDataById(HashMap<Integer, WebSalePO> webSaleDataMap);
	
	/**
	 * @param webSaleDataMap  网站营销人员信息（左网站营销人员名）
	 */
	public void updateWebSaleDataByName(HashMap<String, WebSalePO> webSaleDataMap);
	
}
