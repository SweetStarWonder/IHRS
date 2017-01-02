package presentation.webSale.promotion;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import vo.promotionVO.NormalVipPromotionVO;
import vo.promotionVO.PromotionVO;
import vo.promotionVO.WebPromotionVO;

public class PromotionCell extends ListCell<PromotionVO> {

	private WebPromotionListController upperController;

	public PromotionCell(WebPromotionListController upperController) {
		this.upperController = upperController;
	}

	@Override
	public void updateItem(PromotionVO item, boolean empty) {
		super.updateItem(item, empty);
		if (empty) {
			setGraphic(null);
		} else {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane anchorPane = null;

			try {
				if (item == null) {
					loader.setLocation(PromotionCell.class.getResource("AddPromotionCell.fxml"));
					anchorPane = (AnchorPane) loader.load();
					AddPromotionCellController controller = loader.getController();
					controller.setUpperController(upperController);
				} else if (item instanceof WebPromotionVO) {
					loader.setLocation(PromotionCell.class.getResource("SpecialTimePromotionCell.fxml"));
					anchorPane = (AnchorPane) loader.load();
					TimePromotionCellController controller = loader.getController();
					controller.setPromotion((WebPromotionVO) item);
					controller.setUpperController(upperController);
				} else if (item instanceof NormalVipPromotionVO) {
					loader.setLocation(PromotionCell.class.getResource("NormalVipPromotionCell.fxml"));
					anchorPane = (AnchorPane) loader.load();
					NormalVipPromotionCellController controller = loader.getController();
					controller.setPromotion((NormalVipPromotionVO) item);
					controller.setUpperController(upperController);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			setGraphic(anchorPane);
		}
	}
}
