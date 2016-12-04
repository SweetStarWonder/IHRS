package businesslogic.userbl;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.FindUserService;
import data.dao.CustomerDao;
import data.dao.HotelManagerDao;
import data.dao.WebSaleDao;
import po.CustomerPO;
import po.HotelManagerPO;
import po.WebSalePO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.WebSaleVO;

public class FindUserServiceImpl implements FindUserService{

	private CustomerDao customerDao;
	
	private HotelManagerDao hotelManagerDao;
	
	private WebSaleDao webSaleDao;
	
	public FindUserServiceImpl() {
		this.customerDao = RemoteHelper.getInstance().getCustomerDao();
		this.hotelManagerDao = RemoteHelper.getInstance().getHotelManagerDao();
		this.webSaleDao = RemoteHelper.getInstance().getWebSaleDao();
	}
	
	public CustomerVO getCustomer(int customerId) {
		CustomerPO customerPO = null;
		try {
			customerPO = customerDao.getCustomer(customerId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (customerPO == null) {
			return null;
		} else {
			return new CustomerVO(customerPO);
		}
	}

	public CustomerVO getCustomer(String customerName) {
		CustomerPO customerPO = null;
		try {
			customerPO = customerDao.getCustomer(customerName);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
			return new CustomerVO(customerPO);
	}

	public HotelManagerVO getHotelManagerByUserId(int hotelManagerId) {
		HotelManagerPO hotelManagerPO = null;
		try {
			hotelManagerPO = hotelManagerDao.getHotelManagerByUser(hotelManagerId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new HotelManagerVO(hotelManagerPO);
	}

	public HotelManagerVO getHotelManagerByHotelId(int hotelId) {
		HotelManagerPO hotelManagerPO = null;
		try {
			hotelManagerPO = hotelManagerDao.getHotelManagerByHotel(hotelId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new HotelManagerVO(hotelManagerPO);
	}

	public WebSaleVO getWebSale(int webSaleId) {
		WebSalePO webSalePO = null;
		try {
			webSalePO = webSaleDao.getWebSale(webSaleId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new WebSaleVO(webSalePO);
	}

}

