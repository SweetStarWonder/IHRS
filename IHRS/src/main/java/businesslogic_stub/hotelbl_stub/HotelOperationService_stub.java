package businesslogic_stub.hotelbl_stub;

import java.util.ArrayList;

import businesslogicservice.hotelblservice.HotelOperationService;
import po.EvaluatePO;
import vo.HotelVO;
import vo.RoomVO;

public class HotelOperationService_stub implements HotelOperationService{

	@Override
	public boolean evaluateHotel(EvaluatePO evaluatePO, HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean modifyHotelInformation(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addRooms(ArrayList<RoomVO> roomVOs) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateCheckOut(ArrayList<RoomVO> roomsVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addHotel(HotelVO hotelVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean updateCheckIn(ArrayList<RoomVO> roomVOs, int listId) {
		// TODO Auto-generated method stub
		return true;
	}

}
