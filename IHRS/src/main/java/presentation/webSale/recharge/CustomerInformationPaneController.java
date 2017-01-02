package presentation.webSale.recharge;

import controller.WebSaleController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vo.CustomerVO;

public class CustomerInformationPaneController {

	@FXML
	private Label userNameLabel;

	@FXML
	private Label userIdLabel;

	@FXML
	private Label phoneLabel;

	@FXML
	private Button rechargeButton;

	private WebSaleController mainApp;

	private CustomerVO customerVO;

	public CustomerInformationPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleRechargeButton() {
		mainApp.inputMoneyDialog(customerVO);
	}

	public void setMainApp(WebSaleController mainApp) {
		this.mainApp = mainApp;
	}

	public void setCustomer(CustomerVO customerVO) {
		this.customerVO = customerVO;
		userNameLabel.setText(customerVO.getUserName());
		userIdLabel.setText(customerVO.getId() + "");
		phoneLabel.setText(customerVO.getPhone());
	}
}
