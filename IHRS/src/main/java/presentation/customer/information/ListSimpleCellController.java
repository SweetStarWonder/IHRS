package presentation.customer.information;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vo.ListVO;

public class ListSimpleCellController {
	@FXML
	private Label listIdLabel;
	
	@FXML
	private Label hotelNameLabel;
	
	@FXML
	private Label timeLabel;
	
	@FXML
	private Label priceLabel;
	
	private PersonalListViewController upperController;
	
	private ListVO listVO;
	
	public ListSimpleCellController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleClick() {
		upperController.showDetail(priceLabel, listVO);
	}
	
	public void setUpperController(PersonalListViewController upperController) {
		this.upperController = upperController;
	}
}
