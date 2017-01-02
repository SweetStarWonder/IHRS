package presentation.hotelManager.promotion;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import vo.promotionVO.HotelPromotionVO;

public class TimePromotionCellController extends PromotionCellController {

	@FXML
	private Label nameLabel;

	@FXML
	private Label discountLabel;

	@FXML
	private Label beginTimeLabel;

	@FXML
	private Label endTimeLabel;

	private HotelPromotionVO promotion;

	@FXML
	private Hyperlink deleteHyperLink;

	public TimePromotionCellController() {
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
		beginTimeLabel.setText(promotion.getStartTime());
		endTimeLabel.setText(promotion.getEndTime());
	}
}
