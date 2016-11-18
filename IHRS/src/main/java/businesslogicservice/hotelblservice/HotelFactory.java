package businesslogicservice.hotelblservice;

import java.util.ArrayList;

import po.HotelPO;
import vo.HotelVO;

public interface HotelFactory {
	public ArrayList<HotelPO> search(String name);
	public ArrayList<HotelPO> formShow(String type);
	public HotelVO show(String name);
}
