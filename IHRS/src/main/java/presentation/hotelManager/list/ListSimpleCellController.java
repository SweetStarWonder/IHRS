package presentation.hotelManager.list;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import vo.ListVO;

public class ListSimpleCellController {

	
	@FXML
	private Label listIdLabel;
	
	@FXML
	private Label userNameLabel;
	
	@FXML
	private Label timeLabel;
	
	@FXML
	private Label priceLabel;
	
	private ListViewController upperController;
	
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
	
	public void setUpperController(ListViewController upperController) {
		this.upperController = upperController;
	}
}
