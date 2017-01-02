package data.dataHelper.data_stub;

import java.util.ArrayList;
import java.util.HashMap;

import data.dataHelper.AddressDataHelper;

public class AddressDataHelper_stub implements AddressDataHelper{

	@Override
	public HashMap<String, ArrayList<String>> getAddresses() {
		// TODO Auto-generated method stub
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("address");
		HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
		hashMap.put("businessDistrict", arrayList);
		return hashMap;
	}

}
