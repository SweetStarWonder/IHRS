package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogicservice.loginblservice.CustomerLoginBlService;
import businesslogicservice.loginblservice.EnterpriseVipLoginBlService;
import businesslogicservice.loginblservice.EveryoneLoginBlService;
import businesslogicservice.loginblservice.HotelManagerLoginBlService;
import businesslogicservice.loginblservice.NormalVipLoginBlService;
import businesslogicservice.loginblservice.WebManagerLoginBlService;
import businesslogicservice.loginblservice.WebSaleLoginBlService;
import data.dao.PasswordDao;
import po.PasswordPO;
import rmi.RemoteHelper;
import vo.UserVO;

public class EveryoneLoginBlServiceImpl implements EveryoneLoginBlService{
	
	private CustomerLoginBlService CustomerLoginBlServiceImpl;
	
	private EnterpriseVipLoginBlService EnterpriseVipLoginBlServiceImpl;
	
	private HotelManagerLoginBlService HotelManagerLoginBlServiceImpl;
	
	private NormalVipLoginBlService normalVipLoginBlServiceImpl;
	
	private WebManagerLoginBlService WebManagerLoginBlServiceImpl;
	
	private WebSaleLoginBlService WebSaleLoginBlServiceImpl;
	
	private PasswordDao passwordDao;
	
	public EveryoneLoginBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.passwordDao=remoteHelper.getPasswordDao();
	}
	
	@Override
	public UserVO login(int userId, String userName, String password) {
		PasswordPO passwordPO=null;
		try {
			//登录时只允许输入ID或name的一种
			if(userName!=null){
				passwordPO=passwordDao.getPasswordByName(userName);
			}
			else{
				passwordPO=passwordDao.getPasswordById(userId);
			}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		if(passwordPO!=null){
			String userType=passwordPO.getUserType();
			UserVO userVO=null;
			switch (userType) {
			case "Customer":
				this.CustomerLoginBlServiceImpl = new CustomerLoginBlServiceImpl();
				userVO=CustomerLoginBlServiceImpl.login(userId, userName, password);
				break;
			case "EnterpriseVip":
				this.EnterpriseVipLoginBlServiceImpl = new EnterpriseVipLoginBlServiceImpl();
				userVO=EnterpriseVipLoginBlServiceImpl.login(userId, userName, password);
				break;
			case "HotelManager":
				this.HotelManagerLoginBlServiceImpl = new HotelManagerLoginBlServiceImpl();
				userVO=HotelManagerLoginBlServiceImpl.login(userId, userName, password);
				break;
			case "NormalVip":
				this.normalVipLoginBlServiceImpl = new NormalVipLoginBlServiceImpl();
				userVO=normalVipLoginBlServiceImpl.login(userId, userName, password);
				break;
			case "WebManager":
				this.WebManagerLoginBlServiceImpl = new WebManagerLoginBlServiceImpl();
				userVO=WebManagerLoginBlServiceImpl.login(userId, userName, password);
				break;
			case "WebSale":
				this.WebSaleLoginBlServiceImpl = new WebSaleLoginBlServiceImpl();
				userVO=WebSaleLoginBlServiceImpl.login(userId, userName, password);
				break;
			default:
				break;
			}
			return userVO;
		}
		else
			return null;
	}

	@Override
	public boolean modify(int userId, String newUserName) {
		boolean modify=false;
		try {
			modify=passwordDao.updateName(userId, newUserName);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return modify;
	}

}
