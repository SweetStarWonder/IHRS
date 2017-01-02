package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.CustomerDataHelper;
import po.CustomerPO;

public class CustomerDataHelper_stub implements CustomerDataHelper{

	@Override
	public HashMap<Integer, CustomerPO> getCustomerDataById() {
		// TODO Auto-generated method stub
		CustomerPO customerPO = new CustomerPO(00001, "customerName", "phone");
		HashMap<Integer, CustomerPO> hashMap = new HashMap<>();
		hashMap.put(00001, customerPO);
		return hashMap;
	}

	@Override
	public HashMap<String, CustomerPO> getCustomerDataByName() {
		// TODO Auto-generated method stub
		CustomerPO customerPO = new CustomerPO(00001, "customerName", "phone");
		HashMap<String, CustomerPO> hashMap = new HashMap<>();
		hashMap.put("customerName", customerPO);
		return hashMap;
	}

	@Override
	public void updateCustomerDataById(HashMap<Integer, CustomerPO> customerMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCustomerDataByName(HashMap<String, CustomerPO> customerMap) {
		// TODO Auto-generated method stub
		
	}

}
