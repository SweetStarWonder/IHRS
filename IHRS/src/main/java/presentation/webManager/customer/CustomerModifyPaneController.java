package presentation.webManager.customer;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.VerifyUtility;
import vo.CustomerVO;
import vo.NormalVipVO;

public class CustomerModifyPaneController {

	@FXML
	private Label idLabel;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField phoneTextField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private WebManagerController controller;

	private CustomerVO customerVO;

	public CustomerModifyPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleConfirmButton() {
		String name = nameTextField.getText();
		String phone = phoneTextField.getText();
		String tempName = customerVO.getUserName();
		String tempPhone = customerVO.getPhone();
		;
		if (name == null || phone == null || name.isEmpty() || phone.isEmpty()) {
			VerifyUtility.showWarning("信息填写不完整", "请完整填写用户信息");
		} else if (name.equals(tempName) && phone.equals(tempPhone)) {
			VerifyUtility.showWarning("未修改信息", "未修改任何信息");
		} else if (phone.length() != 11 || !VerifyUtility.isInteger(phone)) {
			VerifyUtility.showWarning("???", "不要瞎鸡巴填手机号");
		} else {
			customerVO.setUserName(name);
			customerVO.setPhone(phone);
			boolean modify = controller.modifyCustomer(customerVO);
			if (modify) {
				VerifyUtility.showSuccessMessage("修改成功", "成功修改用户" + customerVO.getId() + "的信息");
				dialogStage.close();
			} else {
				VerifyUtility.showWarning("修改失败", "该用户名已存在");
				customerVO.setUserName(tempName);
				customerVO.setPhone(phone);
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

	public void setCustomerVO(CustomerVO customerVO) {
		this.customerVO = customerVO;
		idLabel.setText(customerVO.getId() + "");
		nameTextField.setText(customerVO.getUserName());
		phoneTextField.setText(customerVO.getPhone());
	}

}
