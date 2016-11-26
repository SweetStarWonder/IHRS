package data.dataHelper;

import java.util.HashMap;

import po.CustomerPO;

public interface CustomerDataHelper {
	
	public HashMap<Integer, CustomerPO> getCustomerDataById();
	
	public HashMap<String, CustomerPO> getCustomerDataByName();
	
	public void updateCustomerDataById(HashMap<Integer, CustomerPO> customerMap);
	
	public void updateCustomerDataByName(HashMap<Integer, CustomerPO> customerMap);
	

}
