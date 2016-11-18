package dataservice.creditdataservice;

import po.CreditPO;
import dataservice.datafactoryservice.DatabaseService;

public interface CreditDataService extends DatabaseService {
	public CreditPO find(String userid);
	public void insert(CreditPO po);
	public void update(CreditPO po);
	public void init();
	public void finish();
}
