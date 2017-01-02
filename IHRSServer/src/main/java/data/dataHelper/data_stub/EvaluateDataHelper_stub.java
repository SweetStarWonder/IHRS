package data.dataHelper.data_stub;

import java.util.ArrayList;
import java.util.HashMap;

import data.dataHelper.EvaluateDataHelper;
import po.EvaluatePO;

public class EvaluateDataHelper_stub implements EvaluateDataHelper{

	@Override
	public HashMap<Integer, ArrayList<EvaluatePO>> getEvaluateData() {
		// TODO Auto-generated method stub
		ArrayList<EvaluatePO> arrayList = new ArrayList<>();
		EvaluatePO evaluatePO = new EvaluatePO(2222, "customerName", 5, "contents");
		arrayList.add(evaluatePO);
		HashMap<Integer, ArrayList<EvaluatePO>> hashMap = new HashMap<>();
		hashMap.put(2222, arrayList);
		return hashMap;
	}

	@Override
	public void updateEvaluateData(HashMap<Integer, ArrayList<EvaluatePO>> evaluateDataMap) {
		// TODO Auto-generated method stub
		
	}

}
