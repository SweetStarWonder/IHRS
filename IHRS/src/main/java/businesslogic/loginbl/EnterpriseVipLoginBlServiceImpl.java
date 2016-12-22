package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogicservice.loginblservice.EnterpriseVipLoginBlService;
import data.dao.EnterpriseVipDao;
import data.dao.PasswordDao;
import po.EnterpriseVipPO;
import po.PasswordPO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.EnterpriseVipVO;

public class EnterpriseVipLoginBlServiceImpl implements EnterpriseVipLoginBlService{
	
	private EnterpriseVipDao enterpriseVipDao;
	
	private PasswordDao passwordDao;
	
	public EnterpriseVipLoginBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.enterpriseVipDao=remoteHelper.getEnterpriseVipDao();
		this.passwordDao=remoteHelper.getPasswordDao();
	}
	
	@Override
	public EnterpriseVipVO login(int enterpriseVipId, String enterpriseVipName, String password) {
		PasswordPO passwordPO=null;
			try {
				if(enterpriseVipName!=null){
					passwordPO=passwordDao.getPasswordByName(enterpriseVipName);
				}
				else{
					passwordPO=passwordDao.getPasswordById(enterpriseVipId);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
		}
		if(passwordPO!=null){
			if(password.equals(passwordPO.getPassword())){
				EnterpriseVipPO enterpriseVipPO=null;
				try {
					enterpriseVipPO=enterpriseVipDao.getEnterpriseVip(passwordPO.getUserId());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				EnterpriseVipVO enterpriseVipVO=new EnterpriseVipVO(enterpriseVipPO);
				return enterpriseVipVO;
			}
			else
				return null;
		}
		else
			return null;
	}
	
	@Override
	public boolean modify(EnterpriseVipVO enterpriseVipVO, String oldPassword, String newPassword) {
		boolean modify=false;
		PasswordPO passwordPO=null;
		try {
			passwordPO=passwordDao.getPasswordById(enterpriseVipVO.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(oldPassword.equals(passwordPO.getPassword())){
			passwordPO.setPassword(newPassword);
			try {
				modify=passwordDao.updatePassword(passwordPO);
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
	public EnterpriseVipVO upgrade(CustomerVO customerVO, String enterpriseName) {
		EnterpriseVipPO enterpriseVipPO=new EnterpriseVipPO(customerVO.getId(),customerVO.getUserName(), customerVO.getPhone(), enterpriseName, 0);
		PasswordPO passwordPO=null;
		try {
			passwordPO = passwordDao.getPasswordById(customerVO.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		passwordPO.setUserType("EnterpriseVip");
		try {
			passwordDao.updatePassword(passwordPO);
			enterpriseVipDao.addEnterpriseVip(enterpriseVipPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new EnterpriseVipVO(enterpriseVipPO);
	}

}
