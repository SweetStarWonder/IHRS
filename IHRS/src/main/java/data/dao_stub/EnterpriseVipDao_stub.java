package data.dao_stub;

import java.rmi.RemoteException;

import data.dao.EnterpriseVipDao;
import po.EnterpriseVipPO;

public class EnterpriseVipDao_stub implements EnterpriseVipDao{

	@Override
	public EnterpriseVipPO getEnterpriseVip(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		return new EnterpriseVipPO(userId, "customerName", "phone", "enterpriseName", 0);
	}

	@Override
	public boolean addEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteEnterpriseVip(EnterpriseVipPO enterpriseVipPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
