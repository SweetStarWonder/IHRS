package data.dataHelper;

import java.util.ArrayList;
import java.util.HashMap;

import po.EvaluatePO;

public interface EvaluateDataHelper {

	public HashMap<Integer, ArrayList<EvaluatePO>> getEvaluateData();
	
	public void updateEvaluateData(HashMap<Integer, ArrayList<EvaluatePO>> evaluateDataMap);
}
