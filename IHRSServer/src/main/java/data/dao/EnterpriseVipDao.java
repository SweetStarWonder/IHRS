package data.dao;

import po.EnterpriseVipPO;

public interface EnterpriseVipDao {
	public EnterpriseVipPO getEnterpriseVip(int userId);
	
	public boolean addEnterpriseVip(EnterpriseVipPO enterpriseVipPO);
	
	public boolean updateEnterpriseVip(EnterpriseVipPO enterpriseVipPO);
	
	public boolean deleteEnterpriseVip(EnterpriseVipPO enterpriseVipPO);
}
