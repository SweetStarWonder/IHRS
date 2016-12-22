package presentation.webSale.recharge;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import presentation.webSale.TestWebSale;

public class CreditRechargePaneController {
	
	
	@FXML
	private TextField userIdTextField;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private AnchorPane informationAnchorPane;
	
	private TestWebSale mainApp;
	
	public CreditRechargePaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleSearchButton() {
		showSearchResult();
	}
	
	private void showSearchResult() {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CreditRechargePaneController.class.getResource("CustomerInformationPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
			CustomerInformationPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		informationAnchorPane.getChildren().clear();
		informationAnchorPane.getChildren().add(anchorPane);
		
	}
	
	public void setMainApp(TestWebSale mainApp) {
		this.mainApp = mainApp;
	}
}
