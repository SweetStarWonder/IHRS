package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import po.HotelPO;
import po.RoomPO;

public interface HotelBLService {
	public boolean modify(HotelPO hotel);
	public boolean create(HotelPO hotel);
	public ArrayList<RoomPO> roomFormShow(String name);
	public RoomPO roomChoose(String name);
}
