package businesslogic.userbl;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.ModifyInformationService;
import data.dao.CustomerDao;
import data.dao.HotelManagerDao;
import data.dao.WebManagerDao;
import data.dao.WebSaleDao;
import po.CustomerPO;
import po.HotelManagerPO;
import po.WebManagerPO;
import po.WebSalePO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.HotelManagerVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public class ModifyInformationServiceImpl implements ModifyInformationService{

	private CustomerDao customerDao;
	
	private HotelManagerDao hotelManagerDao;
	
	private WebManagerDao webManagerDao;
	
	private WebSaleDao webSaleDao;
	
	public ModifyInformationServiceImpl() {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		customerDao = remoteHelper.getCustomerDao();
		hotelManagerDao = remoteHelper.getHotelManagerDao();
		webManagerDao = remoteHelper.getWebManagerDao();
		webSaleDao = remoteHelper.getWebSaleDao();
	}
	
	public boolean modifyInformation(CustomerVO customerVO) {
		boolean modify = false;
		try {
			modify = customerDao.updateCustomer(new CustomerPO(customerVO.getId(), customerVO.getUserName(), customerVO.getPhone()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return modify;
	}

	public boolean modifyInformation(HotelManagerVO hotelManagerVO) {
		boolean modify = false;
		try {
			modify = hotelManagerDao.updateHotelManager(new HotelManagerPO(hotelManagerVO.getId(), hotelManagerVO.getUserName(), hotelManagerVO.getPhone(), hotelManagerVO.getHotelId()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return modify;
	}

	public boolean modifyInformation(WebManagerVO webManagerVO) {
		boolean modify = false;
		try {
			modify = webManagerDao.updateWebManager(new WebManagerPO(webManagerVO.getId(), webManagerVO.getUserName(), webManagerVO.getPhone()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return modify;
	}

	public boolean modifyInformation(WebSaleVO webSaleVO) {
		boolean modify = false;
		try {
			modify = webSaleDao.updateWebSale(new WebSalePO(webSaleVO.getId(), webSaleVO.getUserName(), webSaleVO.getPhone()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return modify;
	}

}

