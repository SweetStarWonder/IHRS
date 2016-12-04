package data.dao.impl;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import data.dao.HotelManagerDao;
import data.dataHelper.DataFactory;
import data.dataHelper.HotelManagerDataHelper;
import data.dataHelper.impl.DataFactoryImpl;
import po.HotelManagerPO;

public class HotelManagerDaoImpl extends java.rmi.server.UnicastRemoteObject implements HotelManagerDao{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6113486937883211589L;

	private HashMap<Integer, HotelManagerPO> map;
	
	private HotelManagerDataHelper hotelManagerDataHelper;
	
	private DataFactory dataFactory;
	
	private static HotelManagerDaoImpl hotelManagerDaoImpl;
	
	public static HotelManagerDaoImpl getInstance() throws RemoteException{
		if(hotelManagerDaoImpl==null){
			hotelManagerDaoImpl=new HotelManagerDaoImpl();
		}
		return hotelManagerDaoImpl;
	}

	private HotelManagerDaoImpl() throws RemoteException {
		if(map==null){
			dataFactory=new DataFactoryImpl();
			hotelManagerDataHelper=dataFactory.getHotelManagerDataHelper();
			map=hotelManagerDataHelper.getHotelManagerData();
		}
	}

	public HotelManagerPO getHotelManagerByUser(int hotelManagerId) throws RemoteException {
		HotelManagerPO hotelManager=map.get(hotelManagerId);
		return hotelManager;
	}
 
	public HotelManagerPO getHotelManagerByHotel(int hotelId) throws RemoteException{
		HotelManagerPO hotelManager = null;
		Iterator<Map.Entry<Integer,HotelManagerPO>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry<Integer,HotelManagerPO> entry = iterator.next();
			HotelManagerPO hotelManagerPO=entry.getValue();
			if(hotelManagerPO.getHotelId()==hotelId){
				hotelManager=hotelManagerPO;
			}
		}
		return hotelManager;
	}

	public boolean addHotelManager(HotelManagerPO hotelManagerPO) throws RemoteException {
		int hotelManagerId=hotelManagerPO.getId();
		if(!map.containsKey(hotelManagerId)){
			map.put(hotelManagerId, hotelManagerPO);
			hotelManagerDataHelper.updateHotelManagerData(map);
			return true;
		}
		return false;
	}

	public boolean updateHotelManager(HotelManagerPO hotelManagerPO) {
		int hotelManagerId=hotelManagerPO.getId();
		if(map.containsKey(hotelManagerId)){
			map.put(hotelManagerId,hotelManagerPO);
			hotelManagerDataHelper.updateHotelManagerData(map);
			return true;
		}
		return false;
	}

}
