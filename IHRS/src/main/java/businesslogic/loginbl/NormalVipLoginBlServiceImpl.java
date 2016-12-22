package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogicservice.loginblservice.NormalVipLoginBlService;
import data.dao.NormalVipDao;
import data.dao.PasswordDao;
import po.NormalVipPO;
import po.PasswordPO;
import rmi.RemoteHelper;
import vo.CustomerVO;
import vo.NormalVipVO;

public class NormalVipLoginBlServiceImpl implements NormalVipLoginBlService{
	
	private NormalVipDao normalVipDao;
	
	private PasswordDao passwordDao;

	public NormalVipLoginBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.normalVipDao=remoteHelper.getNormalVipDao();
		this.passwordDao=remoteHelper.getPasswordDao();
	}

	@Override
	public NormalVipVO login(int normalVipId, String normalVipName, String password) {
		PasswordPO passwordPO=null;
		try {
			if(normalVipName!=null){
				passwordPO=passwordDao.getPasswordByName(normalVipName);
			}
			else{
				passwordPO=passwordDao.getPasswordById(normalVipId);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
	}
	if(passwordPO!=null){
		if(password.equals(passwordPO.getPassword())){
			NormalVipPO normalVipPO=null;
			try {
				normalVipPO=normalVipDao.getNormalVip(passwordPO.getUserId());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			NormalVipVO normalVipVO=new NormalVipVO(normalVipPO);
			return normalVipVO;
		}
		else
			return null;
	}
	else
		return null;
	}

	@Override
	public boolean modify(NormalVipVO normalVipVO, String oldPassword, String newPassword) {
		boolean modify=false;
		PasswordPO passwordPO=null;
		try {
			passwordPO=passwordDao.getPasswordById(normalVipVO.getId());
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
	public NormalVipVO upgrade(CustomerVO customerVO, String birthday) {
		NormalVipPO normalVipPO=new NormalVipPO(customerVO.getId(), customerVO.getUserName(), customerVO.getPhone(), 0, birthday);
		PasswordPO passwordPO=null;
		try {
			passwordPO=passwordDao.getPasswordById(customerVO.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		passwordPO.setUserType("NormalVip");
		try {
			passwordDao.updatePassword(passwordPO);
			normalVipDao.addNormalVip(normalVipPO);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new NormalVipVO(normalVipPO);
	}

}
