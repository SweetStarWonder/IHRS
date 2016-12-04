package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import po.EvaluatePO;
import vo.HotelVO;
import vo.RoomVO;

public interface HotelOperationService {
	
	public HotelVO evaluateHotel(EvaluatePO evaluatePO,HotelVO hotelVO);  //评价酒店
	
	public boolean modifyHotelInformation(HotelVO hotelVO);  //酒店工作人员修改酒店信息
	
	public boolean addRooms(ArrayList<RoomVO> roomVOs);  //酒店工作人员添加房间
	
	public boolean updateCheckOut(ArrayList<RoomVO> roomsVO);  //酒店工作人员更新退房信息
	
	public boolean addHotel(HotelVO hotelVO);  //添加酒店
}
