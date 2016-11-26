package data.dao;

import po.WebSalePO;

public interface WebSaleDao {
	public WebSalePO getWebSale(int userId);
	
	public WebSalePO getWebSale(String userName);
	
	public boolean addWebSale(WebSalePO webSalePO);
	
	public boolean updateWebSale(WebSalePO webSalePO);
}
