package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import po.EvaluatePO;
import vo.HotelVO;
import vo.RoomVO;

public interface HotelOperationService {
	
	/**
	 * @param evaluatePO  评价信息
	 * @param hotelVO     对应酒店
	 * @return            是否评价成功
	 */
	public boolean evaluateHotel(EvaluatePO evaluatePO,HotelVO hotelVO);
	
	/**
	 * @param hotelVO  酒店信息
	 * @return         是否修改成功
	 */
	public boolean modifyHotelInformation(HotelVO hotelVO);
	
	/**
	 * @param roomVOs  酒店所有房间信息
	 * @return         是否添加成功
	 */
	public boolean addRooms(ArrayList<RoomVO> roomVOs);
	
	/**
	 * @param roomsVO  酒店所有房间信息
	 * @return         退房信息是否更新成功
	 */
	public boolean updateCheckOut(ArrayList<RoomVO> roomsVO);
	
	/**
	 * @param hotelVO  酒店信息
	 * @return         是否添加成功
	 */
	public boolean addHotel(HotelVO hotelVO);
	
	/**
	 * @param roomVOs  酒店房间信息
	 * @param listId   对应订单编号
	 * @return         入住信息是否更新成功
	 */
	public boolean updateCheckIn(ArrayList<RoomVO> roomVOs,int listId);
	
}
