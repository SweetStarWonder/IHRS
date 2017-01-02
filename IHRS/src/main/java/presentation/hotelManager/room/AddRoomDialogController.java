package presentation.hotelManager.room;

import java.util.ArrayList;

import controller.HotelManagerController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import po.RoomStatus;
import utility.VerifyUtility;
import vo.RoomVO;

public class AddRoomDialogController {

	@FXML
	private ComboBox<String> statusComboBOx;

	@FXML
	private Label numLabel;

	@FXML
	private TextField beginTextField;

	@FXML
	private TextField endTextField;

	@FXML
	private TextField priceTextField;

	@FXML
	private Button confirmButton;

	@FXML
	private Button cancelButton;

	private Stage dialogStage;

	private HotelManagerController controller;

	private RoomManageController upperController;

	public AddRoomDialogController() {

	}

	@FXML
	private void initialize() {
		statusComboBOx.setItems(FXCollections.observableArrayList("单人间", "双人间", "三人间"));
		numLabel.setText("");
		endTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			calculateNum(beginTextField.getText(), newValue);
		});
	}

	private void calculateNum(String begin, String end) {
		int num = -1;
		if (!begin.isEmpty() && !end.isEmpty() && VerifyUtility.isInteger(begin) && VerifyUtility.isInteger(end)) {
			num = Integer.valueOf(end) - Integer.valueOf(begin);
		}
		if (num >= 0) {
			numLabel.setText("共" + (num + 1) + "间");
		} else {
			numLabel.setText("");
		}
	}

	@FXML
	private void handleConfirmButton() {
		if (numLabel.getText() == null || numLabel.getText().isEmpty()) {
			VerifyUtility.showWarning("格式错误", "请正确填写房间号");
		} else {
			String price = priceTextField.getText();
			String begin = beginTextField.getText();
			String end = endTextField.getText();
			if (price == null || price.isEmpty()) {
				VerifyUtility.showWarning("信息不完整", "请填写房间价格");
			} else if (!VerifyUtility.isInteger(price)) {
				VerifyUtility.showWarning("格式错误", "请正确填写价格");
			} else {
				ArrayList<RoomVO> roomVOs = new ArrayList<RoomVO>();
				int priceNum = Integer.valueOf(price);
				RoomStatus type = RoomStatus.SINGLE;
				switch (statusComboBOx.getSelectionModel().getSelectedIndex()) {
				case 0:
					type = RoomStatus.SINGLE;
					break;
				case 1:
					type = RoomStatus.DOUBLE;
					break;
				case 2:
					type = RoomStatus.TRIPLE;
					break;
				default:
					break;
				}
				for (int i = Integer.valueOf(begin); i < Integer.valueOf(end) + 1; i++) {
					roomVOs.add(new RoomVO(controller.getSelf().getHotelId(), 0, i, priceNum, type));
				}

				boolean add = controller.addRooms(roomVOs);
				if (add) {
					upperController.addRooms(roomVOs);
					dialogStage.close();
					VerifyUtility.showSuccessMessage("添加成功", "已添加" + numLabel.getText() + "客房");
				} else {
					VerifyUtility.showWarning("添加失败", "房间已存在");
				}
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

	public void setUpperController(RoomManageController upperController) {
		this.upperController = upperController;
	}
}
