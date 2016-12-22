package controller.impl;

import controller.LoginController;
import controller.WebManagerController;
import presentation.webManager.WebManagerView;
import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public class WebManagerControllerImpl implements WebManagerController {

	private WebManagerView view;
	
	private WebManagerVO self;
	
	private LoginController controller;
	
	@Override
	public void setView(WebManagerView view) {
		this.view = view;
	}

	@Override
	public void setWebManager(WebManagerVO self) {
		this.self = self;
	}
	
	@Override
	public void modifyCustomerDialog() {
		view.modifyCustomerDialog();
	}

	@Override
	public void modifyHotelManagerDialog() {
		view.modifyHotelManagerDialog();
	}

	@Override
	public void modifyWebSaleDialog() {
		view.modifyWebSaleDialog();
	}

	@Override
	public void addWebSaleDialog() {
		view.addWebSaleDialog();
	}

	@Override
	public void addHotelPane() {
		view.addHotelPane();
	}

	@Override
	public void backView() {
		view.backView();
	}

	@Override
	public CustomerVO getCustomer(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyCustomer(CustomerVO customerVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HotelManagerVO getHotelManager(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyHotelManager(HotelManagerVO hotelManagerVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHotel() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WebSaleVO getWebSale(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addWebSale() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyWebSale(WebSaleVO webSaleVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyPassword() {
		// TODO Auto-generated method stub
		
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
