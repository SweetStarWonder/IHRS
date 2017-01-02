package businesslogic_stub.listbl_stub;

import businesslogicservice.listblservice.GenerateListService;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.ListVO;
import vo.NormalVipVO;

public class GenerateListService_stub implements GenerateListService{

	@Override
	public int generateList(ListVO listVO, CustomerVO customerVO, String timeNow) {
		// TODO Auto-generated method stub
		return listVO.getPrice();
	}

	@Override
	public int generateList(ListVO listVO, NormalVipVO normalVipVO, String timeNow) {
		// TODO Auto-generated method stub
		return listVO.getPrice();
	}

	@Override
	public int generateList(ListVO listVO, EnterpriseVipVO enterpriseVipVO, String timeNow) {
		// TODO Auto-generated method stub
		return listVO.getPrice();
	}

}
