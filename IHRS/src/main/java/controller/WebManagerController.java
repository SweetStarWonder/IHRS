package controller;

import presentation.webManager.WebManagerView;
import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public interface WebManagerController{

	public void setView(WebManagerView view);
	
	//控制界面
	public void setWebManager(WebManagerVO self);
	
	public void modifyCustomerDialog();
	
	public void modifyHotelManagerDialog();
	
	public void modifyWebSaleDialog();
	
	public void addWebSaleDialog();
	
	public void addHotelPane();
	
	public void backView();
	
	//与逻辑层交互
	public WebManagerVO getSelf();
	
	public CustomerVO getCustomer(int userId);
	
	public void modifyCustomer(CustomerVO customerVO);
	
	public HotelManagerVO getHotelManager(int userId);
	
	public void modifyHotelManager(HotelManagerVO hotelManagerVO);
	
	public void addHotel();
	
	public WebSaleVO getWebSale(int userId);
	
	public void addWebSale();
	
	public void modifyWebSale(WebSaleVO webSaleVO);
	
	public void modifyPassword();
	
	public void signOut();
	
	public void setController(LoginController controller);
	
}
