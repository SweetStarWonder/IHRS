package presentation.hotelManager.room;

import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddRoomDialogController {
	
	
	@FXML
	private ComboBox<String> statusComboBOx;
	
	@FXML
	private Label numLabel;
	
	@FXML
	private TextField beginTextField;
	
	@FXML
	private TextField endTextField;
	
	@FXML
	private TextField priceTextField;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	
	public AddRoomDialogController() {
		
	}
	
	@FXML
	private void initialize() {
		numLabel.setText("");
		endTextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    calculateNum(beginTextField.getText(), newValue);
		});
	}
	
	private void calculateNum(String begin, String end) {
		int num = -1;
		if (!begin.isEmpty()&&!end.isEmpty()&&isInteger(begin)&&isInteger(end)) {
			num = Integer.valueOf(end) - Integer.valueOf(begin);
		}
		if (num >= 0) {
			numLabel.setText("¹²" + (num+1) + "¼ä");
		} else {
			numLabel.setText("");
		}
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
	
	private boolean isInteger(String str) {    
	    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");    
	    return pattern.matcher(str).matches();    
	  }  
}
