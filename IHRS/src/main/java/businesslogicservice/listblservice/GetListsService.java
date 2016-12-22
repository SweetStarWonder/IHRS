package businesslogicservice.listblservice;

import java.util.HashMap;

import vo.CustomerVO;
import vo.HotelVO;
import vo.ListVO;

public interface GetListsService {
	
	/**
	 * @param hotelId  酒店编号
	 * @return         获取酒店所有订单
	 */
	public HashMap<Integer,ListVO> getHotelLists(int hotelId);
	
	/**
	 * @param customerVO  客户
	 * @param hotelVO     酒店
	 * @return            获取客户在酒店的所有订单（左客户编号）
	 */
	public HashMap<Integer,ListVO> getPersonalListsInHotel(CustomerVO customerVO,HotelVO hotelVO);
	
	/**
	 * @return  获取每日未执行订单（左客户编号）
	 */
	public HashMap<Integer,ListVO> getDailyUnexecutedLists();
	
}
