package presentation.customer.vip;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import utility.VerifyUtility;

public class EnterpriseVipPaneController {

	@FXML
	private TextArea enterpriseNameTextField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage normalVipStage;
	
	private CustomerController controller;

	public EnterpriseVipPaneController() {

	}

	@FXML
	private void initialize() {

	}

	public void setNormalVipStage(Stage normalVipStage) {
		this.normalVipStage = normalVipStage;
	}

	@FXML
	private void handleConfirm() {
		String enterPriseStr = enterpriseNameTextField.getText();
		if (enterPriseStr==null || enterPriseStr.isEmpty()) {
			VerifyUtility.showWarning("信息不完整", "请填写企业名称");
		} else {
			controller.registerEnterpriseVip(enterPriseStr);
			normalVipStage.close();
		}
	}

	@FXML
	private void handleCancel() {
		normalVipStage.close();
	}
	
	public void setController(CustomerController controller) {
		this.controller = controller;
	}

}
