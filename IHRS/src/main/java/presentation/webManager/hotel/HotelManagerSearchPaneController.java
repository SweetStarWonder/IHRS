package presentation.webManager.hotel;

import java.io.IOException;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import presentation.webManager.webSale.WebSaleInformationPaneController;
import presentation.webManager.webSale.WebSaleModifyPaneController;
import utility.VerifyUtility;
import vo.HotelManagerVO;

public class HotelManagerSearchPaneController {
	@FXML
	private Button addButton;

	@FXML
	private TextField userNameTextField;

	@FXML
	private Button searchButton;

	@FXML
	private AnchorPane informationAnchorPane;

	private WebManagerController mainApp;

	public HotelManagerSearchPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleAddButton() {
		mainApp.addHotelPane();
	}

	@FXML
	private void handleSearchButton() {
		HotelManagerVO hotelManagerVO;
		String id = userNameTextField.getText();
		if (id == null || id.isEmpty()) {
			VerifyUtility.showWarning("输入为空", "请输入用户编号");
		} else if (!VerifyUtility.isInteger(id) || id.length() != 5) {
			VerifyUtility.showWarning("格式错误", "用户编号为5位整数");
		} else {
			hotelManagerVO = mainApp.getHotelManager(Integer.valueOf(id));
			if (hotelManagerVO == null) {
				VerifyUtility.showWarning("用户不存在", "请输入正确的用户编号");
			} else {
				showResult(hotelManagerVO);
			}
		}
	}

	private void showResult(HotelManagerVO hotelManagerVO) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelManagerSearchPaneController.class.getResource("HotelManagerInformationPane.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			HotelManagerInformationPaneController controller = loader.getController();
			controller.setMainApp(mainApp);
			controller.setHotelManager(hotelManagerVO);
		} catch (IOException e) {
			e.printStackTrace();
		}
		informationAnchorPane.getChildren().clear();
		informationAnchorPane.getChildren().add(anchorPane);
	}

	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
	}
}
