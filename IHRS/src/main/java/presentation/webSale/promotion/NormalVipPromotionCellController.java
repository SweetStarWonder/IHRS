package presentation.webSale.promotion;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import vo.promotionVO.NormalVipPromotionVO;

public class NormalVipPromotionCellController extends PromotionCellController {

	@FXML
	private Label discountNameLabel;

	@FXML
	private Label discountLabel;

	@FXML
	private Label businessDistrictNameLabel;

	@FXML
	private Label rankLabel;

	@FXML
	private Hyperlink deleteHyperLink;

	private NormalVipPromotionVO normalVipPromotionVO;

	private WebPromotionListController upperController;

	public NormalVipPromotionCellController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleDelete() {
		upperController.deletePromotion(normalVipPromotionVO);
	}

	public void setPromotion(NormalVipPromotionVO normalVipPromotionVO) {
		this.normalVipPromotionVO = normalVipPromotionVO;
		discountNameLabel.setText(normalVipPromotionVO.getDiscountName());
		discountLabel.setText(normalVipPromotionVO.getDiscount() + "");
		businessDistrictNameLabel.setText(normalVipPromotionVO.getBusinessDistrict());
		rankLabel.setText(normalVipPromotionVO.getRankValue() + "");
	}

	public void setUpperController(WebPromotionListController upperController) {
		this.upperController = upperController;
	}
}
