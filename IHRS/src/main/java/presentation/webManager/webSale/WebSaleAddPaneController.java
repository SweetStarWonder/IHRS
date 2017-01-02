package presentation.webManager.webSale;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.VerifyUtility;

public class WebSaleAddPaneController {

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField phoneTextField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private WebManagerController controller;

	public WebSaleAddPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleConfirmButton() {
		String name = nameTextField.getText();
		String password = passwordField.getText();
		String phone = phoneTextField.getText();
		if (name == null || phone == null || password == null || name.isEmpty() || phone.isEmpty()
				|| password.isEmpty()) {
			VerifyUtility.showWarning("信息填写不完整", "请完整填写用户信息");
		} else if (phone.length() != 11 || !VerifyUtility.isInteger(phone)) {
			VerifyUtility.showWarning("???", "不要瞎鸡巴填手机号");
		} else {
			boolean add = controller.addWebSale(name, password, phone);
			if (add) {
				VerifyUtility.showSuccessMessage("添加成功", "成功添加用户" + name + "的信息");
				dialogStage.close();
			} else {
				VerifyUtility.showWarning("添加失败", "该用户名已存在");
			}
		}
	}

	@FXML
	private void handleCancelButton() {
		dialogStage.close();
	}

	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setMainApp(WebManagerController mainApp) {
		this.controller = mainApp;
	}

}
