package data.dao_stub;

import java.util.HashMap;

import data.dao.RankSystemDao;

public class RankSystemDao_stub implements RankSystemDao{

	@Override
	public HashMap<Integer, Integer> getRanks() throws Exception {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(500, 1);
		return hashMap;
	}

	@Override
	public boolean updateRank(HashMap<Integer, Integer> ranks) throws Exception {
		// TODO Auto-generated method stub
		return true;
	}

}
