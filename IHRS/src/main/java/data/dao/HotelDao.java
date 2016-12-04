package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelPO;

public interface HotelDao extends java.rmi.Remote {
	
	public HotelPO getHotel(int hotelId) throws RemoteException;
	
	public ArrayList<HotelPO> getHotelsByStarRating(String position,String businessDistrict,int starRating) throws RemoteException;
	
	public ArrayList<HotelPO> getHotelsByRankValue(String position,String businessDistrict,int lowValue,int highValue) throws RemoteException;
	
	public ArrayList<HotelPO> getHotelsByName(String position,String businessDistrict,String hotelName) throws RemoteException;
	
	public ArrayList<HotelPO> getHotelByRoom(String position,String businessDistrict,int roomMinNum) throws RemoteException;
	
	public boolean addHotel(HotelPO hotelPO) throws RemoteException;
	
	public boolean update(HotelPO hotelPO) throws RemoteException;
}
