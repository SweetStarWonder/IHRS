package presentation.customer.hotel;

import org.controlsfx.control.Rating;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
	
	public EvaluateWritePaneController() {
		
	}
	
	@FXML
	private void initialize() {
		Rating rating = new Rating(10, 0);
		rateAnchorPane.getChildren().add(rating);
	}
	
	@FXML
	private void handleConfirmButton() {
		
	}
	
	@FXML
	private void handleCancelButton() {
		dialogStage.close();
	}
	
	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
}
