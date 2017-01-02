package presentation.customer.hotel;

import controller.CustomerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import vo.EvaluateVO;
import vo.HotelVO;

public class HotelEvaluateController {

	@FXML
	private Button writeEvaluateButton;

	@FXML
	private ListView<EvaluateVO> evaluateListView;

	ObservableList<EvaluateVO> evaluates;

	private HotelDetailInformationController hotelDetailInformationController;
	
	private HotelVO hotelVO;
	
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
	}

	@FXML
	private void handleWriteEvaluateButton() {
		hotelDetailInformationController.writeEvaluate();
	}

	public void setUpperController(HotelDetailInformationController controller) {
		this.hotelDetailInformationController = controller;
	}
	
	public void setHotel(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
		evaluates.addAll(hotelVO.getEvaluates());
	}
}
