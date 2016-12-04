package businesslogicservice.listblservice;

import java.util.HashMap;

import vo.CustomerVO;
import vo.HotelVO;
import vo.ListVO;

public interface GetListsService {
	
	public HashMap<Integer,ListVO> getHotelLists(int hotelId);  //获取酒店所有订单
	
	public HashMap<Integer,ListVO> getPersonalListsInHotel(CustomerVO customerVO,HotelVO hotelVO);  //获取用户在酒店的所有订单
	
	public HashMap<Integer,ListVO> getDailyUnexecutedLists();  //网站营销人员得到每日未执行订单
	
}
