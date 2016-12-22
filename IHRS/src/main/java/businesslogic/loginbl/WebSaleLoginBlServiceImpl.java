package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogicservice.loginblservice.WebSaleLoginBlService;
import data.dao.PasswordDao;
import data.dao.WebSaleDao;
import po.PasswordPO;
import po.WebSalePO;
import rmi.RemoteHelper;
import vo.WebSaleVO;

public class WebSaleLoginBlServiceImpl implements WebSaleLoginBlService{
	
	private WebSaleDao webSaleDao;
	
	private PasswordDao passwordDao; 

	public WebSaleLoginBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.webSaleDao=remoteHelper.getWebSaleDao();
		this.passwordDao=remoteHelper.getPasswordDao();
	}

	@Override
	public WebSaleVO login(int webSaleId, String webSaleName, String password) {
		PasswordPO passwordPO=null;
		try {
			if(webSaleName!=null){
				passwordPO=passwordDao.getPasswordByName(webSaleName);
			}
			else{
				passwordPO=passwordDao.getPasswordById(webSaleId);
			}
		} catch (RemoteException e) {
				e.printStackTrace();
		}
		if(passwordPO!=null){
			if(passwordPO.getPassword().equals(password)){
				WebSalePO webSalePO=null;
				try {
						webSalePO=webSaleDao.getWebSale(passwordPO.getUserId());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				WebSaleVO webSaleVO=new WebSaleVO(webSalePO);
				return webSaleVO;
				}
				else
					return null;
		}
		else
			return null;
	}

	@Override
	public boolean modify(WebSaleVO webSaleVO, String oldPassword, String newPassword) {
		boolean modify=false;
		PasswordPO passwordPO=null;
		try {
			passwordPO=passwordDao.getPasswordById(webSaleVO.getId());
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
