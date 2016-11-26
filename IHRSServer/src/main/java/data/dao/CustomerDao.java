package data.dao;

import po.CustomerPO;

public interface CustomerDao {
	
	public CustomerPO getCustomer(int userId);
	
	public CustomerPO getCustomer(String userName);
	
	public boolean updateCustomer(CustomerPO customerPO);
	
	public boolean addCustomer(CustomerPO customerPO);
}
