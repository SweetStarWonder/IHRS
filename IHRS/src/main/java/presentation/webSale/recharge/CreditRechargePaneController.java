package presentation.webSale.recharge;

import java.io.IOException;

import controller.WebSaleController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utility.VerifyUtility;
import vo.CustomerVO;

public class CreditRechargePaneController {

	@FXML
	private TextField userIdTextField;

	@FXML
	private Button searchButton;

	@FXML
	private AnchorPane informationAnchorPane;

	private WebSaleController mainApp;

	public CreditRechargePaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleSearchButton() {
		String idStr = userIdTextField.getText();
		if (idStr.length() != 5 || !VerifyUtility.isInteger(idStr)) {
			VerifyUtility.showWarning("格式错误", "用户编号为5位整数");
		} else {
			CustomerVO customerVO = mainApp.getCustomer(Integer.valueOf(idStr));
			if (customerVO == null) {
				VerifyUtility.showWarning("未找到用户", "不存在用户" + idStr);
			} else {
				showSearchResult(customerVO);
			}
		}
	}

	private void showSearchResult(CustomerVO customerVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CreditRechargePaneController.class.getResource("CustomerInformationPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = loader.load();
			CustomerInformationPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
			controller.setCustomer(customerVO);
		} catch (IOException e) {
			e.printStackTrace();
		}

		informationAnchorPane.getChildren().clear();
		informationAnchorPane.getChildren().add(anchorPane);

	}

	public void setMainApp(WebSaleController mainApp) {
		this.mainApp = mainApp;
	}
}
