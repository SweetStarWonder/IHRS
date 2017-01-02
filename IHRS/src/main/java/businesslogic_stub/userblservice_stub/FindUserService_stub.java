package businesslogic_stub.userblservice_stub;

import java.util.ArrayList;

import businesslogicservice.userblservice.FindUserService;
import vo.CustomerVO;
import vo.EnterpriseVipVO;
import vo.HotelManagerVO;
import vo.NormalVipVO;
import vo.WebSaleVO;
import vo.promotionVO.NormalVipPromotionVO;

public class FindUserService_stub implements FindUserService{

	@Override
	public CustomerVO getCustomer(int customerId) {
		// TODO Auto-generated method stub
		return new CustomerVO(customerId, "customerName", "phone");
	}

	@Override
	public CustomerVO getCustomer(String customerName) {
		// TODO Auto-generated method stub
		return new CustomerVO(00001, customerName, "phone");
	}

	@Override
	public HotelManagerVO getHotelManagerByUserId(int hotelManagerId) {
		// TODO Auto-generated method stub
		return new HotelManagerVO(hotelManagerId, "hotelManagerName", "phone", 2222);
	}

	@Override
	public HotelManagerVO getHotelManagerByHotelId(int hotelId) {
		// TODO Auto-generated method stub
		return new HotelManagerVO(00003, "hotelManagerName", "phone", hotelId);
	}

	@Override
	public WebSaleVO getWebSale(int webSaleId) {
		// TODO Auto-generated method stub
		return new WebSaleVO(webSaleId, "webSaleName", "phone");
	}

	@Override
	public NormalVipVO getNormalVip(int normalVipId) {
		// TODO Auto-generated method stub
		ArrayList<NormalVipPromotionVO> promotions = new ArrayList<>();
		NormalVipPromotionVO normalVipPromotionVO = new NormalVipPromotionVO(0.5, "discountName", 5, "businessDstrict");
		promotions.add(normalVipPromotionVO);
		return new NormalVipVO(normalVipId, "normalVipName", "phone", 0, "birthday", 5, promotions);
	}

	@Override
	public EnterpriseVipVO getEnterpriseVipVO(int enterpriseVipId) {
		// TODO Auto-generated method stub
		return new EnterpriseVipVO(enterpriseVipId, "enterpriseName", "phone", "enterpriseName", 0);
	}

}
