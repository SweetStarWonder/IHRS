package presentation.login;

import java.io.IOException;

import com.jfoenix.controls.JFXTabPane;

import controller.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

public class LoginPaneController {

	
	@FXML
	private JFXTabPane tabPane;
	
	private Tab loginTab;
	
	private Tab registerTab;
	
	private LoginController mainApp;
	
	public LoginPaneController() {
		
	}
	
	private void initialize() {
		
		loginTab = new Tab("登录");
		
		registerTab = new Tab("注册");
		
		FXMLLoader loaderLogin = new FXMLLoader();
		loaderLogin.setLocation(LoginPaneController.class.getResource("LoginTexts.fxml"));
		AnchorPane loginPane = null;
		try {
			loginPane = (AnchorPane) loaderLogin.load();
			LoginTextController controller = loaderLogin.getController();
			controller.setMainApp(mainApp);
			System.out.println("poipi"+mainApp.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		loginTab.setContent(loginPane);
		
		FXMLLoader loaderRegister = new FXMLLoader();
		loaderRegister.setLocation(LoginPaneController.class.getResource("RegisterTexts.fxml"));
		AnchorPane registerPane = null;
		try {
			registerPane = (AnchorPane) loaderRegister.load();
			RegisterTextController controller = loaderRegister.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		registerTab.setContent(registerPane);
		System.out.println("pa");
		tabPane.getTabs().addAll(loginTab, registerTab);
	}
	
	public void setMainApp(LoginController mainApp) {
		this.mainApp = mainApp;
		initialize();
	}
}
