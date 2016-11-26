package data.dataHelper;

import java.util.HashMap;

import po.EvaluatePO;

public interface EvaluateDataHelper {

	public HashMap<Integer, EvaluatePO> getEvaluateData();
	
	public void updateEvaluateData(HashMap<Integer, EvaluatePO> evaluateDataMap);
}
