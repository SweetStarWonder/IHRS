package data.dao.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.dao.HotelDao;
import data.dataHelper.DataFactory;
import data.dataHelper.EvaluateDataHelper;
import data.dataHelper.HotelDataHelper;
import data.dataHelper.RoomDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.EvaluatePO;
import po.HotelPO;
import po.RoomPO;

public class HotelDaoImpl extends java.rmi.server.UnicastRemoteObject implements HotelDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3016841025902876963L;

	private HashMap<Integer, HotelPO> hotelMap;
	
	private HashMap<Integer, ArrayList<EvaluatePO>> evaluateMap;
	
	private HashMap<Integer, HashMap<Integer, RoomPO>> roomMap;
	
	private DataFactory dataFactory;
	
	private HotelDataHelper hotelDataHelper;
	
	private EvaluateDataHelper evaluateDataHelper;
	
	private RoomDataHelper roomDataHelper;
	
	private static HotelDaoImpl hotelDaoImpl;
	
	public static HotelDaoImpl getInstance() throws RemoteException {
		if (hotelDaoImpl == null) {
			hotelDaoImpl = new HotelDaoImpl();
		}
		return hotelDaoImpl;
	}
	
	private HotelDaoImpl() throws RemoteException {
		if (hotelMap == null) {
			dataFactory = new DataFactoryImpl();
			hotelDataHelper = dataFactory.getHotelDataHelper();
			evaluateDataHelper = dataFactory.getEvaluateDataHelper();
			roomDataHelper = dataFactory.getRoomDataHelper();
			evaluateMap = evaluateDataHelper.getEvaluateData();
			hotelMap = hotelDataHelper.getHotelData();
			roomMap = roomDataHelper.getRoomData();
		}
	}

	public HotelPO getHotel(int hotelId) throws RemoteException {
		if (hotelMap.containsKey(hotelId)) {
			return hotelMap.get(hotelId);
		} else {
			return null;
		}
	}
	
	public ArrayList<HotelPO> getHotelsByStarRating(String position, String businessDistrict, int starRating) throws RemoteException {
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
		Iterator<Integer> iterator = hotelMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer id = (Integer) iterator.next();
			HotelPO hotelPO = hotelMap.get(id);
			if (hotelPO.getPosition().equals(position) && hotelPO.getBusinessDistrict().equals(businessDistrict) && hotelPO.getStarRating() >= starRating) {
				hotelList.add(hotelPO);
			}
		}
		return hotelList;
	}

	public ArrayList<HotelPO> getHotelsByRankValue(String position, String businessDistrict, int lowValue,
			int highValue) throws RemoteException {
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
		Iterator<Integer> iterator = hotelMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer id = (Integer) iterator.next();
			HotelPO hotelPO = hotelMap.get(id);
			if (hotelPO.getPosition().equals(position) && hotelPO.getBusinessDistrict().equals(businessDistrict)) {
				double rankOfHotel = calculateRank(evaluateMap.get(id));
				if (rankOfHotel <= highValue  && rankOfHotel >=lowValue) {
					hotelList.add(hotelPO);
				}
			}
		}
		return hotelList;
	}

	public ArrayList<HotelPO> getHotelsByName(String position, String businessDistrict, String hotelName) throws RemoteException {
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
		Iterator<Integer> iterator = hotelMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer id = (Integer) iterator.next();
			HotelPO hotelPO = hotelMap.get(id);
			if (hotelPO.getPosition().equals(position) && hotelPO.getBusinessDistrict().equals(businessDistrict) && hotelPO.getHotelName().equals(hotelName)) {
				hotelList.add(hotelPO);
			}
		}
		return hotelList;
	}

	public ArrayList<HotelPO> getHotelByRoom(String position, String businessDistrict, int roomMinNum) throws RemoteException {
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
		Iterator<Integer> iterator = hotelMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer id = (Integer) iterator.next();
			HotelPO hotelPO = hotelMap.get(id);
			if (hotelPO.getPosition().equals(position) && hotelPO.getBusinessDistrict().equals(businessDistrict)) {
				int empty = 0;
				HashMap<Integer, RoomPO> rooms= roomMap.get(id);
				Iterator<Integer> innerIter = rooms.keySet().iterator();
				inner: while (innerIter.hasNext()) {
					Integer roomNum = (Integer) innerIter.next();
					if (rooms.get(roomNum).getListId() == 0) {
						empty++;
						if (empty >= roomMinNum) {
							hotelList.add(hotelPO);
							break inner;
						}
					}
				}
			}
		}
		return hotelList;
	}

	public boolean addHotel(HotelPO hotelPO) throws RemoteException {
		int id = hotelPO.getId();
		if (hotelMap.containsKey(id)) {
			return false;
		} else {
			hotelMap.put(id, hotelPO);
			hotelDataHelper.updateHotelData(hotelMap);
			return true;
		}
	}

	public boolean update(HotelPO hotelPO) throws RemoteException {
		int id = hotelPO.getId();
		if (hotelMap.containsKey(id)) {
			hotelMap.put(id, hotelPO);
			hotelDataHelper.updateHotelData(hotelMap);
			return true;
		} else {
			return false;
		}
	}
	
	
	private double calculateRank(ArrayList<EvaluatePO> evaluates) throws RemoteException {
		double rank = 0.0;
		int num = 0;
		if (evaluates.isEmpty()) {
			return rank;
		} else {
			for (EvaluatePO evaluatePO : evaluates) {
				rank += evaluatePO.getRankValue();
				num++;
			}
			return rank / (double)num;
		}
	}

}

