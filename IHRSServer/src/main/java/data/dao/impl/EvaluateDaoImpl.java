package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import data.dao.EvaluateDao;
import data.dataHelper.DataFactory;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.EvaluatePO;

public class EvaluateDaoImpl extends java.rmi.server.UnicastRemoteObject implements EvaluateDao{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4478757084750230717L;

	private HashMap<Integer, ArrayList<EvaluatePO>> map;
	
	private EvaluateDataHelper evaluateDataHelper;
	
	private DataFactory dataFactory;
	
	private static EvaluateDaoImpl evaluateDaoImpl;
	
	public static EvaluateDaoImpl getInstance() throws RemoteException{
		if(evaluateDaoImpl==null){
			evaluateDaoImpl=new EvaluateDaoImpl();
		}
		return evaluateDaoImpl;
	}

	private EvaluateDaoImpl() throws RemoteException {
		if(map==null){
			dataFactory=new DataFactoryImpl();
			evaluateDataHelper=dataFactory.getEvaluateDataHelper();
			map=evaluateDataHelper.getEvaluateData();
		}
	}

	public ArrayList<EvaluatePO> getEvaluates(int hotelId) throws RemoteException {
		if (map.containsKey(hotelId)) {
			ArrayList<EvaluatePO> evaluates=map.get(hotelId);
			return evaluates;			
		} else {
			return new ArrayList<EvaluatePO>();
		}
	}

	public boolean addEvaluate(EvaluatePO evaluatePO) throws RemoteException {
		int hotelId=evaluatePO.getHotelId();
		ArrayList<EvaluatePO> evaluates;
		if (map.containsKey(hotelId)) {
			evaluates=map.get(hotelId);			
		} else {
			evaluates = new ArrayList<EvaluatePO>();
		}
		evaluates.add(evaluatePO);
		map.put(hotelId,evaluates);
		evaluateDataHelper.updateEvaluateData(map);
		return true;
	}

}
