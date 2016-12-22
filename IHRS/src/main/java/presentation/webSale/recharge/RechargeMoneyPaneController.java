package presentation.webSale.recharge;

import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RechargeMoneyPaneController {

	
	@FXML
	private Label userIdLabel;
	
	@FXML
	private TextField moneyTextField;
	
	@FXML
	private Label creditIncreaseLabel;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	
	public RechargeMoneyPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		creditIncreaseLabel.setText("");
		moneyTextField.textProperty().addListener((observable, oldValue, newValue) -> {
		    calculateCredit(newValue);
		});
	}
	
	private void calculateCredit(String money) {
		if (!money.isEmpty() && isInteger(money)) {
			int num = Integer.valueOf(money);
			if (num > 0) {
				creditIncreaseLabel.setText("+" + num*100 + "");
			} else {
				creditIncreaseLabel.setText("");
			}
		} else {
			creditIncreaseLabel.setText("");
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
