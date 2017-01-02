package controller.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import businesslogic.hotelbl.GetHotelsSeviceImpl;
import businesslogic.hotelbl.HotelOperationServiceImpl;
import businesslogic.listbl.GenerateListServiceImpl;
import businesslogic.listbl.GetListsServiceImpl;
import businesslogic.listbl.ListOperationServiceImpl;
import businesslogic.userbl.FindUserServiceImpl;
import businesslogic.userbl.ModifyInformationServiceImpl;
import businesslogic.vipbl.VipBlServiceImpl;
import businesslogicservice.hotelblservice.GetHotelsService;
import businesslogicservice.hotelblservice.HotelOperationService;
import businesslogicservice.listblservice.GenerateListService;
import businesslogicservice.listblservice.GetListsService;
import businesslogicservice.listblservice.ListOperationService;
import businesslogicservice.userblservice.FindUserService;
import businesslogicservice.userblservice.ModifyInformationService;
import businesslogicservice.vipblservice.VipBlService;
import controller.CustomerController;
import controller.LoginController;
import data.dao.AddressDao;
import po.EvaluatePO;
import po.RoomStatus;
import presentation.customer.CustomerView;
import rmi.RemoteHelper;
import utility.VerifyUtility;
import vo.CreditChangeVO;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.EvaluateVO;
import vo.HotelVO;
import vo.ListVO;
import vo.NormalVipVO;

public class CustomerControllerImpl implements CustomerController {

	private CustomerVO self;

	private CustomerView view;

	private LoginController controller;

	private int credit;
	
	private ArrayList<Integer> reservedListIds;
	
	private ModifyInformationService modifyService;
	
	private GetListsService getListsService;
	
	private ListOperationService listOperationService;
	
	private GetHotelsService getHotelsService;
	
	private HotelOperationService hotelOperationService;
	
	private GenerateListService generateListService;
	
	private VipBlService vipService;

	public CustomerControllerImpl() {
		this.modifyService = new ModifyInformationServiceImpl();
		this.getListsService = new GetListsServiceImpl();
		this.listOperationService = new ListOperationServiceImpl();
		this.hotelOperationService = new HotelOperationServiceImpl();
		this.generateListService = new GenerateListServiceImpl();
		this.vipService = new VipBlServiceImpl();
	}
	
	@Override
	public void setView(CustomerView view) {
		this.view = view;
	}

	@Override
	public void setController(LoginController controller) {
		this.controller = controller;
	}

	@Override
	public void setCustomer(CustomerVO customerVO) {
		this.self = customerVO;
		this.credit = getCreditResult(self.getCredits());
		this.getHotelsService = new GetHotelsSeviceImpl(self);
		updateIds();
		
	}

	@Override
	public CustomerVO getSelf() {
		return self;
	}

	@Override
	public int getCredit() {
		return this.credit;
	}
	
	@Override
	public void showPersonalInformation() {
		view.showPersonalInformation();
	}

	@Override
	public void modifyPersonalInformation() {
		view.modifyPersonalInformation();
	}

	@Override
	public void showCreditRecord() {
		view.showCreditRecord();
	}

	@Override
	public void registerNormalVip() {
		view.registerNormalVip();
	}

	@Override
	public void registerEnterpriseVip() {
		view.registerEnterpriseVip();
	}

	@Override
	public void showPersonalLists() {
		view.showPersonalLists();
	}
	
	@Override
	public void showHotelLists(HotelVO hotelVO) {
		view.showHotelLists(hotelVO);
	}

	@Override
	public void showPersonalHotels() {
		view.showPersonalHotels();
	}

	@Override
	public void showHotelDetailInformation(HotelVO hotelVO) {
		view.showHotelDetailInformation(hotelVO);
	}

