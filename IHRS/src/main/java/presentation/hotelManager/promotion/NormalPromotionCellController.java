package presentation.hotelManager.promotion;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import po.promotionPO.HotelPromotionType;
import vo.promotionVO.HotelPromotionVO;

public class NormalPromotionCellController extends PromotionCellController {

	@FXML
	private Label nameLabel;

	@FXML
	private Label discountLabel;

	@FXML
	private Label typeLabel;

	private HotelPromotionVO promotion;

	@FXML
	private Hyperlink deleteHyperLink;

	public NormalPromotionCellController() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleDelete() {
		upperController.delete(promotion);
	}

	public void setPromotion(HotelPromotionVO promotion) {
		this.promotion = promotion;
		nameLabel.setText(promotion.getDiscountName());
		discountLabel.setText(promotion.getDiscount() + "");
		if (promotion.getHotelPromotionType().equals(HotelPromotionType.BIRTHDAY)) {
			typeLabel.setText("生日特惠折扣");
		} else if (promotion.getHotelPromotionType().equals(HotelPromotionType.THREEMORE)) {
			typeLabel.setText("三间及以上优惠折扣");
		} else if (promotion.getHotelPromotionType().equals(HotelPromotionType.ENTERPRISE)) {
			typeLabel.setText("合作企业会员优惠");
		}
	}

}
