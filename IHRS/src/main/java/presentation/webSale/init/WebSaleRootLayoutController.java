package presentation.webSale.init;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import presentation.webSale.TestWebSale;

public class WebSaleRootLayoutController {
	
	
	@FXML
	private Button rankButton;
	
	@FXML
	private MenuButton userNameLabel;
	
	@FXML
	private Button backButton;
	
	@FXML
	private MenuItem modifyPasswordMenuItem;
	
	@FXML
	private MenuItem signoutMenuItem;
	
	private TestWebSale mainApp;
	
	public WebSaleRootLayoutController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleBackButton() {
		mainApp.backView();
	}
	
	@FXML
	private void handleRankButton() {
		mainApp.showRankGrade();
	}
	
	@FXML
	private void handleModifyPasswordMenuItem() {
		
	}
	
	@FXML
	private void handleSignoutMenuItem() {
		
	}
	
	public void setMainApp(TestWebSale mainApp) {
		this.mainApp = mainApp;
	}
}
