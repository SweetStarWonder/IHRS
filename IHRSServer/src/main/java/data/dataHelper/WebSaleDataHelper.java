package data.dataHelper;

import java.util.HashMap;

import po.WebSalePO;

public interface WebSaleDataHelper {
	public HashMap<Integer, WebSalePO> getWebSaleDataById();
	
	public HashMap<String, WebSalePO> getWebSaleDataByName();
	
	public void updateWebSaleDataById(HashMap<Integer, WebSalePO> webSaleDataMap);
	
	public void updateWebSaleDataByName(HashMap<Integer, WebSalePO> webSaleDataMap);
}
