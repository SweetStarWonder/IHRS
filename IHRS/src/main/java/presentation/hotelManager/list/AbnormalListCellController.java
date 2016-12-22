package presentation.hotelManager.list;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class AbnormalListCellController {

	
	@FXML
	private Label listIdLabel;
	
	@FXML
	private Label hotelNameLabel;
	
	@FXML
	private Label beginTimeLabel;
	
	@FXML
	private Label endTimeLabel;
	
	@FXML
	private Label lastExcecutedTimeLabel;
	
	@FXML
	private Label singleNumLabel;
	
	@FXML
	private Label doubleNumLabel;
	
	@FXML
	private Label tripleNumLabel;
	
	@FXML
	private Label peopleNumLabel;
	
	@FXML
	private Label priceLabel;
	
	@FXML
	private Label haveChildLabel;
	
	@FXML
	private Button revokeButton;
	
	private ListViewController upperController;
	
	public AbnormalListCellController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleRevokeButton() {
		
	}
	
	public void setUpperController(ListViewController upperController) {
		this.upperController = upperController;
	}
}
