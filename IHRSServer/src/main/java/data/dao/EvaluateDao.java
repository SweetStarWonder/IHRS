package data.dao;

import java.util.ArrayList;

import po.EvaluatePO;

public interface EvaluateDao {
	public ArrayList<EvaluatePO> getEvaluates(int hotelId);
	
	public boolean addEvaluate(EvaluatePO evaluatePO);
}
