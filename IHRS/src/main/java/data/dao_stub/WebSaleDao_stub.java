package data.dao_stub;

import java.rmi.RemoteException;

import data.dao.WebSaleDao;
import po.WebSalePO;

public class WebSaleDao_stub implements WebSaleDao{

	@Override
	public WebSalePO getWebSale(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		return new WebSalePO(userId, "webSaleName", "phone");
	}

	@Override
	public WebSalePO getWebSale(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		return new WebSalePO(00004, userName, "phone");
	}

	@Override
	public boolean addWebSale(WebSalePO webSalePO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateWebSale(WebSalePO webSalePO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
