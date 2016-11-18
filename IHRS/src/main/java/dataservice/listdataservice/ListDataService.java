package dataservice.listdataservice;

import dataservice.datafactoryservice.DatabaseService;
import po.ListPO;

public interface ListDataService extends DatabaseService{
	public ListPO find(String userid);
	public void insert(ListPO po);
	public void update(ListPO po);
	public void init();
	public void finish();
}
