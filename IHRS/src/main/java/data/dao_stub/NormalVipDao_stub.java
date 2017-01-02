package data.dao_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.NormalVipDao;
import po.NormalVipPO;

public class NormalVipDao_stub implements NormalVipDao{

	@Override
	public ArrayList<NormalVipPO> getNormaVips(String birthday) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<NormalVipPO> arrayList = new ArrayList<>();
		NormalVipPO normalVipPO = new NormalVipPO(00001, "customerName", "phone", 0, "birthday");
		arrayList.add(normalVipPO);
		return arrayList;
	}

	@Override
	public NormalVipPO getNormalVip(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		return new NormalVipPO(userId, "customerName", "phone", 0, "birthday");
	}

	@Override
	public boolean addNormalVip(NormalVipPO normalVipPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateNormalVip(NormalVipPO normalVipPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deleteNormalVip(NormalVipPO normalVipPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}
}
