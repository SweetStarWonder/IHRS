package presentation.customer.hotel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import vo.EvaluateVO;

public class HotelEvaluateController {
	
	@FXML
	private Button writeEvaluateButton;
	
	@FXML
	private ListView<EvaluateVO> evaluateListView;
	
	ObservableList<EvaluateVO> evaluates;
	
	public HotelEvaluateController() {
		
	}
	
	@FXML
	private void initialize() {
		evaluates = FXCollections.observableArrayList();
		showEvaluates();
	}
	
	private void showEvaluates() {
		evaluateListView.setItems(evaluates);
		evaluateListView.setCellFactory((ListView<EvaluateVO> e) -> new EvaluateListCell());
		for (int i = 0; i < 50; i++) {
			evaluates.add(null);
		}
	}
}
