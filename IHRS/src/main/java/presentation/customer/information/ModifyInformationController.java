package presentation.customer.information;

import org.controlsfx.control.PopOver;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ModifyInformationController {
	
	
	@FXML 
	private TextField usernameTextField;
	
	@FXML 
	private TextField phoneTextField;
	
	@FXML
	private Label creditLabel;
	
	@FXML
	private Button confirmButton;
	
	public ModifyInformationController() {
		
	}
	
	@FXML
	private void initialize() {
		usernameTextField.setText("ËÎÉÙÍþ");
	}
	
	@FXML
	private void handleConfirmButton() {
	}
}
