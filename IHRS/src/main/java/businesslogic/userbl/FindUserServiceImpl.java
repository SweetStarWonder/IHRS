package businesslogic.userbl;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.FindUserService;
import data.dao.CustomerDao;
import data.dao.EnterpriseVipDao;
import data.dao.HotelManagerDao;
import data.dao.NormalVipDao;
import data.dao.WebSaleDao;
import po.CustomerPO;
import po.EnterpriseVipPO;
import po.HotelManagerPO;
import po.NormalVipPO;
import po.WebSalePO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.HotelManagerVO;
import vo.NormalVipVO;
import vo.WebSaleVO;

public class FindUserServiceImpl implements FindUserService{

	private CustomerDao customerDao;
	
	private HotelManagerDao hotelManagerDao;
	
	private WebSaleDao webSaleDao;
	
	private NormalVipDao normalVipDao;
	
	private EnterpriseVipDao enterpriseVipDao;
	
	public FindUserServiceImpl() {
		this.customerDao = RemoteHelper.getInstance().getCustomerDao();
		this.hotelManagerDao = RemoteHelper.getInstance().getHotelManagerDao();
		this.webSaleDao = RemoteHelper.getInstance().getWebSaleDao();
		this.normalVipDao = RemoteHelper.getInstance().getNormalVipDao();
		this.enterpriseVipDao = RemoteHelper.getInstance().getEnterpriseVipDao();
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
		if (customerPO == null) {
			return null;
		} else {
			return new CustomerVO(customerPO);
		}
	}

	public HotelManagerVO getHotelManagerByUserId(int hotelManagerId) {
		HotelManagerPO hotelManagerPO = null;
		try {
			hotelManagerPO = hotelManagerDao.getHotelManagerByUser(hotelManagerId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (hotelManagerPO == null) {
			return null;
		} else {
			return new HotelManagerVO(hotelManagerPO);
		}
	}

	public HotelManagerVO getHotelManagerByHotelId(int hotelId) {
		HotelManagerPO hotelManagerPO = null;
		try {
			hotelManagerPO = hotelManagerDao.getHotelManagerByHotel(hotelId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (hotelManagerPO == null) {
			return null;
		} else {
			return new HotelManagerVO(hotelManagerPO);
		}
	}

	public WebSaleVO getWebSale(int webSaleId) {
		WebSalePO webSalePO = null;
		try {
			webSalePO = webSaleDao.getWebSale(webSaleId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (webSalePO == null) {
			return null;
		} else {
			return new WebSaleVO(webSalePO);
		}
	}

	@Override
	public NormalVipVO getNormalVip(int normalVipId) {
		NormalVipPO normalVipPO = null;
		try {
			normalVipPO = normalVipDao.getNormalVip(normalVipId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(normalVipPO == null){
			return null;
		}
		else{
			return new NormalVipVO(normalVipPO);
		}
	}

	@Override
	public EnterpriseVipVO getEnterpriseVipVO(int enterpriseVipId) {
		EnterpriseVipPO enterpriseVipPO = null;
		try {
			enterpriseVipPO = enterpriseVipDao.getEnterpriseVip(enterpriseVipId);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(enterpriseVipPO == null){
			return null;
		}
		else{
			return new EnterpriseVipVO(enterpriseVipPO);
		}
	}

	
}

