package data.dataHelper.data_stub;

import java.util.HashMap;

import data.dataHelper.ListDataHelper;
import po.ListPO;
import po.ListStatus;

public class ListDataHelper_stub implements ListDataHelper{

	@Override
	public HashMap<Integer, HashMap<Integer, ListPO>> getListDataByUser() {
		// TODO Auto-generated method stub
		HashMap<Integer, ListPO> hashMap1 = new HashMap<>();
		ListPO listPO = new ListPO(00002, 2222, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true);
		hashMap1.put(00002, listPO);
		HashMap<Integer, HashMap<Integer, ListPO>> hashMap = new HashMap<>();
		hashMap.put(00001, hashMap1);
		return hashMap;
	}

	@Override
	public HashMap<Integer, HashMap<Integer, ListPO>> getListDataByHotel() {
		// TODO Auto-generated method stub
		HashMap<Integer, ListPO> hashMap1 = new HashMap<>();
		ListPO listPO = new ListPO(00002, 2222, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true);
		hashMap1.put(00002, listPO);
		HashMap<Integer, HashMap<Integer, ListPO>> hashMap = new HashMap<>();
		hashMap.put(2222, hashMap1);
		return hashMap;
	}

	@Override
	public void updateListDataByUser(HashMap<Integer, HashMap<Integer, ListPO>> listDataMap) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateListDataByHotel(HashMap<Integer, HashMap<Integer, ListPO>> listDataMap) {
		// TODO Auto-generated method stub
		
	}

}
