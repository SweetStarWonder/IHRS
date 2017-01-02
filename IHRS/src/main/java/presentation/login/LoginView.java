package presentation.login;

import java.io.IOException;

import controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginView extends Application {

	private Stage primaryStage;

	private LoginController controller;

	public LoginView(LoginController controller) {
		this.controller = controller;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		initLoginPane();
	}

	private void initLoginPane() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(LoginView.class.getResource("LoginPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			LoginPaneController controller = loader.getController();
			controller.setMainApp(this.controller);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Scene scene = new Scene(anchorPane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
