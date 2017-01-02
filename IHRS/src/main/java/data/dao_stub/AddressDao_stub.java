package data.dao_stub;

import java.util.ArrayList;
import java.util.HashMap;

import data.dao.AddressDao;

public class AddressDao_stub implements AddressDao{

	public HashMap<String,ArrayList<String>> getAddresses(){
		HashMap<String, ArrayList<String>> hash = new HashMap<>();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Address");
		hash.put("businessdistrict", arrayList);
		return hash;
	}
}
