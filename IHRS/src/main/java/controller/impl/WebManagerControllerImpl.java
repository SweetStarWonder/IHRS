package controller.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import businesslogic.hotelbl.HotelOperationServiceImpl;
import businesslogic.loginbl.HotelManagerLoginBlServiceImpl;
import businesslogic.loginbl.WebManagerLoginBlServiceImpl;
import businesslogic.loginbl.WebSaleLoginBlServiceImpl;
import businesslogic.userbl.AddUserOperationServiceImpl;
import businesslogic.userbl.FindUserServiceImpl;
import businesslogic.userbl.ModifyInformationServiceImpl;
import businesslogicservice.hotelblservice.HotelOperationService;
import businesslogicservice.loginblservice.HotelManagerLoginBlService;
import businesslogicservice.loginblservice.WebManagerLoginBlService;
import businesslogicservice.loginblservice.WebSaleLoginBlService;
import businesslogicservice.userblservice.AddUserOperationService;
import businesslogicservice.userblservice.FindUserService;
import businesslogicservice.userblservice.ModifyInformationService;
import controller.LoginController;
import controller.WebManagerController;
import data.dao.AddressDao;
import presentation.webManager.WebManagerView;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.NormalVipVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public class WebManagerControllerImpl implements WebManagerController {

	private WebManagerView view;

	private WebManagerVO self;

	private LoginController controller;

	private FindUserService findService;

	private ModifyInformationService modifyService;

	private HotelManagerLoginBlService hotelManagerLoginService;

	private WebSaleLoginBlService webSaleLoginService;

	private WebManagerLoginBlService webManagerLoginService;

	public WebManagerControllerImpl() {
		findService = new FindUserServiceImpl();
		modifyService = new ModifyInformationServiceImpl();
		hotelManagerLoginService = new HotelManagerLoginBlServiceImpl();
		webSaleLoginService = new WebSaleLoginBlServiceImpl();
		webManagerLoginService = new WebManagerLoginBlServiceImpl();
	}

	@Override
	public void setView(WebManagerView view) {
		this.view = view;
	}

	@Override
	public void setWebManager(WebManagerVO self) {
		this.self = self;
	}

	@Override
	public void modifyCustomerDialog(CustomerVO customerVO) {
		view.modifyCustomerDialog(customerVO);
	}

	@Override
	public void modifyHotelManagerDialog(HotelManagerVO hotelManagerVO) {
		view.modifyHotelManagerDialog(hotelManagerVO);
	}

	@Override
	public void modifyWebSaleDialog(WebSaleVO webSaleVO) {
		view.modifyWebSaleDialog(webSaleVO);
	}

	@Override
	public void addWebSaleDialog() {
		view.addWebSaleDialog();
	}

	@Override
	public void addHotelPane() {
		HashMap<String, ArrayList<String>> addressMap = null;
		try {
			addressMap = RemoteHelper.getInstance().getAddressDao().getAddresses();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		view.addHotelPane(addressMap);
	}

	@Override
	public void backView() {
		view.backView();
	}

	@Override
	public CustomerVO getCustomer(int userId) {
		CustomerVO customerVO = null;
		NormalVipVO normalVipVO = findService.getNormalVip(userId);
		if (normalVipVO == null) {
			EnterpriseVipVO enterpriseVipVO = findService.getEnterpriseVipVO(userId);
			if (enterpriseVipVO == null) {
				customerVO = findService.getCustomer(userId);
				return customerVO;
			} else {
				return enterpriseVipVO;
			}
		} else {
			return normalVipVO;
		}
	}

	@Override
	public boolean modifyCustomer(CustomerVO customerVO) {
		boolean modify = modifyService.modifyInformation(customerVO);
		boolean modifyNormalVip = true;
		boolean modifyEnterpriseVip = true;
		if (customerVO instanceof NormalVipVO) {
			modifyNormalVip = modifyService.modifyInformation((NormalVipVO) customerVO);
		} else if (customerVO instanceof EnterpriseVipVO) {
			modifyEnterpriseVip = modifyService.modifyInformation((EnterpriseVipVO) customerVO);
		}
		return modify && modifyNormalVip && modifyEnterpriseVip;
	}

	@Override
	public HotelManagerVO getHotelManager(int userId) {
		return findService.getHotelManagerByUserId(userId);
	}

	@Override
	public boolean modifyHotelManager(HotelManagerVO hotelManagerVO) {
		boolean modify = modifyService.modifyInformation(hotelManagerVO);
		return modify;
	}

	@Override
	public boolean addHotel(HotelVO hotelVO, String userName, String password, String phone) {
		HotelOperationService hotelOperationService = new HotelOperationServiceImpl();
		return hotelManagerLoginService.add(userName, password, phone, hotelVO.getId())
				&& hotelOperationService.addHotel(hotelVO);

	}

	@Override
	public WebSaleVO getWebSale(int userId) {
		return findService.getWebSale(userId);
	}

	@Override
	public boolean addWebSale(String userName, String password, String phone) {
		boolean add = webSaleLoginService.add(userName, password, phone);
		return add;
	}

	@Override
	public boolean modifyWebSale(WebSaleVO webSaleVO) {
		boolean modify = modifyService.modifyInformation(webSaleVO);
		return modify;
	}

	@Override
	public boolean modifyPassword(String oldPassword, String newPassword) {
		boolean modify = webManagerLoginService.modify(self, oldPassword, newPassword);
		return modify;
	}

	@Override
	public void signOut() {
		controller.signOut();
	}

	@Override
	public void setController(LoginController controller) {
		this.controller = controller;
	}

	@Override
	public WebManagerVO getSelf() {
		return self;
	}

}
