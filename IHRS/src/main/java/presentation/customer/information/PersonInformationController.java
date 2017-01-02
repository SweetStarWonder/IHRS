package presentation.customer.information;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vo.CustomerVO;

public class PersonInformationController {

	@FXML
	private Label usernameLabel;

	@FXML
	private Label phoneLabel;

	@FXML
	private Label creditLabel;
	
	@FXML
	private Label idLabel;

	@FXML
	private Button modifyButton;

	private CustomerController testCustomer;
	
	private CustomerVO customerVO;

	public PersonInformationController() {

	}

	@FXML
	private void initialize() {
		
	}

	@FXML
	private void handleModifyButton() {
		testCustomer.modifyPersonalInformation();
	}

	public void setMainApp(CustomerController testCustomer) {
		this.testCustomer = testCustomer;
		this.customerVO = testCustomer.getSelf();
		usernameLabel.setText(customerVO.getUserName());
		phoneLabel.setText(customerVO.getPhone());
		idLabel.setText(customerVO.getId()+"");
		creditLabel.setText(testCustomer.getCredit()+"");
	}
}
