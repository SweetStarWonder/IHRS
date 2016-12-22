package data.dao;

import java.util.HashMap;

public interface RankSystemDao extends java.rmi.Remote{
	
	/**
	 * @return  获取等级制度（左等级，右信用）
	 * @throws Exception
	 */
	public HashMap<Integer,Integer> getRanks() throws Exception;
	
	/**
	 * @param ranks  等级制度
	 * @return       是否修改成功
	 * @throws Exception
	 */
	public boolean updateRank(HashMap<Integer,Integer> ranks) throws Exception;
	
}
