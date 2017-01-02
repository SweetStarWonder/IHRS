package presentation.hotelManager.promotion;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import po.promotionPO.HotelPromotionType;
import vo.promotionVO.HotelPromotionVO;

public class PromotionCell extends ListCell<HotelPromotionVO> {

	private HotelPromotionListController upperController;

	public PromotionCell(HotelPromotionListController upperController) {
		this.upperController = upperController;
	}

	@Override
	public void updateItem(HotelPromotionVO item, boolean empty) {
		super.updateItem(item, empty);
		if (empty || item == null) {
			setGraphic(null);
		} else {
			FXMLLoader loader = new FXMLLoader();
			AnchorPane anchorPane = null;

			try {
				if (item.getHotelPromotionType() == null) {
					loader.setLocation(PromotionCell.class.getResource("AddPromotionCell.fxml"));
					anchorPane = (AnchorPane) loader.load();
				} else if (item.getHotelPromotionType().equals(HotelPromotionType.DOUBLE11)) {
					loader.setLocation(PromotionCell.class.getResource("SpecialTimePromotionCell.fxml"));
					anchorPane = (AnchorPane) loader.load();
					TimePromotionCellController controller = loader.getController();
					controller.setPromotion(item);
				} else {
					loader.setLocation(PromotionCell.class.getResource("NormalPromotionCell.fxml"));
					anchorPane = (AnchorPane) loader.load();
					NormalPromotionCellController controller = loader.getController();
					controller.setPromotion(item);
				}

				PromotionCellController controller = loader.getController();
				controller.setUpperController(upperController);
			} catch (IOException e) {
				e.printStackTrace();
			}
			setGraphic(anchorPane);
		}
	}
}
