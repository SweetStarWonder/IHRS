package presentation.hotelManager.hotel;

import controller.HotelManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import vo.HotelVO;

public class HotelDetailInformationController {

	@FXML
	private Label nameLabel;

	@FXML
	private Label addressLabel;

	@FXML
	private Label businessDistrictLabel;

	@FXML
	private Label partnersLabel;

	@FXML
	private Label introductionLabel;

	@FXML
	private Label facilityLabel;

	@FXML
	private Label starLabel;

	@FXML
	private Button modifyButton;

	private HotelManagerController mainApp;

	private HotelVO hotelVO;

	public HotelDetailInformationController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleModifyButton() {
		mainApp.modifyHotelInformation();
	}

	public void setMainApp(HotelManagerController mainApp) {
		this.mainApp = mainApp;
		this.hotelVO = mainApp.getHotel();
		nameLabel.setText(hotelVO.getHotelName());
		addressLabel.setText(hotelVO.getPosition());
		businessDistrictLabel.setText(hotelVO.getBusinessDistrict());
		String partnerStr = "";
		if (!hotelVO.getPartners().isEmpty()) {
			for (String str : hotelVO.getPartners()) {
				partnerStr += str;
				partnerStr += ";";
			}
			partnerStr = partnerStr.substring(0, partnerStr.length() - 1);			
		}
		partnersLabel.setText(partnerStr);
		introductionLabel.setText(hotelVO.getIntroduction());
		facilityLabel.setText(hotelVO.getFacility());
		starLabel.setText(hotelVO.getStarRating() + "");
	}
}
