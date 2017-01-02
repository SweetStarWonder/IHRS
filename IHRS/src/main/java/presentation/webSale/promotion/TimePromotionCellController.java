package presentation.webSale.promotion;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import vo.promotionVO.WebPromotionVO;

public class TimePromotionCellController extends PromotionCellController {

	@FXML
	private Label discountNameLabel;

	@FXML
	private Label discountLabel;

	@FXML
	private Label startTimeLabel;

	@FXML
	private Label endTimeLabel;

	@FXML
	private Hyperlink deleteHyperLink;

	private WebPromotionVO webPromotionVO;

	private WebPromotionListController upperController;

	public TimePromotionCellController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleDelete() {
		upperController.deletePromotion(webPromotionVO);
	}

	public void setPromotion(WebPromotionVO webPromotionVO) {
		this.webPromotionVO = webPromotionVO;
		discountNameLabel.setText(webPromotionVO.getDiscountName());
		discountLabel.setText(webPromotionVO.getDiscount() + "");
		startTimeLabel.setText(webPromotionVO.getStartTime());
		endTimeLabel.setText(webPromotionVO.getEndTime());
	}

	public void setUpperController(WebPromotionListController upperController) {
		this.upperController = upperController;
	}

}
