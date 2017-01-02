package businesslogic_stub.loginbl_stub;

import java.util.ArrayList;

import businesslogicservice.loginblservice.NormalVipLoginBlService;
import vo.NormalVipVO;
import vo.promotionVO.NormalVipPromotionVO;

public class NormalVipLoginBlService_stub implements NormalVipLoginBlService{

	@Override
	public NormalVipVO login(int normalVipId, String normalVipName, String password) {
		// TODO Auto-generated method stub
		ArrayList<NormalVipPromotionVO> promotions = new ArrayList<>();
		NormalVipPromotionVO promotionVO = new NormalVipPromotionVO(0.5, "discountName", 5, "businessDstrict");
		promotions.add(promotionVO);
		return new NormalVipVO(normalVipId, normalVipName, "phone", 0, "birthday", 5, promotions);
	}

	@Override
	public boolean modify(NormalVipVO normalVipVO, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		return true;
	}

}
