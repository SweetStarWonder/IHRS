package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.WebSaleDataHelper;
import po.WebSalePO;

public class WebSaleDataHelper_stub implements WebSaleDataHelper{

	@Override
	public HashMap<Integer, WebSalePO> getWebSaleDataById() {
		// TODO Auto-generated method stub
		HashMap<Integer, WebSalePO> hashMap = new HashMap<>();
		WebSalePO webSalePO = new WebSalePO(00004, "webSaleName", "phone");
		hashMap.put(00004, webSalePO);
		return hashMap;
	}

	@Override
	public HashMap<String, WebSalePO> getWebSaleDataByName() {
		// TODO Auto-generated method stub
		HashMap<String, WebSalePO> hashMap = new HashMap<>();
		WebSalePO webSalePO = new WebSalePO(00004, "webSaleName", "phone");
		hashMap.put("webSaleName", webSalePO);
		return hashMap;
	}

	@Override
	public void updateWebSaleDataById(HashMap<Integer, WebSalePO> webSaleDataMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateWebSaleDataByName(HashMap<String, WebSalePO> webSaleDataMap) {
		// TODO Auto-generated method stub
		
	}

}
