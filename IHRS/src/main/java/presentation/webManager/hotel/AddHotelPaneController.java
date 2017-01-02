package presentation.webManager.hotel;

import java.util.ArrayList;
import java.util.HashMap;

import org.controlsfx.control.Rating;

import controller.WebManagerController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utility.VerifyUtility;
import vo.HotelVO;

public class AddHotelPaneController {

	@FXML
	private TextField hotelNameTextField;

	@FXML
	private TextField hotelIdTextField;

	@FXML
	private ComboBox<String> addressComboBox;

	@FXML
	private ComboBox<String> businessDistrictComboBox;

	@FXML
	private TextArea introductionTextField;

	@FXML
	private TextField facilityTextField;

	@FXML
	private AnchorPane starAnchorPane;

	private Rating rating;

	@FXML
	private TextField userNameTextField;

	@FXML
	private TextField phoneTextField;

	@FXML
	private PasswordField passwordField;

	@FXML
	private Button confirmButton;

	private WebManagerController controller;

	private HashMap<String, ArrayList<String>> addressMap;

	private ObservableList<String> businessDistrictList;

	private ObservableList<String> addressList;

	public AddHotelPaneController() {

	}

	@FXML
	private void initialize() {
		rating = new Rating(5, 0);
		starAnchorPane.getChildren().add(rating);
		businessDistrictList = FXCollections.observableArrayList();
		addressList = FXCollections.observableArrayList();
		businessDistrictComboBox.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> {
					addressList.clear();
					addressList.addAll(addressMap.get(newValue));
					addressComboBox.setItems(addressList);
				});

	}

	@FXML
	private void handleConfirmButton() {
		String hotelName = hotelNameTextField.getText();
		String hotelId = hotelIdTextField.getText();
		String businessDistrict = businessDistrictComboBox.getSelectionModel().getSelectedItem();
		String address = addressComboBox.getSelectionModel().getSelectedItem();
		String introduction = introductionTextField.getText();
		String facility = facilityTextField.getText();
		int star = (int) rating.getRating();
		String userName = userNameTextField.getText();
		String phone = phoneTextField.getText();
		String password = passwordField.getText();

		if (hotelName == null || hotelId == null || userName == null || password == null || hotelName.isEmpty()
				|| hotelId.isEmpty() || userName.isEmpty() || password.isEmpty()) {
			VerifyUtility.showWarning("未填写完整信息", "请填写完整的酒店和酒店工作人员信息");
		} else if (businessDistrict == null || address == null || businessDistrict.isEmpty() || address.isEmpty()) {
			VerifyUtility.showWarning("未选择商圈地址", "请选择商圈和地址");
		} else if (hotelId.length() != 5 || !VerifyUtility.isInteger(hotelId)) {
			VerifyUtility.showWarning("酒店编号格式错误", "酒店编号为5位整数");
		} else if (phone.length() != 11 || !VerifyUtility.isInteger(phone)) {
			VerifyUtility.showWarning("???", "不要瞎鸡巴填手机号");
		} else {
			boolean add = controller.addHotel(
					new HotelVO(Integer.valueOf(hotelId), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(),
							new ArrayList<>(), hotelName, address, businessDistrict, star, introduction, facility, 0.0),
					userName, password, phone);
			if (add) {
				VerifyUtility.showSuccessMessage("添加成功", "已添加酒店" + hotelName + "和酒店管理人员" + userName);
				controller.backView();
			} else {
				VerifyUtility.showWarning("添加失败", "已存在酒店管理人员" + userName);
			}
		}
	}

	public void setMainApp(WebManagerController mainApp) {
		this.controller = mainApp;
	}

	public void setAddressMap(HashMap<String, ArrayList<String>> addressMap) {
		this.addressMap = addressMap;
		businessDistrictList.addAll(addressMap.keySet());
		businessDistrictComboBox.setItems(businessDistrictList);
	}

}
