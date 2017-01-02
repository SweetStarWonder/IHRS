package presentation.customer.hotel;

import java.io.IOException;
import java.util.ArrayList;

import org.controlsfx.control.PopOver;

import controller.CustomerController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import po.RoomStatus;
import utility.VerifyUtility;
import vo.RoomVO;
import vo.HotelVO;

public class HotelDetailInformationController {

	@FXML
	private Label nameLabel;
	
	@FXML
	private Label adressLabel;

	@FXML
	private Label introductionLabel;

	@FXML
	private Label facilityLabel;

	@FXML
	private Label singleNumLabel;

	@FXML
	private Label singlePriceLabel;

	@FXML
	private Label doubleNumLabel;

	@FXML
	private Label doublePriceLabel;

	@FXML
	private Label tripleNumLabel;

	@FXML
	private Label triplePriceLabel;

	@FXML
	private Button viewEvaluateButton;
	
	@FXML
	private Button viewListButton;

	@FXML
	private Button purchaseButton;

	private CustomerController mainApp;
	
	private HotelVO hotelVO;
	
	ArrayList<Integer> reservedList = new ArrayList<Integer>();

	public HotelDetailInformationController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleViewEvaluateButton() {
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelDetailInformationController.class.getResource("HotelEvaluateListView.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
			HotelEvaluateController controller = loader.getController();
			controller.setUpperController(this);
			controller.setHotel(hotelVO);
		} catch (IOException e) {
			e.printStackTrace();
		}

		PopOver popOver = new PopOver(anchorPane);
		popOver.show(viewEvaluateButton);
	}

	@FXML
	private void handleViewListButton() {
		if (reservedList.contains(hotelVO.getId())) {
			mainApp.showHotelLists(hotelVO);
		} else {
			VerifyUtility.showWarning("查看失败", "你未在该酒店预定过");
		}
	}
	
	@FXML
	private void handlePurchaseButton() {
		mainApp.showGenerateList(hotelVO);
	}

	public void writeEvaluate() {
		if (reservedList.contains(hotelVO.getId())) {	
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(HotelDetailInformationController.class.getResource("EvaluateWritePane.fxml"));
			AnchorPane anchorPane = null;
			try {
				anchorPane = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
			Stage dialogStage = new Stage();
			dialogStage.initStyle(StageStyle.TRANSPARENT);
			dialogStage.initModality(Modality.WINDOW_MODAL);
			Scene scene = new Scene(anchorPane);
			dialogStage.setScene(scene);
			
			EvaluateWritePaneController controller = loader.getController();
			controller.setStage(dialogStage);
			controller.setHotel(hotelVO);
			controller.setController(mainApp);
			
			dialogStage.showAndWait();
		} else {
			VerifyUtility.showWarning("评论失败", "你未在该酒店预定过，无法评论");
		}
	}

	public void setMainApp(CustomerController mainApp) {
		this.mainApp = mainApp;
		reservedList.addAll(mainApp.getReservedHotelId());
	}
	
	public void setHotel(HotelVO hotelVO) {
		this.hotelVO = hotelVO;
		nameLabel.setText(hotelVO.getHotelName());
		adressLabel.setText(hotelVO.getPosition());
		introductionLabel.setText(hotelVO.getIntroduction());
		facilityLabel.setText(hotelVO.getFacility());
		ArrayList<RoomVO> roomVOs = hotelVO.getRooms();
		int singleNum = 0;
		int doubleNum = 0;
		int tripleNum = 0;
		singlePriceLabel.setText("-");
		doublePriceLabel.setText("-");
		triplePriceLabel.setText("-");
		for (RoomVO roomVO : roomVOs) {
			if (roomVO.getListId() == 0) {
				if (roomVO.getStatus().equals(RoomStatus.SINGLE)) {
					singleNum++;
					singlePriceLabel.setText(roomVO.getPrice()+"元");
				} else if (roomVO.getStatus().equals(RoomStatus.DOUBLE)) {
					doubleNum++;
					doublePriceLabel.setText(roomVO.getPrice()+"元");
				} else if (roomVO.getStatus().equals(RoomStatus.TRIPLE)) {
					tripleNum++;
					triplePriceLabel.setText(roomVO.getPrice()+"元");
				}
			}
		}
		singleNumLabel.setText(singleNum+"间");
		doubleNumLabel.setText(doubleNum+"间");
		tripleNumLabel.setText(tripleNum+"间");
	}
}
