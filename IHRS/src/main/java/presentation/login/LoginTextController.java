package presentation.login;

import controller.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utility.VerifyUtility;

public class LoginTextController {

	@FXML
	private TextField nameTextField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button loginButton;

	private LoginController mainApp;

	public LoginTextController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleLoginButton() {
		String userName = nameTextField.getText();
		String password = passwordField.getText();
		if (userName == null || password == null || userName.isEmpty() || password.isEmpty()) {
			VerifyUtility.showWarning("信息不完整", "请完整填写用户名和密码");
		} else {
			mainApp.login(0, userName, password);
		}
	}

	public void setMainApp(LoginController mainApp) {
		this.mainApp = mainApp;
	}
}
