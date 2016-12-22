package businesslogic.vipbl;

import java.rmi.RemoteException;

import businesslogicservice.vipblservice.VipBlService;
import data.dao.EnterpriseVipDao;
import data.dao.NormalVipDao;
import po.EnterpriseVipPO;
import po.NormalVipPO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.NormalVipVO;

public class VipBlServiceImpl implements VipBlService{

	private EnterpriseVipDao enterpriseVipDao;
	
	private NormalVipDao normalVipDao;
	
	public VipBlServiceImpl() {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		enterpriseVipDao = remoteHelper.getEnterpriseVipDao();
		normalVipDao = remoteHelper.getNormalVipDao();
	}
	
	public EnterpriseVipVO registerEnterpriseVip(CustomerVO customerVO, String enterpriseName) {
		boolean register = false;
		EnterpriseVipPO enterpriseVipPO = new EnterpriseVipPO(customerVO.getId(), customerVO.getUserName(), customerVO.getPhone(), enterpriseName, 0);
		try {
			register = enterpriseVipDao.addEnterpriseVip(enterpriseVipPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			register = false;
		}
		if (register) {
			return new EnterpriseVipVO(enterpriseVipPO);
		} else {
			return null;
		}
	}

	public NormalVipVO registerNormalVip(CustomerVO customerVO, String birthday) {
		boolean register = false;
		NormalVipPO normalVipPO = new NormalVipPO(customerVO.getId(), customerVO.getUserName(), customerVO.getPhone(), 0, birthday);
		try {
			register = normalVipDao.addNormalVip(normalVipPO);
		} catch (RemoteException e) {
			e.printStackTrace();
			register = false;
		}
		if (register) {
			return new NormalVipVO(normalVipPO);
		} else {
			return null;
		}
	}
}
