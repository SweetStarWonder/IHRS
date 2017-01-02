package controller;

import presentation.webManager.WebManagerView;
import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.HotelVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public interface WebManagerController {

	public void setView(WebManagerView view);

	// 控制界面
	public void setWebManager(WebManagerVO self);

	public void modifyCustomerDialog(CustomerVO customerVO);

	public void modifyHotelManagerDialog(HotelManagerVO hotelManagerVO);

	public void modifyWebSaleDialog(WebSaleVO webSaleVO);

	public void addWebSaleDialog();

	public void addHotelPane();

	public void backView();

	// 与逻辑层交互
	public WebManagerVO getSelf();

	public CustomerVO getCustomer(int userId);

	public boolean modifyCustomer(CustomerVO customerVO);

	public HotelManagerVO getHotelManager(int userId);

	public boolean modifyHotelManager(HotelManagerVO hotelManagerVO);

	public boolean addHotel(HotelVO hotelVO, String userName, String password, String phone);

	public WebSaleVO getWebSale(int userId);

	public boolean addWebSale(String userName, String passWord, String phone);

	public boolean modifyWebSale(WebSaleVO webSaleVO);

	public boolean modifyPassword(String oldPassword, String newPassword);

	public void signOut();

	public void setController(LoginController controller);

}
