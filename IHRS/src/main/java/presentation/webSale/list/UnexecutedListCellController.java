package presentation.webSale.list;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class UnexecutedListCellController {
	
	
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
	
	
	private ListViewController upperController;
	
	public UnexecutedListCellController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	
	public void setUpperController(ListViewController upperController) {
		this.upperController = upperController;
	}
}
