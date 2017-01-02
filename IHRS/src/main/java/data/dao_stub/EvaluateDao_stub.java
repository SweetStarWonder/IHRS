package data.dao_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.EvaluateDao;
import po.EvaluatePO;

public class EvaluateDao_stub implements EvaluateDao{

	@Override
	public ArrayList<EvaluatePO> getEvaluates(int hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		EvaluatePO evaluatePO = new EvaluatePO(hotelId, "customerName", 5, "contents");
		ArrayList<EvaluatePO> arrayList = new ArrayList<>();
		arrayList.add(evaluatePO);
		return arrayList;
	}

	@Override
	public boolean addEvaluate(EvaluatePO evaluatePO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
