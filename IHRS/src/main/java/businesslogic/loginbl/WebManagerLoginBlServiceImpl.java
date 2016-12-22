package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogicservice.loginblservice.WebManagerLoginBlService;
import data.dao.PasswordDao;
import data.dao.WebManagerDao;
import po.PasswordPO;
import po.WebManagerPO;
import rmi.RemoteHelper;
import vo.WebManagerVO;

public class WebManagerLoginBlServiceImpl implements WebManagerLoginBlService{
	
	private WebManagerDao webManagerDao;
	
	private PasswordDao passwordDao;

	public WebManagerLoginBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.webManagerDao=remoteHelper.getWebManagerDao();
		this.passwordDao=remoteHelper.getPasswordDao();
	}

	@Override
	public WebManagerVO login(int webManagerId, String webManagerName, String password) {
		PasswordPO passwordPO=null;
		try {
			if(webManagerName!=null){
				passwordPO=passwordDao.getPasswordByName(webManagerName);
			}
			else{
				passwordPO=passwordDao.getPasswordById(webManagerId);
			}
		} catch (RemoteException e) {
				e.printStackTrace();
		}
		if(passwordPO!=null){
			if(passwordPO.getPassword().equals(password)){
				WebManagerPO webManagerPO=null;
				try {
						webManagerPO=webManagerDao.getWebManager(passwordPO.getUserId());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				WebManagerVO webManagerVO=new WebManagerVO(webManagerPO);
				return webManagerVO;
				}
				else
					return null;
		}
		else
			return null;
	}
	
	@Override
	public boolean modify(WebManagerVO webManagerVO, String oldPassword, String newPassword) {
		boolean modify=false;
		PasswordPO passwordPO=null;
		try {
			passwordPO=passwordDao.getPasswordById(webManagerVO.getId());
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

}
