package presentation.customer.init;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import vo.HotelVO;
import vo.RoomVO;

public class HotelCellController {

	@FXML
	private Hyperlink hotelNameHyperLink;

	@FXML
	private Label reservedLabel;

	@FXML
	private Label starLabel;

	@FXML
	private Label priceLabel;

	@FXML
	private Label rankLabel;

	@FXML
	private Button orderButton;

	private CustomerController mainApp;
	
	private HotelVO hotelVO;

	public HotelCellController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void showHotelDetailInformation() {
		mainApp.showHotelDetailInformation(hotelVO);
	}

	@FXML
	private void handleOrderButton() {
		mainApp.showGenerateList(hotelVO);
	}

	public void setMainApp(CustomerController mainApp) {
		this.mainApp = mainApp;
	}
	
	public void setHotel(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
		hotelNameHyperLink.setText(hotelVO.getHotelName());
		reservedLabel.setText(mainApp.getReservedHotelId().contains(hotelVO.getId()) ? "预定过" : "");
		starLabel.setText(hotelVO.getStarRating()+"星");
		rankLabel.setText(hotelVO.getAverageRank()+"分");
		int price = -1;
		for (RoomVO roomVO : hotelVO.getRooms()) {
			if (price<0 || (price>=0&&roomVO.getPrice()>price)) {
				price = roomVO.getPrice();
			}
		}
		priceLabel.setText(price>0?price+"元":"无");
	}
	
}
