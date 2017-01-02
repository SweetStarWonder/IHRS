package controller;

import java.util.ArrayList;
import java.util.HashMap;

import po.RoomStatus;
import presentation.customer.CustomerView;
import vo.CreditChangeVO;
import vo.CustomerVO;
import vo.EvaluateVO;
import vo.HotelVO;
import vo.ListVO;

public interface CustomerController {

	public void setView(CustomerView view);
	
	public void setController(LoginController controller);
	
	public void setCustomer(CustomerVO customerVO);
	
	public CustomerVO getSelf();
	
	public int getCredit();
	
	public void showPersonalInformation();

	public void modifyPersonalInformation();

	public void showCreditRecord();

	public void registerNormalVip();

	public void registerEnterpriseVip();

	public void showPersonalLists();
	
	public void showHotelLists(HotelVO hotelVO);

	public void showPersonalHotels();

	public void showHotelDetailInformation(HotelVO hotelVO);

	public void showGenerateList(HotelVO hotelVO);

	public void backView();
	
	public void signout();
	
	//与逻辑层交互
	public boolean modifyInformation(CustomerVO customerVO);
	
	public ArrayList<CreditChangeVO> getCreditChanges();
	
	public void registerNormalVip(String birthday);
	
	public void registerEnterpriseVip(String enterpriseName);
	
	public ArrayList<ListVO> getPersonalLists();
	
	public ListVO revokeList(ListVO listVO, String timeNow);
	
	public ArrayList<HotelVO> getPersonalHotels();
	
	public ArrayList<ListVO> getHotelLists(HotelVO hotelVO);
	
	public ArrayList<HotelVO> getSearchResults(String address, String businessDistrict, String hotelName, int roomNum,
			int lowValue, int highValue, int starRating,RoomStatus roomStatus, int lowPrice, int highPrice, boolean ifReserved);
	
	public int generateList(ListVO listVO, String timeNow);
	
	public boolean evaluateHotel(EvaluateVO evaluateVO, HotelVO hotelVO);
	
	public HashMap<String, ArrayList<String>> getAddressMap();
	
	public ArrayList<Integer> getReservedHotelId();

}
