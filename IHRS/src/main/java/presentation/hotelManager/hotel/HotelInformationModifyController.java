package presentation.hotelManager.hotel;

import java.util.ArrayList;

import org.controlsfx.control.Rating;

import controller.HotelManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import utility.VerifyUtility;
import vo.HotelVO;

public class HotelInformationModifyController {

	@FXML
	private Label nameLabel;

	@FXML
	private TextField adressTextField;

	@FXML
	private TextField businessDistrictTextField;

	@FXML
	private TextField partnerTextField;

	@FXML
	private TextArea introductionTextArea;

	@FXML
	private TextField facilityTextField;

	@FXML
	private AnchorPane starAnchorPane;

	@FXML
	private Button confirmButton;

	private Rating rating;

	private HotelManagerController controller;

	private HotelVO hotelVO;

	public HotelInformationModifyController() {

	}

	@FXML
	private void initialize() {
		rating = new Rating(5, 0);
		starAnchorPane.getChildren().add(rating);
	}

	@FXML
	private void handleConfirmButton() {
		String name = nameLabel.getText();
		String address = adressTextField.getText();
		String businessDistrict = businessDistrictTextField.getText();
		String partnersStr = partnerTextField.getText();
		String introduction = introductionTextArea.getText();
		String facility = facilityTextField.getText();
		int rate = (int) rating.getRating();

		if (name == null || address == null || businessDistrict == null || name.isEmpty() || address.isEmpty()
				|| businessDistrict.isEmpty()) {
			VerifyUtility.showWarning("信息不完整", "请完整填写酒店信息");
		} else {
			ArrayList<String> partnersList = new ArrayList<String>();
			if (partnersStr != null && !partnersStr.isEmpty()) {
				String[] partnerArray = partnersStr.split(";");
				for (int i = 0; i < partnerArray.length; i++) {
					partnersList.add(partnerArray[i]);
				}
			}
			hotelVO.setHotelName(name);
			hotelVO.setPosition(address);
			hotelVO.setBusinessDistrict(businessDistrict);
			hotelVO.setPartners(partnersList);
			hotelVO.setIntroduction(introduction);
			hotelVO.setFacility(facility);
			hotelVO.setStarRating(rate);
			if (controller.modifyHotelInformation(hotelVO)) {
				controller.backView();
				controller.backView();
				controller.showHotelInformation();
				VerifyUtility.showSuccessMessage("修改成功", "成功修改酒店信息");
			} else {
				VerifyUtility.showWarning("修改失败", "请检查网络连接");
			}
		}
	}

	public void setController(HotelManagerController controller) {
		this.controller = controller;
		this.hotelVO = controller.getHotel();
		nameLabel.setText(hotelVO.getHotelName());
		adressTextField.setText(hotelVO.getPosition());
		businessDistrictTextField.setText(hotelVO.getBusinessDistrict());
		String partnerStr = "";
		for (String str : hotelVO.getPartners()) {
			partnerStr += str;
			partnerStr += ";";
		}
		partnerStr = partnerStr.substring(0, partnerStr.length() - 1);
		partnerTextField.setText(partnerStr);
		introductionTextArea.setText(hotelVO.getIntroduction());
		facilityTextField.setText(hotelVO.getFacility());
		rating.setRating(hotelVO.getStarRating());
	}
}
