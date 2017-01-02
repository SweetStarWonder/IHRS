package presentation.customer.vip;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;
import utility.VerifyUtility;

public class NormalVipPaneController {

	@FXML
	private DatePicker birthdayDatePicker;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage normalVipStage;
	
	private CustomerController controller;

	public NormalVipPaneController() {

	}

	@FXML
	private void initialize() {

	}

	public void setNormalVipStage(Stage normalVipStage) {
		this.normalVipStage = normalVipStage;
	}

	@FXML
	private void handleConfirm() {
		String birthdayStr = birthdayDatePicker.getValue().toString();
		if (birthdayStr==null || birthdayStr.isEmpty()) {
			VerifyUtility.showWarning("信息不完整", "请填写生日信息");
		} else {
			controller.registerNormalVip(birthdayStr.substring(0, 4) + "/" + birthdayStr.substring(5, 7) + "/" + birthdayStr.substring(8));
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
