package dataservice.promotiondataservice;

import dataservice.datafactoryservice.DatabaseService;
import po.PromotionPO;

public interface PromotionDataService extends DatabaseService {
	public PromotionPO find(String userid);
	public void insert(PromotionPO po);
	public void update(PromotionPO po);
	public void init();
	public void finish();
}
