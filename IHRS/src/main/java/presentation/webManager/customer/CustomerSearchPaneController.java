package presentation.webManager.customer;

import java.io.IOException;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utility.VerifyUtility;
import vo.CustomerVO;

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
		CustomerVO customerVO;
		String id = userNameTextField.getText();
		if (id == null || id.isEmpty()) {
			VerifyUtility.showWarning("输入为空", "请输入用户编号");
		} else if (!VerifyUtility.isInteger(id) || id.length() != 5) {
			VerifyUtility.showWarning("格式错误", "用户编号为5位整数");
		} else {
			customerVO = mainApp.getCustomer(Integer.valueOf(id));
			if (customerVO == null) {
				VerifyUtility.showWarning("用户不存在", "请输入正确的用户编号");
			} else {
				showResult(customerVO);
			}
		}
	}

	private void showResult(CustomerVO customerVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CustomerSearchPaneController.class.getResource("CustomerInformationPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			CustomerInformationPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
			controller.setCustomer(customerVO);
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
