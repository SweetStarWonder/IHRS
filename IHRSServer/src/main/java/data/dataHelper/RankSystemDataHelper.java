package data.dataHelper;

import java.util.HashMap;

public interface RankSystemDataHelper {
	
	/**
	 * @return  等级制度（左等级，右信用）
	 */
	public HashMap<Integer,Integer> getRanks();
	
	/**
	 * @param ranks   等级制度（左等级，右信用）
	 * @return        是否修改成功
	 */
	public boolean updateRank(HashMap<Integer,Integer> ranks);
	
}
