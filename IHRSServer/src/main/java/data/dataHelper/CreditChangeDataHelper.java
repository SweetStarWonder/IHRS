package data.dataHelper;

import java.util.ArrayList;
import java.util.HashMap;

import po.CreditChangePO;

public interface CreditChangeDataHelper {
	
	public HashMap<Integer, ArrayList<CreditChangePO>> getCreditChangeData();	//左边是userId

	public void updateCreditChangeData(HashMap<Integer, ArrayList<CreditChangePO>> creditChangeMap);
}
