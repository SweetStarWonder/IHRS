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
import utility.VerifyUtility;
import vo.WebSaleVO;

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
		WebSaleVO webSaleVO;
		String id = userNameTextField.getText();
		if (id == null || id.isEmpty()) {
			VerifyUtility.showWarning("输入为空", "请输入用户编号");
		} else if (!VerifyUtility.isInteger(id) || id.length() != 5) {
			VerifyUtility.showWarning("格式错误", "用户编号为5位整数");
		} else {
			webSaleVO = mainApp.getWebSale(Integer.valueOf(id));
			if (webSaleVO == null) {
				VerifyUtility.showWarning("用户不存在", "请输入正确的用户编号");
			} else {
				showResult(webSaleVO);
			}
		}
	}

	private void showResult(WebSaleVO webSaleVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(WebSaleModifyPaneController.class.getResource("WebSaleInformationPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			WebSaleInformationPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
			controller.setWebSale(webSaleVO);
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
