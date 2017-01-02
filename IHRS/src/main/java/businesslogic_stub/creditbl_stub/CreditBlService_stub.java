package businesslogic_stub.creditbl_stub;

import businesslogicservice.creditblservice.CreditBlService;
import vo.ListVO;

public class CreditBlService_stub implements CreditBlService{

	@Override
	public boolean deductRevokeCredit(ListVO listVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean deductAbnormalCredit(ListVO listVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean recoverCredit(ListVO listVO) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean rechargeCredit(int rechargeNum) {
		// TODO Auto-generated method stub
		return true;
	}

}
