package presentation.webManager.webSale;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.VerifyUtility;
import vo.WebSaleVO;

public class WebSaleModifyPaneController {

	@FXML
	private Label idLabel;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField phoneTextField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private WebSaleVO webSaleVO;

	private WebManagerController controller;

	public WebSaleModifyPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleConfirmButton() {
		String name = nameTextField.getText();
		String phone = phoneTextField.getText();
		String tempName = webSaleVO.getUserName();
		String tempPhone = webSaleVO.getPhone();
		if (name == null || phone == null || name.isEmpty() || phone.isEmpty()) {
			VerifyUtility.showWarning("信息填写不完整", "请完整填写用户信息");
		} else if (name.equals(tempName) && phone.equals(tempPhone)) {
			VerifyUtility.showWarning("未修改信息", "未修改任何信息");
		} else if (phone.length() != 11 || !VerifyUtility.isInteger(phone)) {
			VerifyUtility.showWarning("???", "不要瞎鸡巴填手机号");
		} else {
			webSaleVO.setUserName(name);
			webSaleVO.setPhone(phone);
			boolean modify = controller.modifyWebSale(webSaleVO);
			if (modify) {
				VerifyUtility.showSuccessMessage("修改成功", "成功修改用户" + webSaleVO.getId() + "的信息");
				dialogStage.close();
			} else {
				VerifyUtility.showWarning("修改失败", "该用户名已存在");
				webSaleVO.setUserName(tempName);
				webSaleVO.setPhone(phone);
			}
		}
	}

	@FXML
	private void handleCancelButton() {
		dialogStage.close();
	}

	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public void setMainApp(WebManagerController controller) {
		this.controller = controller;
	}

	public void setWebSale(WebSaleVO webSaleVO) {
		this.webSaleVO = webSaleVO;
		idLabel.setText(webSaleVO.getId() + "");
		nameTextField.setText(webSaleVO.getUserName());
		phoneTextField.setText(webSaleVO.getPhone());
	}
}
