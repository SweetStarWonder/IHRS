package controller;

import java.util.ArrayList;

import presentation.hotelManager.HotelManagerView;
import presentation.hotelManager.list.ListViewController;
import presentation.hotelManager.promotion.HotelPromotionListController;
import presentation.hotelManager.room.RoomManageController;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.ListVO;
import vo.RoomVO;
import vo.promotionVO.HotelPromotionVO;

public interface HotelManagerController {

	public void setController(LoginController controller);

	public void setHotelManager(HotelManagerVO hotelManagerVO);

	public HotelManagerVO getSelf();

	public HotelVO getHotel();

	public void setView(HotelManagerView view);

	public void showHotelInformation();

	public void modifyHotelInformation();

	public void showHotelPromotion();

	public void addNormalPromotionPane(HotelPromotionListController upperController, String type);

	public void addTimePromotionPane(HotelPromotionListController upperController);

	public void showRoomInformation();

	public void addRoomPane(RoomManageController upperController);

	public void showLists();

	public void showCheckInRecord(ListViewController upperController, ListVO listVO);

	public void showCheckOutRecord(ListViewController upperController, ListVO listVO);

	public void backView();

	public void signout();

	// 与逻辑层交互

	public boolean modifyHotelInformation(HotelVO hotelVO);

	public ArrayList<HotelPromotionVO> getPromotions();

	public boolean addPromotion(HotelPromotionVO promotion);

	public boolean deletePromotion(HotelPromotionVO promotion);

	public ArrayList<RoomVO> getRooms();

	public boolean addRooms(ArrayList<RoomVO> rooms);

	public boolean checkIn(RoomVO roomVO);

	public boolean checkOut(RoomVO roomVO);

	public ArrayList<ListVO> getLists();

	public ListVO listCheckIn(ListVO listVO, String timeNow);

	public ListVO listCheckOut(ListVO listVO, String timeNow);

	public ListVO abnormalListCheckIn(ListVO listVO, String timeNow);

}
