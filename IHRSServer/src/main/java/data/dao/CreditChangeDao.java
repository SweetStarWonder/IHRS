package data.dao;

import po.CreditChangePO;

public interface CreditChangeDao {
	
	public CreditChangePO getCreditChange(int userId);
	
	public boolean addCreditChange(CreditChangePO creditChangePO);
}
