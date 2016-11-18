package dataservice.userdataservice;

import dataservice.datafactoryservice.DatabaseService;
import po.UserPO;

public interface UserDataService extends DatabaseService {
	public UserPO find(String userid);
	public void insert(UserPO po);
	public void update(UserPO po);
	public void init();
	public void finish();
}
