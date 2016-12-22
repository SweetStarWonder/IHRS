package data.dataHelper;

import java.util.ArrayList;
import java.util.HashMap;

import po.EvaluatePO;

public interface EvaluateDataHelper {

	/**
	 * @return  酒店所有评价信息（左酒店编号）
	 */
	public HashMap<Integer, ArrayList<EvaluatePO>> getEvaluateData();
	
	/**
	 * @param evaluateDataMap  酒店所有评价信息（左酒店编号）
	 */
	public void updateEvaluateData(HashMap<Integer, ArrayList<EvaluatePO>> evaluateDataMap);
}
