package data.dao;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.HotelPO;

public interface HotelDao extends java.rmi.Remote {
	
	/**
	 * @param hotelId  酒店编号
	 * @return         酒店信息
	 * @throws RemoteException
	 */
	public HotelPO getHotel(int hotelId) throws RemoteException;
	
	/**
	 * @param position          地址
	 * @param businessDistrict  商圈
	 * @param starRating        星级
	 * @return                  匹配的所有酒店
	 * @throws RemoteException
	 */
	public ArrayList<HotelPO> getHotelsByStarRating(String position,String businessDistrict,int starRating) throws RemoteException;
	
	/**
	 * @param position          地址
	 * @param businessDistrict  商圈
	 * @param lowValue          最低价格
	 * @param highValue         最高价格
	 * @return                  匹配的所有酒店
	 * @throws RemoteException
	 */
	public ArrayList<HotelPO> getHotelsByRankValue(String position,String businessDistrict,int lowValue,int highValue) throws RemoteException;
	
	/**
	 * @param position          地址
	 * @param businessDistrict  商圈
	 * @param hotelName         酒店名
	 * @return                  匹配的所有酒店
	 * @throws RemoteException
	 */
	public ArrayList<HotelPO> getHotelsByName(String position,String businessDistrict,String hotelName) throws RemoteException;
	
	/**
	 * @param position          地址
	 * @param businessDistrict  商圈
	 * @param roomMinNum        所需最小房间数量
	 * @return                  匹配的所有酒店
	 * @throws RemoteException
	 */
	public ArrayList<HotelPO> getHotelByRoom(String position,String businessDistrict,int roomMinNum) throws RemoteException;
	
	/**
	 * @param hotelPO  酒店信息
	 * @return         是否添加成功
	 * @throws RemoteException
	 */
	public boolean addHotel(HotelPO hotelPO) throws RemoteException;
	
	/**
	 * @param hotelPO  酒店信息
	 * @return         是否修改成功
	 * @throws RemoteException
	 */
	public boolean update(HotelPO hotelPO) throws RemoteException;
	
}
