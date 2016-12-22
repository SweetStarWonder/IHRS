package data.dataHelper;

import java.util.ArrayList;
import java.util.HashMap;

import po.CreditChangePO;

public interface CreditChangeDataHelper {
	
	/**
	 * @return  用户所有信用记录（左用户编号）
	 */
	public HashMap<Integer, ArrayList<CreditChangePO>> getCreditChangeData();

	/**
	 * @param creditChangeMap 用户所有信用记录（左用户编号）
	 */
	public void updateCreditChangeData(HashMap<Integer, ArrayList<CreditChangePO>> creditChangeMap);
	
}
