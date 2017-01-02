package presentation.webSale.promotion;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AddPromotionCellController extends PromotionCellController {

	@FXML
	private Label addLabel;

	public AddPromotionCellController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleClick() {
		upperController.showTypeChoosePane(addLabel);
	}

}
