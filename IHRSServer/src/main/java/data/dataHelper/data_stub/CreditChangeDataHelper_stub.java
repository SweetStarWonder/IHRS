package data.dataHelper.data_stub;

import java.util.ArrayList;
import java.util.HashMap;

import data.dataHelper.CreditChangeDataHelper;
import po.CreditChangeMove;
import po.CreditChangePO;

public class CreditChangeDataHelper_stub implements CreditChangeDataHelper{

	public HashMap<Integer, ArrayList<CreditChangePO>> getCreditChangeData(){
		ArrayList<CreditChangePO> arrayList = new ArrayList<>();
		CreditChangePO creditChangePO = new CreditChangePO(00001, "2016/10/01 08:00:00", "00002", 100, 500, CreditChangeMove.LISTABNORMAL);
		arrayList.add(creditChangePO);
		HashMap<Integer, ArrayList<CreditChangePO>> hashMap = new HashMap<>();
		hashMap.put(00001, arrayList);
		return hashMap;
	}
	
	public void updateCreditChangeData(HashMap<Integer, ArrayList<CreditChangePO>> creditChangeMap){
		
	}
}
