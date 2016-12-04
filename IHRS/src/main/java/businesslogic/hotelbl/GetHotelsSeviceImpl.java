package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import businesslogicservice.hotelblservice.GetHotelsService;
import data.dao.HotelDao;
import data.dao.ListDao;
import po.HotelPO;
import po.ListPO;
import po.RoomStatus;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.HotelVO;
import vo.RoomVO;

public class GetHotelsSeviceImpl implements GetHotelsService{

	private CustomerVO customerVO;
	
	private HotelDao hotelDao;
	
	private ListDao listDao;
	
	public GetHotelsSeviceImpl(CustomerVO customerVO) {
		this.customerVO = customerVO;
		this.hotelDao = RemoteHelper.getInstance().getHotelDao();
		this.listDao = RemoteHelper.getInstance().getListDao();
	}
	
	public HashMap<Integer, HotelVO> getReservedHotels() {
		HashMap<Integer, HotelVO> hotels = new HashMap<Integer, HotelVO>();
		try {
			HashMap<Integer, ListPO> lists = listDao.getListsByUser(customerVO.getId());
			Iterator<Integer> iterator = lists.keySet().iterator();
			while (iterator.hasNext()) {
				Integer listId = (Integer) iterator.next();
				int hotelId = lists.get(listId).getHotelId();
				if (!hotels.containsKey(hotelId)) {
					hotels.put(hotelId, new HotelVO(hotelDao.getHotel(hotelId)));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotels;
	}

	public HashMap<Integer, HotelVO> searchHotels(String address, String businessDistrict, String hotelName, int roomNum,
			int lowValue, int highValue, int starRating,RoomStatus roomStatus, int lowPrice, int highPrice, boolean ifReserved) {
		HashMap<Integer, HotelVO> allHotels = searchHotelByStarRating(address, businessDistrict, starRating);
		if (!hotelName.isEmpty()) {
			HashMap<Integer, HotelVO> hotelsByName = searchHotelByName(address, businessDistrict, hotelName);
			HashMap<Integer, HotelVO> tempMap = new HashMap<Integer, HotelVO>();
			Iterator<Integer> iterator = hotelsByName.keySet().iterator();
			while (iterator.hasNext()) {
				Integer hotelId = (Integer) iterator.next();
				if (allHotels.containsKey(hotelId)) {
					tempMap.put(hotelId, hotelsByName.get(hotelId));
				}
			}
			allHotels = tempMap;
		}
		
		if(roomNum > 0) {
			HashMap<Integer, HotelVO> hotelsByRoom = searchHotelByRoom(address, businessDistrict, roomNum);
			HashMap<Integer, HotelVO> tempMap = new HashMap<Integer, HotelVO>();
			Iterator<Integer> iterator = hotelsByRoom.keySet().iterator();
			while (iterator.hasNext()) {
				Integer hotelId = (Integer) iterator.next();
				if (allHotels.containsKey(hotelId)) {
					tempMap.put(hotelId, hotelsByRoom.get(hotelId));
				}
			}
			allHotels = tempMap;
		}
		
		if(highValue > 0) {
			HashMap<Integer, HotelVO> hotelsByValue = searchHotelByRankValue(address, businessDistrict, lowValue, highValue);
			HashMap<Integer, HotelVO> tempMap = new HashMap<Integer, HotelVO>();
			Iterator<Integer> iterator = hotelsByValue.keySet().iterator();
			while (iterator.hasNext()) {
				Integer hotelId = (Integer) iterator.next();
				if (allHotels.containsKey(hotelId)) {
					tempMap.put(hotelId, hotelsByValue.get(hotelId));
				}
			}
			allHotels = tempMap;
		}
		
		if(ifReserved == true) {
			HashMap<Integer, HotelVO> hotelsReserved = getReservedHotels();
			HashMap<Integer, HotelVO> tempMap = new HashMap<Integer, HotelVO>();
			Iterator<Integer> iterator = hotelsReserved.keySet().iterator();
			while (iterator.hasNext()) {
				Integer hotelId = (Integer) iterator.next();
				if (allHotels.containsKey(hotelId)) {
					tempMap.put(hotelId, hotelsReserved.get(hotelId));
				}
			}
			allHotels = tempMap;
		}
		
		if(roomStatus!=null && highPrice>0) {
			allHotels = searchHotelByPrice(allHotels, roomStatus, lowPrice, highPrice);
		}
		
		return allHotels;
	}
	
	
	private HashMap<Integer, HotelVO> searchHotelByPrice(HashMap<Integer, HotelVO> hotelMap, RoomStatus roomStatus, int lowPrice, int highPrice) {
		Iterator<Integer> iterator = hotelMap.keySet().iterator();
		while (iterator.hasNext()) {
			Integer hotelId = (Integer) iterator.next();
			ArrayList<RoomVO> rooms = hotelMap.get(hotelId).getRooms();
			roomLoop: for (RoomVO roomVO : rooms) {
				if (roomVO.getStatus().equals(roomStatus)) {
					if (roomVO.getPrice()<lowPrice && roomVO.getPrice()>highPrice) {
						hotelMap.remove(hotelId);
					}
					break roomLoop;
				}
			}
		}
		
		return hotelMap;
	}
	
	private HashMap<Integer, HotelVO> searchHotelByName(String address, String businessDistrict, String hotelName) {
		HashMap<Integer, HotelVO> hotelMap = new HashMap<Integer, HotelVO>();
		try {
			ArrayList<HotelPO> hotelList = hotelDao.getHotelsByName(address, businessDistrict, hotelName);
			for (HotelPO hotelPO : hotelList) {
				hotelMap.put(hotelPO.getId(), new HotelVO(hotelPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelMap;
	}
	
	private HashMap<Integer, HotelVO> searchHotelByRoom(String address, String businessDistrict, int roomNum) {
		HashMap<Integer, HotelVO> hotelMap = new HashMap<Integer, HotelVO>();
		try {
			ArrayList<HotelPO> hotelList = hotelDao.getHotelByRoom(address, businessDistrict, roomNum);
			for (HotelPO hotelPO : hotelList) {
				hotelMap.put(hotelPO.getId(), new HotelVO(hotelPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelMap;
	}
	
	private HashMap<Integer, HotelVO> searchHotelByStarRating(String address, String businessDistrict, int starRating) {
		HashMap<Integer, HotelVO> hotelMap = new HashMap<Integer, HotelVO>();
		try {
			ArrayList<HotelPO> hotelList = hotelDao.getHotelsByStarRating(address, businessDistrict, starRating);
			for (HotelPO hotelPO : hotelList) {
				hotelMap.put(hotelPO.getId(), new HotelVO(hotelPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelMap;
	}
	
	private HashMap<Integer, HotelVO> searchHotelByRankValue(String address, String businessDistrict, int lowValue, int highValue) {
		HashMap<Integer, HotelVO> hotelMap = new HashMap<Integer, HotelVO>();
		try {
			ArrayList<HotelPO> hotelList = hotelDao.getHotelsByRankValue(address, businessDistrict, lowValue, highValue);
			for (HotelPO hotelPO : hotelList) {
				hotelMap.put(hotelPO.getId(), new HotelVO(hotelPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return hotelMap;
	}
}
