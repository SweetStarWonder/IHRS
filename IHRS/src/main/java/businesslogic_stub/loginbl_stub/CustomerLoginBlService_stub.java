package businesslogic_stub.loginbl_stub;

import businesslogicservice.loginblservice.CustomerLoginBlService;
import vo.CustomerVO;

public class CustomerLoginBlService_stub implements CustomerLoginBlService{

	@Override
	public CustomerVO login(int customerId, String customerName, String password) {
		// TODO Auto-generated method stub
		return new CustomerVO(customerId, customerName, "phone");
	}

	@Override
	public boolean modify(CustomerVO customerVO, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean register(String customerName, String password, String phone) {
		// TODO Auto-generated method stub
		return true;
	}

}
