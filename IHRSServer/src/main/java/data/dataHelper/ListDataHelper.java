package data.dataHelper;

import java.util.HashMap;

import po.ListPO;

public interface ListDataHelper {
	
	/**
	 * @return  用户所有订单（左用户编号）
	 */
	public HashMap<Integer, HashMap<Integer, ListPO>> getListDataByUser();  //左边为userId,右边为listId
	
	/**
	 * @return  酒店所有订单（酒店编号）
	 */
	public HashMap<Integer, HashMap<Integer, ListPO>> getListDataByHotel();  //左边为hotelId,右边为listId
	
	/**
	 * @param listDataMap  用户所有订单（左用户编号）
	 */
	public void updateListDataByUser(HashMap<Integer, HashMap<Integer, ListPO>> listDataMap);
	
	/**
	 * @param listDataMap  酒店所有订单（酒店编号）
	 */
	public void updateListDataByHotel(HashMap<Integer, HashMap<Integer, ListPO>> listDataMap);
	
}
