package dataservice.vipdataservice;

import dataservice.datafactoryservice.DatabaseService;
import po.VipPO;

public interface VipDataService extends DatabaseService {
	public VipPO find(String userid);
	public void insert(VipPO po);
	public void update(VipPO po);
	public void init();
	public void finish();
}
