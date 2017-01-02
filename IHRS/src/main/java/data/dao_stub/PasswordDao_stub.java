package data.dao_stub;

import java.rmi.RemoteException;

import data.dao.PasswordDao;
import po.PasswordPO;

public class PasswordDao_stub implements PasswordDao{

	@Override
	public PasswordPO getPasswordById(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		return new PasswordPO(userId, "customerName", "password", "userType");
	}

	@Override
	public PasswordPO getPasswordByName(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return new PasswordPO(00001, userName, "password", "userType");
	}

	@Override
	public boolean addPassword(PasswordPO passwordPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updatePassword(PasswordPO passwordPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateName(int userId, String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
