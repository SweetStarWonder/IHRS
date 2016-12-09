package presentation.customer.information;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.customer.TestCustomer;

public class PersonInformationController {
	
	
	@FXML
	private Label usernameLabel;
	
	@FXML
	private Label phoneLabel;
	
	@FXML
	private Label creditLabel;
	
	@FXML
	private Button modifyButton;
	
	private TestCustomer testCustomer;
	
	public PersonInformationController() {
		
	}
	
	@FXML
	private void initialize() {
		usernameLabel.setText("ËÎÉÙÍþ");
		phoneLabel.setText("¹·±Æ");
		creditLabel.setText("-100");
	}
	
	@FXML
	private void handleModifyButton() {
		testCustomer.modifyPersonalInformation();
	}
	
	public void setMainApp(TestCustomer testCustomer) {
		this.testCustomer = testCustomer;
	}
}
