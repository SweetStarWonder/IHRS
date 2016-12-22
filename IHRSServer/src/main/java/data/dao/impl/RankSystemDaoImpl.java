package data.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;

import data.dao.RankSystemDao;
import data.dataHelper.DataFactory;
import data.dataHelper.RankSystemDataHelper;
import data.dataHelper.impl.DataFactoryImpl;

public class RankSystemDaoImpl extends java.rmi.server.UnicastRemoteObject implements RankSystemDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8965673323113264750L;

	private HashMap<Integer, Integer> map;
	
	private DataFactory dataFactory;
	
	private RankSystemDataHelper rankSystemDataHelper;
	
	private static RankSystemDaoImpl rankSystemDaoImpl;
	
	public static RankSystemDao getInstance() throws RemoteException{
		if (rankSystemDaoImpl == null) {
			rankSystemDaoImpl = new RankSystemDaoImpl();
		}
		return rankSystemDaoImpl;
	}
	
	private RankSystemDaoImpl() throws RemoteException {
		if (map == null) {
			dataFactory = new DataFactoryImpl();
			rankSystemDataHelper = dataFactory.getRankSystemDataHelper();
			map = rankSystemDataHelper.getRanks();
		}
	}

	public HashMap<Integer, Integer> getRanks() throws Exception {
		return map;
	}

	public boolean updateRank(HashMap<Integer, Integer> ranks) throws Exception {
		map = ranks;
		rankSystemDataHelper.updateRank(map);
		return true;
	}

}
