package presentation.webManager.init;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class WebManagerRootLayoutController {

	@FXML
	private Button backButton;

	@FXML
	private MenuButton userNameMenuButton;

	@FXML
	private MenuItem modifyPasswordMenuItem;

	@FXML
	private MenuItem signoutMenuItem;

	private WebManagerController mainApp;

	public WebManagerRootLayoutController() {

	}

	@FXML
	private void initialize() {
		userNameMenuButton.setText("");
	}

	@FXML
	private void handleBackButton() {
		mainApp.backView();
	}

	@FXML
	private void handleModifyPasswordMenuItem() {

	}

	@FXML
	private void handleSignoutMenuItem() {
		mainApp.signOut();
	}

	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
		userNameMenuButton.setText(mainApp.getSelf().getUserName());
	}

}
