package data.dataHelper;

import java.util.HashMap;

import po.ListPO;

public interface ListDataHelper {
	
	public HashMap<Integer, HashMap<Integer, ListPO>> getListDataByUser();  //左边为userId,右边为listId
	
	public HashMap<Integer, HashMap<Integer, ListPO>> getListDataByHotel();  //左边为hotelId,右边为listId
	
	public void updateListDataByUser(HashMap<Integer, HashMap<Integer, ListPO>> listDataMap);
	
	public void updateListDataByHotel(HashMap<Integer, HashMap<Integer, ListPO>> listDataMap);
}
