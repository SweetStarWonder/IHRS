package businesslogic_stub.vipblservice_stub;

import java.util.ArrayList;

import businesslogicservice.vipblservice.VipBlService;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.NormalVipVO;
import vo.promotionVO.NormalVipPromotionVO;

public class VipBlService_stub implements VipBlService{

	@Override
	public EnterpriseVipVO registerEnterpriseVip(CustomerVO customerVO, String enterpriseName) {
		// TODO Auto-generated method stub
		return new EnterpriseVipVO(customerVO.getId(), customerVO.getUserName(), customerVO.getPhone(), enterpriseName, 0);
	}

	@Override
	public NormalVipVO registerNormalVip(CustomerVO customerVO, String birthday) {
		// TODO Auto-generated method stub
		ArrayList<NormalVipPromotionVO> promotions = new ArrayList<>();
		NormalVipPromotionVO normalVipPromotionVO = new NormalVipPromotionVO(0.5, "discountName", 5, "businessDstrict");
		promotions.add(normalVipPromotionVO);
		return new NormalVipVO(customerVO.getId(), customerVO.getUserName(), customerVO.getPhone(), 0, birthday, 0, promotions);
	}

}
