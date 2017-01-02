package presentation.webManager.hotel;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import utility.VerifyUtility;
import vo.HotelManagerVO;

public class HotelManagerInformationPaneController {

	@FXML
	private Label idLabel;

	@FXML
	private Label nameLabel;

	@FXML
	private Label hotelLabel;

	@FXML
	private Label phoneLabel;

	@FXML
	private Button modifyButton;

	private WebManagerController mainApp;

	private HotelManagerVO hotelManagerVO;

	public HotelManagerInformationPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleModifyButton() {
		if (idLabel.getText() == null || idLabel.getText().isEmpty()) {
			VerifyUtility.showWarning("没有选中的用户", "请先搜索用户");
		} else {
			mainApp.modifyHotelManagerDialog(hotelManagerVO);
			idLabel.setText("");
			hotelLabel.setText("");
			nameLabel.setText("");
			phoneLabel.setText("");
		}

	}

	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
	}

	public void setHotelManager(HotelManagerVO hotelManagerVO) {
		this.hotelManagerVO = hotelManagerVO;
		idLabel.setText(hotelManagerVO.getId() + "");
		nameLabel.setText(hotelManagerVO.getUserName());
		hotelLabel.setText(hotelManagerVO.getHotelId() + "");
		phoneLabel.setText(hotelManagerVO.getPhone());
	}
}
