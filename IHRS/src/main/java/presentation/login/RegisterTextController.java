package presentation.login;


import controller.LoginController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import utility.VerifyUtility;

public class RegisterTextController {
	
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private PasswordField rePasswordField;
	
	@FXML
	private Button registerButton;
	
	private LoginController mainApp;
	
	public RegisterTextController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleRegisterButton() {
		String userName = nameTextField.getText();
		String password = passwordField.getText();
		String passwordAgain = rePasswordField.getText();
		if (userName==null || password==null || passwordAgain==null 
			|| userName.isEmpty() || password.isEmpty() || passwordAgain.isEmpty()) {
			VerifyUtility.showWarning("未填写完整信息", "请填写用户名和密码");
		} else if(!password.equals(passwordAgain)) {
			VerifyUtility.showWarning("填写信息不一致", "请填写两遍相同的密码");
		} else {
			boolean success = mainApp.register(userName, password, "");
			if (success) {
				VerifyUtility.showSuccessMessage("注册成功", "请使用用户名"+userName+"登录");
				nameTextField.clear();
				passwordField.clear();
				rePasswordField.clear();
			} else {
				VerifyUtility.showWarning("注册失败", "用户名已存在");
			}
		}
		
		
	}
	
	public void setMainApp(LoginController mainApp) {
		this.mainApp = mainApp;
	}
}
