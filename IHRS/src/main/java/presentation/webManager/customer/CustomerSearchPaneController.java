package presentation.webManager.customer;

import java.io.IOException;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class CustomerSearchPaneController {

	
	@FXML
	private TextField userNameTextField;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private AnchorPane informationAnchorPane;
	
	private WebManagerController mainApp;
	
	public CustomerSearchPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleSearchButton() {
		showResult();
	}
	
	private void showResult() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerSearchPaneController.class.getResource("CustomerInformationPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			CustomerInformationPaneController controller = loader.getController();
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
