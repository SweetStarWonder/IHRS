package data.dataHelper;

import java.util.HashMap;

import po.ListPO;

public interface ListDataHelper {
	public HashMap<Integer, ListPO> getListDataByUser();
	
	public HashMap<Integer, ListPO> getListDataByHotel();
	
	public void updateListDataByUser(HashMap<Integer, ListPO> listDataMap);
	
	public void updateListDataByHotel(HashMap<Integer, ListPO> listDataMap);
}
