package controller.impl;

import java.util.ArrayList;

import businesslogic.hotelbl.GetHotelsSeviceImpl;
import businesslogic.hotelbl.HotelOperationServiceImpl;
import businesslogic.listbl.GetListsServiceImpl;
import businesslogic.listbl.ListOperationServiceImpl;
import businesslogic.promotionbl.HotelPromotionBlServiceImpl;
import businesslogicservice.hotelblservice.GetHotelsService;
import businesslogicservice.hotelblservice.HotelOperationService;
import businesslogicservice.listblservice.GetListsService;
import businesslogicservice.listblservice.ListOperationService;
import businesslogicservice.promotionblservice.HotelPromotionBlService;
import controller.HotelManagerController;
import controller.LoginController;
import po.ListStatus;
import presentation.hotelManager.HotelManagerView;
import presentation.hotelManager.list.ListViewController;
import presentation.hotelManager.promotion.HotelPromotionListController;
import presentation.hotelManager.room.RoomManageController;
import utility.TimeUtility;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.ListVO;
import vo.RoomVO;
import vo.promotionVO.HotelPromotionVO;
import vo.promotionVO.PromotionVO;

public class HotelManagerControllerImpl implements HotelManagerController {

	private HotelManagerView view;

	private HotelManagerVO self;

	private HotelVO hotelVO;

	private LoginController controller;

	private HotelOperationService hotelOperationService;

	private ListOperationService listOperationService;

	private GetListsService getListsService;

	private HotelPromotionBlService hotelPromotionService;

	private GetHotelsService getHotelService;

	public HotelManagerControllerImpl() {
		this.hotelOperationService = new HotelOperationServiceImpl();
		this.listOperationService = new ListOperationServiceImpl();
		this.getListsService = new GetListsServiceImpl();
		this.hotelPromotionService = new HotelPromotionBlServiceImpl();
		this.getHotelService = new GetHotelsSeviceImpl(null);
	}

	@Override
	public void setController(LoginController controller) {
		this.controller = controller;
	}

	@Override
	public void setHotelManager(HotelManagerVO hotelManagerVO) {
		this.self = hotelManagerVO;
		this.hotelVO = getHotelService.getHotel(self.getHotelId());
		System.out.println(hotelVO);
	}

	@Override
	public HotelManagerVO getSelf() {
		return self;
	}

	@Override
	public HotelVO getHotel() {
		return hotelVO;
	}

	@Override
	public void setView(HotelManagerView view) {
		this.view = view;
	}

	@Override
	public void showHotelInformation() {
		view.showHotelInformation();
	}

	@Override
	public void modifyHotelInformation() {
		view.modifyHotelInformation();
	}

	@Override
	public void showHotelPromotion() {
		view.showHotelPromotion();
	}

	@Override
	public void addNormalPromotionPane(HotelPromotionListController upperController, String type) {
		view.addNormalPromotionPane(upperController, type);
	}

	@Override
	public void addTimePromotionPane(HotelPromotionListController upperController) {
		view.addTimePromotionPane(upperController);
	}

	@Override
	public void showRoomInformation() {
		view.showRoomInformation();
	}

	@Override
	public void addRoomPane(RoomManageController upperController) {
		view.addRoomPane(upperController);
	}

	@Override
	public void showLists() {
		view.showLists();
	}

	@Override
	public void showCheckInRecord(ListViewController upperController, ListVO listVO) {
		view.showCheckInRecord(upperController, listVO);
	}

	@Override
	public void showCheckOutRecord(ListViewController upperController, ListVO listVO) {
		view.showCheckOutRecord(upperController, listVO);
	}

	@Override
	public void backView() {
		view.backView();
	}

	@Override
	public void signout() {
		controller.signOut();
	}

	@Override
	public boolean modifyHotelInformation(HotelVO hotelVO) {
		return hotelOperationService.modifyHotelInformation(hotelVO);
	}

	@Override
	public ArrayList<HotelPromotionVO> getPromotions() {
		return hotelPromotionService.getHotelPromotions(hotelVO.getId());
	}

	@Override
	public boolean addPromotion(HotelPromotionVO promotion) {
		return hotelPromotionService.addHotelPromotion(promotion);
	}

	@Override
	public boolean deletePromotion(HotelPromotionVO promotion) {
		return hotelPromotionService.deleteHotelPromotion(promotion);
	}

	@Override
	public ArrayList<RoomVO> getRooms() {
		return hotelVO.getRooms();
	}

	@Override
	public boolean addRooms(ArrayList<RoomVO> rooms) {
		boolean add = hotelOperationService.addRooms(rooms);
		hotelVO = getHotelService.getHotel(self.getHotelId());
		return add;
	}

	@Override
	public boolean checkIn(RoomVO roomVO) {
		ArrayList<RoomVO> roomVOs = new ArrayList<RoomVO>();
		roomVOs.add(roomVO);
		return hotelOperationService.updateCheckIn(roomVOs, 100000);
	}

	@Override
	public boolean checkOut(RoomVO roomVO) {
		ArrayList<RoomVO> roomVOs = new ArrayList<RoomVO>();
		roomVOs.add(roomVO);
		return hotelOperationService.updateCheckOut(roomVOs);
	}

	@Override
	public ArrayList<ListVO> getLists() {
		ArrayList<ListVO> lists = new ArrayList<ListVO>();
		lists.addAll(getListsService.getHotelLists(hotelVO.getId()).values());
		ArrayList<ListVO> checkedLists = new ArrayList<ListVO>();
		for (ListVO listVO : lists) {
			if (listVO.getStatus().equals(ListStatus.NOTEXECUTED)) {
				checkedLists.add(checkList(listVO));
			} else {
				checkedLists.add(listVO);
			}
		}
		return checkedLists;
	}

	@Override
	public ListVO listCheckIn(ListVO listVO, String timeNow) {
		return listOperationService.executeList(listVO, timeNow);
	}

	@Override
	public ListVO listCheckOut(ListVO listVO, String timeNow) {
		return listOperationService.updateCheckOut(listVO, timeNow);
	}

	@Override
	public ListVO abnormalListCheckIn(ListVO listVO, String timeNow) {
		return listOperationService.lateCheckIn(listVO, timeNow);
	}

	private ListVO checkList(ListVO listVO) {
		if (listVO.getLastListExecutedTime().compareTo(TimeUtility.getTimeStr()) <= 0) {
			listVO = listOperationService.setAbnormal(listVO, TimeUtility.getTimeStr());
		}
		return listVO;
	}

}
