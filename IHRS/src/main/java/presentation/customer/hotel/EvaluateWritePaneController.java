package presentation.customer.hotel;

import org.controlsfx.control.Rating;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import utility.VerifyUtility;
import vo.EvaluateVO;
import vo.HotelVO;

public class EvaluateWritePaneController {

	@FXML
	private AnchorPane rateAnchorPane;

	@FXML
	private TextArea contentTextArea;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;
	
	private Rating rating;
	
	private HotelVO hotelVO;
	
	private CustomerController controller;
	
	public EvaluateWritePaneController() {

	}

	@FXML
	private void initialize() {
		rating = new Rating(5, 0);
		rateAnchorPane.getChildren().add(rating);
	}

	@FXML
	private void handleConfirmButton() {
		int rateNum = (int)rating.getRating() * 2;
		String content = contentTextArea.getText();
		controller.evaluateHotel(new EvaluateVO(controller.getSelf().getUserName(), rateNum, content), hotelVO);
		dialogStage.close();
		VerifyUtility.showSuccessMessage("评价成功", "已评价酒店"+hotelVO.getHotelName());
	}

	@FXML
	private void handleCancelButton() {
		dialogStage.close();
	}

	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
	public void setController(CustomerController controller) {
		this.controller = controller;
	}
	
	public void setHotel(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
	}
	
}
