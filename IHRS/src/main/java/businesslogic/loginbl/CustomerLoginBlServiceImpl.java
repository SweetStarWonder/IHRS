package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogicservice.loginblservice.CustomerLoginBlService;
import data.dao.CustomerDao;
import data.dao.PasswordDao;
import po.CustomerPO;
import po.PasswordPO;
import rmi.RemoteHelper;
import vo.CustomerVO;

public class CustomerLoginBlServiceImpl implements CustomerLoginBlService{
	
	private PasswordDao passwordDao;
	
	private CustomerDao customerDao;

	public CustomerLoginBlServiceImpl() {
		RemoteHelper remoteHelper=RemoteHelper.getInstance();
		this.passwordDao=remoteHelper.getPasswordDao();
		this.customerDao=remoteHelper.getCustomerDao();
	}
	
	@Override
	public CustomerVO login(int customerId,String customerName, String password) {
		PasswordPO passwordPO=null;
		try {
			if(customerName!=null){
				passwordPO=passwordDao.getPasswordByName(customerName);
			}
			else{
				passwordPO=passwordDao.getPasswordById(customerId);
			}
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		if(passwordPO!=null){
			if(passwordPO.getPassword().equals(password)){
				CustomerPO customerPO=null;
				try {
					customerPO=customerDao.getCustomer(passwordPO.getUserId());
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				CustomerVO customerVO=new CustomerVO(customerPO);
				return customerVO;
			}
			else
				return null;
		}
		else
			return null;
	}
	
	@Override
	public boolean modify(CustomerVO customerVO,String oldPassword,String newPassword) {
		boolean modify=false;
		PasswordPO passwordPO=null;
		try {
			passwordPO=passwordDao.getPasswordById(customerVO.getId());
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
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
	public boolean register(String customerName, String password, String phone) {
		boolean register=false;
		int customerId=(int)(Math.random()*90000)+10000;
		try {
			boolean add1=passwordDao.addPassword(new PasswordPO(customerId, customerName, password,"Customer"));
			boolean add2=false;
			if(add1){
				add2=customerDao.addCustomer(new CustomerPO(customerId, customerName, phone));
			}
			register=add1&&add2;
			return register;
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}


}
