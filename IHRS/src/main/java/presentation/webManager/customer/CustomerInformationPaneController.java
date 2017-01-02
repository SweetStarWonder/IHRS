package presentation.webManager.customer;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import utility.VerifyUtility;
import vo.CustomerVO;

public class CustomerInformationPaneController {

	@FXML
	private Label idLabel;

	@FXML
	private Label nameLabel;

	@FXML
	private Label phoneLabel;

	@FXML
	private Button modifyButton;

	private WebManagerController mainApp;

	private CustomerVO customerVO;

	public CustomerInformationPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleModifyButton() {
		if (idLabel.getText() == null || idLabel.getText().isEmpty()) {
			VerifyUtility.showWarning("没有选中的用户", "请先搜索用户");
		} else {
			mainApp.modifyCustomerDialog(customerVO);
			idLabel.setText("");
			nameLabel.setText("");
			phoneLabel.setText("");
		}
	}

	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
	}

	public void setCustomer(CustomerVO customerVO) {
		this.customerVO = customerVO;
		idLabel.setText(customerVO.getId() + "");
		nameLabel.setText(customerVO.getUserName());
		phoneLabel.setText(customerVO.getPhone());
	}
}
