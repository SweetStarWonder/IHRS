package presentation.webManager.hotel;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.VerifyUtility;
import vo.HotelManagerVO;

public class HotelManagerModifyPaneController {

	@FXML
	private Label idLabel;

	@FXML
	private TextField nameTextField;

	@FXML
	private Label hotelLabel;

	@FXML
	private TextField phoneTextField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private WebManagerController controller;

	private HotelManagerVO hotelManagerVO;

	public HotelManagerModifyPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleConfirmButton() {
		String name = nameTextField.getText();
		String phone = phoneTextField.getText();
		String tempName = hotelManagerVO.getUserName();
		String tempPhone = hotelManagerVO.getPhone();
		if (name == null || phone == null || name.isEmpty() || phone.isEmpty()) {
			VerifyUtility.showWarning("信息填写不完整", "请完整填写用户信息");
		} else if (name.equals(tempName) && phone.equals(tempPhone)) {
			VerifyUtility.showWarning("未修改信息", "未修改任何信息");
		} else if (phone.length() != 11 || !VerifyUtility.isInteger(phone)) {
			VerifyUtility.showWarning("???", "不要瞎鸡巴填手机号");
		} else {
			hotelManagerVO.setUserName(name);
			hotelManagerVO.setPhone(phone);
			boolean modify = controller.modifyHotelManager(hotelManagerVO);
			if (modify) {
				VerifyUtility.showSuccessMessage("修改成功", "成功修改用户" + hotelManagerVO.getId() + "的信息");
				dialogStage.close();
			} else {
				VerifyUtility.showWarning("修改失败", "该用户名已存在");
				hotelManagerVO.setUserName(tempName);
				hotelManagerVO.setPhone(phone);
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

	public void setHotelManager(HotelManagerVO hotelManagerVO) {
		this.hotelManagerVO = hotelManagerVO;
		idLabel.setText(hotelManagerVO.getId() + "");
		nameTextField.setText(hotelManagerVO.getUserName());
		hotelLabel.setText(hotelManagerVO.getHotelId() + "");
		phoneTextField.setText(hotelManagerVO.getPhone());
	}
}
