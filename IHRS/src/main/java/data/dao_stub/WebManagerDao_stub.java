package data.dao_stub;

import java.rmi.RemoteException;

import data.dao.WebManagerDao;
import po.WebManagerPO;

public class WebManagerDao_stub implements WebManagerDao{

	@Override
	public WebManagerPO getWebManager(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		return new WebManagerPO(userId, "webManagerName", "phone");
	}

	@Override
	public boolean updateWebManager(WebManagerPO webManagerPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
