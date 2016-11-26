package data.dataHelper;

import java.util.HashMap;

import po.CreditChangePO;

public interface CreditChangeDataHelper {
	
	public HashMap<Integer, CreditChangePO> getCreditChangeData();	//左边是userId

	public void updateCreditChangeData(HashMap<Integer, CreditChangePO> creditChangeMap);
}
