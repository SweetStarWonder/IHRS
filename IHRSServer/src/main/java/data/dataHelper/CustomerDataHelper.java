package data.dataHelper;

import java.util.HashMap;

import po.CustomerPO;

public interface CustomerDataHelper {
	
	/**
	 * @return  客户信息（左客户编号）
	 */
	public HashMap<Integer, CustomerPO> getCustomerDataById();
	
	/**
	 * @return  客户信息（左客户名）
	 */
	public HashMap<String, CustomerPO> getCustomerDataByName();
	
	/**
	 * @param customerMap  客户信息（左客户编号）
	 */
	public void updateCustomerDataById(HashMap<Integer, CustomerPO> customerMap);
	
	/**
	 * @param customerMap  客户信息（左客户名）
	 */
	public void updateCustomerDataByName(HashMap<String, CustomerPO> customerMap);
	
}
