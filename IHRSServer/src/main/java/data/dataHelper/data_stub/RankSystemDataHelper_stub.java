package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.RankSystemDataHelper;

public class RankSystemDataHelper_stub implements RankSystemDataHelper{

	@Override
	public HashMap<Integer, Integer> getRanks() {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(500, 1);
		return hashMap;
	}

	@Override
	public boolean updateRank(HashMap<Integer, Integer> ranks) {
		// TODO Auto-generated method stub
		return true;
	}

}