	@Override
	public void showGenerateList(HotelVO hotelVO) {
		view.showGenerateList(hotelVO);
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
	public boolean modifyInformation(CustomerVO customerVO) {
		boolean modify = modifyService.modifyInformation(customerVO);
		boolean modifyNormalVip = true;
		boolean modifyEnterpriseVip = true;
		if (customerVO instanceof NormalVipVO) {
			modifyNormalVip = modifyService.modifyInformation((NormalVipVO) customerVO);
		} else if (customerVO instanceof EnterpriseVipVO) {
			modifyEnterpriseVip = modifyService.modifyInformation((EnterpriseVipVO) customerVO);
		}
		if (modify) {
			view.changeName();
		}
		
		return modify && modifyNormalVip && modifyEnterpriseVip;
	}

	@Override
	public ArrayList<CreditChangeVO> getCreditChanges() {
		return self.getCredits();
	}

	@Override
	public void registerNormalVip(String birthday) {
		if (!(self instanceof NormalVipVO) && !(self instanceof EnterpriseVipVO)) {
			self = vipService.registerNormalVip(self, birthday);
			updateCustomer();
			VerifyUtility.showSuccessMessage("注册成功", "恭喜你成为网站普通会员");
		} else {
			VerifyUtility.showWarning("注册失败", "你已是会员");
		}
	}

	@Override
	public void registerEnterpriseVip(String enterpriseName) {
		if (!(self instanceof NormalVipVO) && !(self instanceof EnterpriseVipVO)) {
			self = vipService.registerEnterpriseVip(self, enterpriseName);
			updateCustomer();
			VerifyUtility.showSuccessMessage("注册成功", "恭喜你成为网站企业会员");
		} else {
			VerifyUtility.showWarning("注册失败", "你已是会员");
		}
		
	}

	@Override
	public ArrayList<ListVO> getPersonalLists() {
		ArrayList<ListVO> listVOs = new ArrayList<ListVO>();
		listVOs.addAll(self.getMyLists().values());
		return listVOs;
	}

	@Override
	public ListVO revokeList(ListVO listVO, String timeNow) {
		listVO =  listOperationService.revokeList(listVO, timeNow);
		updateCustomer();
		return listVO;
	}

	@Override
	public ArrayList<HotelVO> getPersonalHotels() {
		ArrayList<HotelVO> hotelVOs = new ArrayList<HotelVO>();
		hotelVOs.addAll(getHotelsService.getReservedHotels().values());
		return hotelVOs;
	}
	
	@Override
	public ArrayList<ListVO> getHotelLists(HotelVO hotelVO) {
		return new ArrayList<ListVO>(getListsService.getPersonalListsInHotel(self, hotelVO).values());
	}

	@Override
	public ArrayList<HotelVO> getSearchResults(String address, String businessDistrict, String hotelName, int roomNum,
			int lowValue, int highValue, int starRating, RoomStatus roomStatus, int lowPrice, int highPrice,
			boolean ifReserved) {

		return new ArrayList<HotelVO>(getHotelsService.searchHotels(address, businessDistrict, hotelName, roomNum, lowValue, highValue, starRating, roomStatus, lowPrice, highPrice, ifReserved).values());  
	}

	@Override
	public int generateList(ListVO listVO, String timeNow) {
		int result = -1;
		if (self instanceof NormalVipVO) {
			result = generateListService.generateList(listVO, (NormalVipVO)self, timeNow);
		} else if (self instanceof EnterpriseVipVO) {
			result = generateListService.generateList(listVO, (EnterpriseVipVO)self, timeNow);
		} else {
			result = generateListService.generateList(listVO, self, timeNow);
		}
		updateCustomer();
		return result;
	}

	private int getCreditResult(ArrayList<CreditChangeVO> creditChanges) {
		String time = "";
		int resultValue = 0;
		for (CreditChangeVO creditChangeVO : creditChanges) {
			if (creditChangeVO.getTime().compareToIgnoreCase(time) > 0) {
				time = creditChangeVO.getTime();
				resultValue = creditChangeVO.getResult();
			}
		}
		return resultValue;
	}

	private void updateCustomer() {
		FindUserService findUserService = new FindUserServiceImpl();
		CustomerVO customerVO = null;
		if (self instanceof NormalVipVO) {
			customerVO = findUserService.getNormalVip(self.getId());			
		} else if (self instanceof EnterpriseVipVO) {
			customerVO = findUserService.getEnterpriseVipVO(self.getId());
		} else {
			customerVO = findUserService.getCustomer(self.getId());
		}
		setCustomer(customerVO);
	}

	@Override
	public boolean evaluateHotel(EvaluateVO evaluateVO, HotelVO hotelVO) {
		return hotelOperationService.evaluateHotel(new EvaluatePO(hotelVO.getId(), evaluateVO.getCustomerName(), evaluateVO.getRankValue(), evaluateVO.getContents()), hotelVO);
	}
	
	@Override
	public HashMap<String, ArrayList<String>> getAddressMap() {
		HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		try {
			map = RemoteHelper.getInstance().getAddressDao().getAddresses();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return map;
	}

	private void updateIds() {
		ArrayList<Integer> hotelVOs = new ArrayList<Integer>();
		hotelVOs.addAll(getHotelsService.getReservedHotels().keySet());
		this.reservedListIds = hotelVOs;
	}
	
	@Override
	public ArrayList<Integer> getReservedHotelId() {
		return reservedListIds;
	}
}
