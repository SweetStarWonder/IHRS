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
	 * @return            获取客户在酒店的所有订单（左订单编号）
	 */
	public HashMap<Integer,ListVO> getPersonalListsInHotel(CustomerVO customerVO,HotelVO hotelVO);
	
	/**
	 * @param timeNow  当天日期（yyyy/MM/dd）
	 * @return         获取所有当日未执行订单
	 */
	public HashMap<Integer,ListVO> getDailyUnexecutedLists(String timeNow);
	
	/**
	 * @return  获取所有异常订单(左订单编号)
	 */
	public HashMap<Integer, ListVO> getAbnormalLists();
	
}
