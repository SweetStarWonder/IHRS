package businesslogic.userbl;

import java.rmi.RemoteException;

import businesslogicservice.userblservice.AddUserOperationService;
import data.dao.HotelManagerDao;
import data.dao.WebSaleDao;
import po.HotelManagerPO;
import po.WebSalePO;
import rmi.RemoteHelper;
import vo.HotelManagerVO;
import vo.WebSaleVO;

public class AddUserOperationServiceImpl implements AddUserOperationService{

	private WebSaleDao webSaleDao;
	
	private HotelManagerDao hotelManagerDao;
	
	public AddUserOperationServiceImpl() {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		this.webSaleDao = remoteHelper.getWebSaleDao();
		this.hotelManagerDao = remoteHelper.getHotelManagerDao();
	}
	
	public boolean addWebSale(WebSaleVO webSaleVO) {
		boolean add = false;
		try {
			add = webSaleDao.addWebSale(new WebSalePO(webSaleVO.getId(), webSaleVO.getUserName(), webSaleVO.getPhone()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return add;
	}

	
	public boolean addHotelManager(HotelManagerVO hotelManagerVO) {
		boolean add = false;
		try {
			add = hotelManagerDao.addHotelManager(new HotelManagerPO(hotelManagerVO.getId(), hotelManagerVO.getUserName(), hotelManagerVO.getPhone(), hotelManagerVO.getHotelId()));
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return add;
	}

}
