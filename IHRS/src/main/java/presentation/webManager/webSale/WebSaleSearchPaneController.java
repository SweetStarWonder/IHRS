package presentation.webManager.webSale;

import java.io.IOException;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import presentation.webManager.customer.CustomerInformationPaneController;
import presentation.webManager.customer.CustomerSearchPaneController;

public class WebSaleSearchPaneController {

	
	@FXML
	private Button addButton;
	
	@FXML
	private TextField userNameTextField;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private AnchorPane informationAnchorPane;
	
	private WebManagerController mainApp;
	
	public WebSaleSearchPaneController() {
		
	}
	
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleAddButton() {
		mainApp.addWebSaleDialog();
	}
	
	@FXML
	private void handleSearchButton() {
		showResult();
	}
	
	private void showResult() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleModifyPaneController.class.getResource("WebSaleInformationPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			WebSaleInformationPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		informationAnchorPane.getChildren().clear();
		informationAnchorPane.getChildren().add(anchorPane);
	}
	
	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
	}
}
