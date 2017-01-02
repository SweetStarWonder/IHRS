package businesslogic.loginbl;


import java.rmi.RemoteException;

import businesslogic.userbl.AddUserOperationServiceImpl;
import businesslogicservice.loginblservice.HotelManagerLoginBlService;
import businesslogicservice.userblservice.AddUserOperationService;
import data.dao.HotelManagerDao;
import data.dao.PasswordDao;
import po.HotelManagerPO;
import po.PasswordPO;
import rmi.RemoteHelper;
import vo.HotelManagerVO;

public class HotelManagerLoginBlServiceImpl implements HotelManagerLoginBlService{
	
	private HotelManagerDao hotelManagerDao;
	
	private PasswordDao passwordDao;

	public HotelManagerLoginBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.hotelManagerDao=remoteHelper.getHotelManagerDao();
		this.passwordDao=remoteHelper.getPasswordDao();
	}

	@Override
	public HotelManagerVO login(int hotelManagerId, String hotelManagerName, String password) {
		PasswordPO passwordPO=null;
			try {
				if(hotelManagerName!=null){
					passwordPO=passwordDao.getPasswordByName(hotelManagerName);
				}
				else{
					passwordPO=passwordDao.getPasswordById(hotelManagerId);
				}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			if(passwordPO!=null){
				if(passwordPO.getPassword().equals(password)){
					HotelManagerPO hotelManagerPO=null;
					try {
						hotelManagerPO=hotelManagerDao.getHotelManagerByUser(passwordPO.getUserId());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					HotelManagerVO hotelManagerVO=new HotelManagerVO(hotelManagerPO);
					return hotelManagerVO;
				}
				else
					return null;
			}
			else
				return null;
	}

	@Override
	public boolean modify(HotelManagerVO hotelManagerVO, String oldPassword, String newPassword) {
		boolean modify=false;
		PasswordPO passwordPO=null;
		try {
			passwordPO=passwordDao.getPasswordById(hotelManagerVO.getId());
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
	public boolean add(String hotelManagerName, String password, String phone,int hotelId) {
		boolean add=false;
		int hotelManagerId=(int)(Math.random()*90000)+10000;
		AddUserOperationService addUserOperationService=new AddUserOperationServiceImpl();
		HotelManagerVO hotelManagerVO=new HotelManagerVO(hotelManagerId, hotelManagerName, phone, hotelId);
		PasswordPO passwordPO=new PasswordPO(hotelManagerId, hotelManagerName, password, "HotelManager");
		try {
			add=passwordDao.addPassword(passwordPO) && addUserOperationService.addHotelManager(hotelManagerVO);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return add;
	}


}
