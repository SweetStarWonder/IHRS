package businesslogic.vipbl;

import java.rmi.RemoteException;

import businesslogicservice.vipblservice.VipBlService;
import data.dao.EnterpriseVipDao;
import data.dao.NormalVipDao;
import data.dao.PasswordDao;
import po.EnterpriseVipPO;
import po.NormalVipPO;
import po.PasswordPO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.NormalVipVO;

public class VipBlServiceImpl implements VipBlService{

	private EnterpriseVipDao enterpriseVipDao;
	
	private NormalVipDao normalVipDao;
	
	private PasswordDao passwordDao;
	
	public VipBlServiceImpl() {
		RemoteHelper remoteHelper = RemoteHelper.getInstance();
		enterpriseVipDao = remoteHelper.getEnterpriseVipDao();
		normalVipDao = remoteHelper.getNormalVipDao();
		passwordDao = remoteHelper.getPasswordDao();
	}
	
	public EnterpriseVipVO registerEnterpriseVip(CustomerVO customerVO, String enterpriseName) {
		boolean register=false;
		EnterpriseVipPO enterpriseVipPO=new EnterpriseVipPO(customerVO.getId(),customerVO.getUserName(), customerVO.getPhone(), enterpriseName, 0);
		PasswordPO passwordPO=null;
		try {
			passwordPO = passwordDao.getPasswordById(customerVO.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		passwordPO.setUserType("EnterpriseVip");
		try {
			boolean register1=passwordDao.updatePassword(passwordPO);
			boolean register2=enterpriseVipDao.addEnterpriseVip(enterpriseVipPO);
			register = register1 && register2;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(register){
			return new EnterpriseVipVO(enterpriseVipPO);
		}
		else{
			return null;
		}
	}

	public NormalVipVO registerNormalVip(CustomerVO customerVO, String birthday) {
		boolean register = false;
		NormalVipPO normalVipPO=new NormalVipPO(customerVO.getId(), customerVO.getUserName(), customerVO.getPhone(), 0, birthday);
		PasswordPO passwordPO=null;
		try {
			passwordPO=passwordDao.getPasswordById(customerVO.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		passwordPO.setUserType("NormalVip");
		try {
			boolean register1 = passwordDao.updatePassword(passwordPO);
			boolean register2 = normalVipDao.addNormalVip(normalVipPO);
			register = register1 && register2;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(register){
			return new NormalVipVO(normalVipPO);
		}
		else{
			return null;
		}
	}
	
	
}
