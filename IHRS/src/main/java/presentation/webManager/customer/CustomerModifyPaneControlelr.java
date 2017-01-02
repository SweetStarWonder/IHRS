package presentation.webManager.customer;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.VerifyUtility;
import vo.CustomerVO;

public class CustomerModifyPaneControlelr {
	
	
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
	
	public CustomerModifyPaneControlelr() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleConfirmButton() {
		String name = nameTextField.getText();
		String phone = phoneTextField.getText();
		if (name==null || phone==null
			|| name.isEmpty() || phone.isEmpty()) {
			VerifyUtility.showWarning("信息填写不完整", "请完整填写用户信息");
		} else if (phone.length()!=13 || !VerifyUtility.isInteger(phone)) {
			VerifyUtility.showWarning("???", "不要瞎鸡巴填手机号");
		} else {

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
		idLabel.setText(customerVO.getId()+"");
		nameTextField.setText(customerVO.getUserName());
		phoneTextField.setText(customerVO.getPhone());
	}
	
	
}
