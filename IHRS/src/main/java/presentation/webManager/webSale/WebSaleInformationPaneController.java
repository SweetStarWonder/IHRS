package presentation.webManager.webSale;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import utility.VerifyUtility;
import vo.WebSaleVO;

public class WebSaleInformationPaneController {

	@FXML
	private Label idLabel;

	@FXML
	private Label nameLabel;

	@FXML
	private Label phoneLabel;

	@FXML
	private Button modifyButton;

	private WebManagerController mainApp;

	private WebSaleVO webSaleVO;

	public WebSaleInformationPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleModifyButton() {
		if (idLabel.getText() == null || idLabel.getText().isEmpty()) {
			VerifyUtility.showWarning("没有选中的用户", "请先搜索用户");
		} else {
			mainApp.modifyWebSaleDialog(webSaleVO);
			idLabel.setText("");
			nameLabel.setText("");
			phoneLabel.setText("");
		}
	}

	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
	}

	public void setWebSale(WebSaleVO webSaleVO) {
		this.webSaleVO = webSaleVO;
		idLabel.setText(webSaleVO.getId() + "");
		nameLabel.setText(webSaleVO.getUserName());
		phoneLabel.setText(webSaleVO.getPhone());
	}
}
