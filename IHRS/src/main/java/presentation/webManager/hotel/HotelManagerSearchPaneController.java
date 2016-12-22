package presentation.webManager.hotel;

import java.io.IOException;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import presentation.webManager.webSale.WebSaleInformationPaneController;
import presentation.webManager.webSale.WebSaleModifyPaneController;

public class HotelManagerSearchPaneController {
	@FXML
	private Button addButton;
	
	@FXML
	private TextField userNameTextField;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private AnchorPane informationAnchorPane;
	
	private WebManagerController mainApp;
	
	public HotelManagerSearchPaneController() {
		
	}
	
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleAddButton() {
		mainApp.addHotelPane();
	}
	
	@FXML
	private void handleSearchButton() {
		showResult();
	}
	
	private void showResult() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerSearchPaneController.class.getResource("HotelManagerInformationPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			HotelManagerInformationPaneController controller = loader.getController();
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
