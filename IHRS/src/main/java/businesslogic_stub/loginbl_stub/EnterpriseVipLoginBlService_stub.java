package businesslogic_stub.loginbl_stub;

import businesslogicservice.loginblservice.EnterpriseVipLoginBlService;
import vo.EnterpriseVipVO;

public class EnterpriseVipLoginBlService_stub implements EnterpriseVipLoginBlService{

	@Override
	public EnterpriseVipVO login(int enterpriseVipId, String enterpriseVipName, String password) {
		// TODO Auto-generated method stub
		return new EnterpriseVipVO(enterpriseVipId, enterpriseVipName, "phone", "enterpriseName", 0);
	}

	@Override
	public boolean modify(EnterpriseVipVO enterpriseVipVO, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}

}
