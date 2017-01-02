package businesslogic.userbl;

import java.rmi.RemoteException;
import businesslogic.loginbl.EveryoneLoginBlServiceImpl;
import businesslogicservice.loginblservice.EveryoneLoginBlService;
import businesslogicservice.userblservice.ModifyInformationService;
import data.dao.CustomerDao;
import data.dao.EnterpriseVipDao;
import data.dao.HotelManagerDao;
import data.dao.NormalVipDao;
import data.dao.WebManagerDao;
import data.dao.WebSaleDao;
import po.CustomerPO;
import po.EnterpriseVipPO;
import po.HotelManagerPO;
import po.NormalVipPO;
import po.WebManagerPO;
import po.WebSalePO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.HotelManagerVO;
import vo.NormalVipVO;
import vo.WebManagerVO;
import vo.WebSaleVO;

public class ModifyInformationServiceImpl implements ModifyInformationService {

	private CustomerDao customerDao;

	private HotelManagerDao hotelManagerDao;

	private WebManagerDao webManagerDao;

	private WebSaleDao webSaleDao;

	private NormalVipDao normalVipDao;

	private EnterpriseVipDao enterpriseVipDao;
	
	private EveryoneLoginBlService everyoneLoginBlService;

	public ModifyInformationServiceImpl() {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		customerDao = remoteHelper.getCustomerDao();
		hotelManagerDao = remoteHelper.getHotelManagerDao();
		webManagerDao = remoteHelper.getWebManagerDao();
		webSaleDao = remoteHelper.getWebSaleDao();
		normalVipDao = remoteHelper.getNormalVipDao();
		enterpriseVipDao = remoteHelper.getEnterpriseVipDao();
	}

	public boolean modifyInformation(CustomerVO customerVO) {
		everyoneLoginBlService=new EveryoneLoginBlServiceImpl();
		if(everyoneLoginBlService.modify(customerVO.getId(), customerVO.getUserName())){
			boolean modify = false;
			try {
				modify = customerDao.updateCustomer(
						new CustomerPO(customerVO.getId(), customerVO.getUserName(), customerVO.getPhone()));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
			return modify;
		}
		else{
			return false;
		}
	}

	public boolean modifyInformation(HotelManagerVO hotelManagerVO) {
		everyoneLoginBlService=new EveryoneLoginBlServiceImpl();
		if(everyoneLoginBlService.modify(hotelManagerVO.getId(), hotelManagerVO.getUserName())){
			boolean modify = false;
			try {
				modify = hotelManagerDao.updateHotelManager(new HotelManagerPO(hotelManagerVO.getId(),
						hotelManagerVO.getUserName(), hotelManagerVO.getPhone(), hotelManagerVO.getHotelId()));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
			return modify;
		}
		else{
			return false;
		}
	}

	public boolean modifyInformation(WebManagerVO webManagerVO) {
		everyoneLoginBlService=new EveryoneLoginBlServiceImpl();
		if(everyoneLoginBlService.modify(webManagerVO.getId(), webManagerVO.getUserName())){
			boolean modify = false;
			try {
				modify = webManagerDao.updateWebManager(
						new WebManagerPO(webManagerVO.getId(), webManagerVO.getUserName(), webManagerVO.getPhone()));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
			return modify;
		}
		else{
			return false;
		}
	}

	public boolean modifyInformation(WebSaleVO webSaleVO) {
		everyoneLoginBlService=new EveryoneLoginBlServiceImpl();
		if(everyoneLoginBlService.modify(webSaleVO.getId(), webSaleVO.getUserName())){
			boolean modify = false;
			try {
				modify = webSaleDao
						.updateWebSale(new WebSalePO(webSaleVO.getId(), webSaleVO.getUserName(), webSaleVO.getPhone()));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
			return modify;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean modifyInformation(NormalVipVO normalVipVO) {
		everyoneLoginBlService=new EveryoneLoginBlServiceImpl();
		if(everyoneLoginBlService.modify(normalVipVO.getId(), normalVipVO.getUserName())){
			boolean modify = false;
			try {
				modify = normalVipDao.updateNormalVip(new NormalVipPO(normalVipVO.getId(), normalVipVO.getUserName(),
						normalVipVO.getPhone(), normalVipVO.getBonus(), normalVipVO.getBirthday()));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
			return modify;
		}
		else{
			return false;
		}
	}

	@Override
	public boolean modifyInformation(EnterpriseVipVO enterpriseVipVO) {
		everyoneLoginBlService=new EveryoneLoginBlServiceImpl();
		if(everyoneLoginBlService.modify(enterpriseVipVO.getId(), enterpriseVipVO.getUserName())){
			boolean modify = false;
			try {
				modify = enterpriseVipDao.updateEnterpriseVip(new EnterpriseVipPO(enterpriseVipVO.getId(),
						enterpriseVipVO.getUserName(), enterpriseVipVO.getPhone(), enterpriseVipVO.getEnterpriseName(),
						enterpriseVipVO.getBonus()));
			} catch (RemoteException e) {
				e.printStackTrace();
				return false;
			}
			return modify;
		}
		else{
			return false;
		}
	}
		
	
}
