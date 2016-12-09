package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.dao.NormalVipDao;
import data.dataHelper.DataFactory;
import data.dataHelper.NormalVipDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.NormalVipPO;

public class NormalVipDaoImpl extends java.rmi.server.UnicastRemoteObject implements NormalVipDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2671616732811426866L;

	private HashMap<Integer, NormalVipPO> map;
	
	private NormalVipDataHelper normalVipDataHelper;
	
	private DataFactory dataFactory;
	
	private static NormalVipDaoImpl normalVipDaoImpl;
	
	public static NormalVipDaoImpl getInstance() throws RemoteException {
		if (normalVipDaoImpl == null) {
			normalVipDaoImpl = new NormalVipDaoImpl();
		}
		return normalVipDaoImpl;
	}
	
	private NormalVipDaoImpl() throws RemoteException {
		if (map == null) {
			dataFactory = new DataFactoryImpl();
			normalVipDataHelper = dataFactory.getNormalVipDataHelper();
			map = normalVipDataHelper.getNormalVipData();
		}
	}

	public ArrayList<NormalVipPO> getNormaVips(String birthday) throws RemoteException {
		ArrayList<NormalVipPO> vips = new ArrayList<NormalVipPO>();
		Iterator<Integer> iterator = map.keySet().iterator();
		while (iterator.hasNext()) {
			Integer id = (Integer) iterator.next();
			if (map.get(id).getBirthday().equals(birthday)) {
				vips.add(map.get(id));
			}
		}
		return vips;
	}

	public NormalVipPO getNormalVip(int userId) throws RemoteException {
		if (map.containsKey(userId)) {
			return map.get(userId);			
		} else {
			return null;
		}
	}

	public boolean addNormalVip(NormalVipPO normalVipPO) throws RemoteException {
		int id = normalVipPO.getId();
		if (map.containsKey(id)) {
			return false;
		} else {
			map.put(id, normalVipPO);
			normalVipDataHelper.updateNormalVipData(map);
			return true;
		}
	}

	public boolean updateNormalVip(NormalVipPO normalVipPO) throws RemoteException {
		int id = normalVipPO.getId();
		if (map.containsKey(id)) {
			map.put(id, normalVipPO);
			normalVipDataHelper.updateNormalVipData(map);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteNormalVip(NormalVipPO normalVipPO) throws RemoteException {
		int id = normalVipPO.getId();
		if (map.containsKey(id)) {
			map.remove(id);
			normalVipDataHelper.updateNormalVipData(map);
			return true;
		} else {
			return false;
		}
	}

}

