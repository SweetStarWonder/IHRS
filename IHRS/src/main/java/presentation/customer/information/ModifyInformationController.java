package presentation.customer.information;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utility.VerifyUtility;
import vo.CustomerVO;

public class ModifyInformationController {

	@FXML
	private TextField usernameTextField;

	@FXML
	private TextField phoneTextField;

	@FXML
	private Label idLabel;
	
	@FXML
	private Label creditLabel;

	@FXML
	private Button confirmButton;
	
	private CustomerController controller;
	
	private CustomerVO customerVO;

	public ModifyInformationController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleConfirmButton() {
		String name = usernameTextField.getText();
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
			boolean modify = controller.modifyInformation(customerVO);
			if (modify) {
				VerifyUtility.showSuccessMessage("修改成功", "成功修改个人信息");
				controller.backView();
				controller.backView();
				controller.showPersonalInformation();
			} else {
				VerifyUtility.showWarning("修改失败", "该用户名已存在");
				customerVO.setUserName(tempName);
				customerVO.setPhone(phone);
			}
		}
	}
	
	public void setController(CustomerController controller) {
		this.controller = controller;
		this.customerVO = controller.getSelf();
		usernameTextField.setText(customerVO.getUserName());
		phoneTextField.setText(customerVO.getPhone());
		idLabel.setText(customerVO.getId()+"");
		creditLabel.setText(controller.getCredit()+"");
	}
}
