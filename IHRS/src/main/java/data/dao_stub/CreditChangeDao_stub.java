package data.dao_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.CreditChangeDao;
import po.CreditChangeMove;
import po.CreditChangePO;

public class CreditChangeDao_stub implements CreditChangeDao{

	@Override
	public ArrayList<CreditChangePO> getCreditChange(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<CreditChangePO> arrayList = new ArrayList<>();
		CreditChangePO creditChangePO = new CreditChangePO(00001, "2016/10/01 08:00:00", "00002", 100, 800, CreditChangeMove.LISTABNORMAL);
		arrayList.add(creditChangePO);
		return arrayList;
	}

	@Override
	public boolean addCreditChange(CreditChangePO creditChangePO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
