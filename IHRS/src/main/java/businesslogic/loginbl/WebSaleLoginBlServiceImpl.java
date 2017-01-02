package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogic.userbl.AddUserOperationServiceImpl;
import businesslogicservice.loginblservice.WebSaleLoginBlService;
import businesslogicservice.userblservice.AddUserOperationService;
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

	@Override
	public boolean add(String webSaleName, String password, String phone) {
		boolean add=false;
		int webSaleId=(int)(Math.random()*90000)+10000;
		AddUserOperationService addUserOperationService=new AddUserOperationServiceImpl();
		WebSaleVO webSaleVO=new WebSaleVO(webSaleId, webSaleName, phone);
		PasswordPO passwordPO=new PasswordPO(webSaleId, webSaleName, password, "WebSale");
		try {
			add=passwordDao.addPassword(passwordPO) && addUserOperationService.addWebSale(webSaleVO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return add;
	}

	
}
