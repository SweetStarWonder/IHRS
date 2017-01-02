package businesslogicservice.hotelblservice;

import java.util.HashMap;

import po.RoomStatus;
import vo.HotelVO;

public interface GetHotelsService {
	
	/**
	 * @return  获取已预订酒店列表
	 */
	public HashMap<Integer,HotelVO> getReservedHotels();
	
	/**
	 * @param address           地址
	 * @param businessDistrict  商圈
	 * @param hotelName         酒店名
	 * @param roomNum           房间数量
	 * @param lowValue          最低评分
	 * @param highValue         最高评分
	 * @param starRating        星级
	 * @param roomStatus        房间状态
	 * @param lowPrice          最低价格
	 * @param highPrice         最高价格
	 * @param ifReserved        是否预定过
	 * @return                  按类搜索酒店，获取酒店列表
	 */
	public HashMap<Integer,HotelVO> searchHotels(String address,String businessDistrict,String hotelName,int roomNum,
			int lowValue,int highValue,int starRating,RoomStatus roomStatus,int lowPrice,int highPrice,boolean ifReserved);
	
	/**
	 * @param hotelId  酒店编号
	 * @return         根据编号获取酒店
	 */
	public HotelVO getHotel(int hotelId);
	
}
