package presentation.hotelManager.list;

import controller.HotelManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utility.VerifyUtility;
import vo.ListVO;

public class CheckOutPaneController {

	@FXML
	private DatePicker departTimeDatePicker;

	@FXML
	private TextField departHourTextField;

	@FXML
	private TextField departMinuteTextField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private ListViewController upperController;

	private ListVO listVO;

	private HotelManagerController controller;

	public CheckOutPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleConfirmButton() {
		String date = departTimeDatePicker.getValue().toString();
		String hour = departHourTextField.getText();
		String minute = departMinuteTextField.getText();
		if (date == null || hour == null || minute == null || date.isEmpty() || hour.isEmpty() || minute.isEmpty()) {
			VerifyUtility.showWarning("信息不完整", "请填写完整退房信息");
		} else if (!VerifyUtility.isInteger(hour) || !VerifyUtility.isInteger(minute)) {
			VerifyUtility.showWarning("格式错误", "小时和分钟应为整数");
		} else {
			int hourInt = Integer.valueOf(hour);
			int minuteInt = Integer.valueOf(minute);
			if (minuteInt > 60 || hourInt > 24) {
				VerifyUtility.showWarning("输入错误", "请输入正确的时间");
			} else {
				String formatedTime = date.substring(0, 4) + "/" + date.substring(5, 7) + "/" + date.substring(8) + " "
						+ hour + ":" + minute + ":00";
				listVO = controller.listCheckOut(listVO, formatedTime);
				dialogStage.close();
				VerifyUtility.showSuccessMessage("退房成功", "已为订单" + listVO.getListId() + "执行退房");
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

	public void setController(HotelManagerController controller) {
		this.controller = controller;
	}

	public void setUpperController(ListViewController upperController) {
		this.upperController = upperController;
	}

	public void setList(ListVO listVO) {
		this.listVO = listVO;
	}
}
