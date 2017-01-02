package businesslogic_stub.listbl_stub;

import java.util.ArrayList;
import java.util.HashMap;

import businesslogicservice.listblservice.GetListsService;
import po.ListStatus;
import po.RoomStatus;
import vo.CustomerVO;
import vo.HotelVO;
import vo.ListVO;
import vo.RoomVO;

public class GetListsService_stub implements GetListsService{

	@Override
	public HashMap<Integer, ListVO> getHotelLists(int hotelId) {
		// TODO Auto-generated method stub
		HashMap<Integer, ListVO> hashMap = new HashMap<>();
		ArrayList<RoomVO> rooms = new ArrayList<>();
		rooms.add(new RoomVO(2222, 00002, 503, 500, RoomStatus.DOUBLE));
		ListVO listVO = new ListVO(00002, 2222, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true, rooms);
		hashMap.put(2222, listVO);
		return hashMap;
	}

	@Override
	public HashMap<Integer, ListVO> getPersonalListsInHotel(CustomerVO customerVO, HotelVO hotelVO) {
		// TODO Auto-generated method stub
		HashMap<Integer, ListVO> hashMap = new HashMap<>();
		ListVO listVO = new ListVO(00002, 2222, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true, hotelVO.getRooms());
		hashMap.put(2222, listVO);
		return hashMap;
	}

	@Override
	public HashMap<Integer, ListVO> getDailyUnexecutedLists(String timeNow) {
		// TODO Auto-generated method stub
		HashMap<Integer, ListVO> hashMap = new HashMap<>();
		ArrayList<RoomVO> rooms = new ArrayList<>();
		rooms.add(new RoomVO(2222, 00002, 503, 500, RoomStatus.DOUBLE));
		ListVO listVO = new ListVO(00002, 2222, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true, rooms);
		hashMap.put(2222, listVO);
		return hashMap;
	}

	@Override
	public HashMap<Integer, ListVO> getAbnormalLists() {
		// TODO Auto-generated method stub
		HashMap<Integer, ListVO> hashMap = new HashMap<>();
		ArrayList<RoomVO> rooms = new ArrayList<>();
		rooms.add(new RoomVO(2222, 00002, 503, 500, RoomStatus.DOUBLE));
		ListVO listVO = new ListVO(00002, 2222, 00001, ListStatus.ABNORMAL, "2016/10/01 08:00:00", "2016/10/01 20:00:00", "2016/09/30 08:00:00", 500, true, rooms);
		hashMap.put(2222, listVO);
		return hashMap;
	}

}
