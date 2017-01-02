package businesslogic_stub.listbl_stub;

import businesslogicservice.listblservice.ListOperationService;
import po.ListStatus;
import vo.ListVO;

public class ListOperationService_stub implements ListOperationService{

	@Override
	public ListVO revokeList(ListVO listVO, String timeNow) {
		// TODO Auto-generated method stub
		return new ListVO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), ListStatus.REVOKED, listVO.getEntryTime(),
				listVO.getLastTime(), timeNow, listVO.getPrice(), true, listVO.getRooms());
	}

	@Override
	public ListVO updateCheckIn(ListVO listVO, String timeNow) {
		// TODO Auto-generated method stub
		return new ListVO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), ListStatus.EXECUTED, timeNow,
				listVO.getLastTime(), listVO.getLastListExecutedTime(), listVO.getPrice(), true, listVO.getRooms());
	}

	@Override
	public ListVO updateCheckOut(ListVO listVO, String timeNow) {
		// TODO Auto-generated method stub
		return new ListVO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), ListStatus.EXECUTED, listVO.getEntryTime(),
				timeNow, listVO.getLastListExecutedTime(), listVO.getPrice(), true, listVO.getRooms());
	}

	@Override
	public ListVO executeList(ListVO listVO, String timeNow) {
		// TODO Auto-generated method stub
		return new ListVO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), ListStatus.EXECUTED, listVO.getEntryTime(), listVO.getLastTime(), listVO.getLastListExecutedTime(), listVO.getPrice(), true, listVO.getRooms());
	}

	@Override
	public ListVO setAbnormal(ListVO listVO, String timeNow) {
		// TODO Auto-generated method stub
		return new ListVO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), ListStatus.ABNORMAL, listVO.getEntryTime(), listVO.getLastTime(), timeNow, listVO.getPrice(), true, listVO.getRooms());
	}

	@Override
	public ListVO lateCheckIn(ListVO listVO, String timeNow) {
		// TODO Auto-generated method stub
		return new ListVO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), ListStatus.EXECUTED, listVO.getEntryTime(), listVO.getLastTime(), timeNow, listVO.getPrice(), true, listVO.getRooms());
	}

	@Override
	public ListVO revokeAbnormalList(ListVO listVO, String revokeTime, boolean isHalf) {
		// TODO Auto-generated method stub
		return new ListVO(listVO.getListId(), listVO.getHotelId(), listVO.getUserId(), ListStatus.REVOKED, listVO.getEntryTime(), listVO.getLastTime(), listVO.getLastListExecutedTime(), listVO.getPrice(), true, listVO.getRooms());
	}

}
