package data.dao_stub;

import java.rmi.RemoteException;

import data.dao.CustomerDao;
import po.CustomerPO;

public class CustomerDao_stub implements CustomerDao{

	@Override
	public CustomerPO getCustomer(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		return new CustomerPO(userId, "customerName", "phone");
	}

	@Override
	public CustomerPO getCustomer(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return new CustomerPO(00001, userName, "phone");
	}

	@Override
	public boolean updateCustomer(CustomerPO customerPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addCustomer(CustomerPO customerPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
