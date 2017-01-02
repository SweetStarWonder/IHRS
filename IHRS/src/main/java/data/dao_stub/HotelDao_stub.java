package data.dao_stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import data.dao.HotelDao;
import po.HotelPO;

public class HotelDao_stub implements HotelDao{

	@Override
	public HotelPO getHotel(int hotelId) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner");
		return new HotelPO(hotelId, partners, "hotelName", "position", "businessDistrict", 5, "introduction", "facility");
	}

	@Override
	public ArrayList<HotelPO> getHotelsByStarRating(String position, String businessDistrict, int starRating)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner");
		ArrayList<HotelPO> arrayList = new ArrayList<>();
		arrayList.add(new HotelPO(2222, partners, "hotelName", position, businessDistrict, starRating, "introduction", "facility"));
		return arrayList;
	}

	@Override
	public ArrayList<HotelPO> getHotelsByRankValue(String position, String businessDistrict, int lowValue,
			int highValue) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner");
		ArrayList<HotelPO> arrayList = new ArrayList<>();
		arrayList.add(new HotelPO(2222, partners, "hotelName", position, businessDistrict, lowValue, "introduction", "facility"));
		return arrayList;
	}

	@Override
	public ArrayList<HotelPO> getHotelsByName(String position, String businessDistrict, String hotelName)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner");
		ArrayList<HotelPO> arrayList = new ArrayList<>();
		arrayList.add(new HotelPO(2222, partners, hotelName, position, businessDistrict, 0, "introduction", "facility"));
		return arrayList;
	}

	@Override
	public ArrayList<HotelPO> getHotelByRoom(String position, String businessDistrict, int roomMinNum)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> partners = new ArrayList<>();
		partners.add("partner");
		ArrayList<HotelPO> arrayList = new ArrayList<>();
		arrayList.add(new HotelPO(2222, partners, "hotelName", position, businessDistrict, 0, "introduction", "facility"));
		return arrayList;
	}

	@Override
	public boolean addHotel(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean update(HotelPO hotelPO) throws RemoteException {
		// TODO Auto-generated method stub
		return true;
	}

}
